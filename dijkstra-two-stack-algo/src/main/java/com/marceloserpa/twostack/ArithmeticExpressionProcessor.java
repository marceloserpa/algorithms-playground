package com.marceloserpa.twostack;

import java.util.Stack;


public class ArithmeticExpressionProcessor {

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
                    System.out.println("Starting evaluation");
                    String operation = operations.pop();
                    Double second = values.pop();
                    Double first = values.pop();
                    String expression = String.format("%f %s %f", first, operation, second);
                    System.out.println(">>> " + expression);

                    switch (operation) {
                        case "+":
                            result = first + second;
                            break;
                        case "-":
                            result = first - second;
                            break;
                        case "/":
                            result = first / second;
                            break;
                        case "*":
                            result = first * second;
                            break;
                        default:
                            throw new RuntimeException("Operation " + operation + " is not supported");
                    }
                    values.push(result);
                    break;
                default:
                    values.push(Double.valueOf(token));
                    break;
            }
        }

        return result;
    }

}
