package com.marceloserpa.twostack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.ToDoubleBiFunction;


public class ArithmeticExpressionProcessor {

    private Map<String, ToDoubleBiFunction<Double, Double>> operationsProcessor;

    public ArithmeticExpressionProcessor() {
        operationsProcessor =  new HashMap<>();
        operationsProcessor.put("+", (x, y) -> x + y);
        operationsProcessor.put("-", (x, y) -> x - y);
        operationsProcessor.put("/", (x, y) -> x / y);
        operationsProcessor.put("*", (x, y) -> x * y);
    }

    public Double process(String arithmeticExpression) {
        Stack<String> operations = new Stack<>();
        Stack<Double> values = new Stack<>();

        String[] tokens = arithmeticExpression.split("\\s+");
        Double result = 0D;
        for (String token : tokens) {
            switch (token) {
                case "(":
                    break;
                case "+":
                case "-":
                case "/":
                case "*":
                    operations.push(token);
                    break;
                case ")":
                    String operation = operations.pop();
                    Double second = values.pop();
                    Double first = values.pop();
                    result = operationsProcessor.get(operation).applyAsDouble(first, second);
                    values.push(result);
                    break;
                default:
                    try{
                        values.push(Double.valueOf(token));
                    } catch (NumberFormatException exception){
                       throw new RuntimeException(token + " is not supported", exception);
                    }
                    break;
            }
        }

        return result;
    }

}
