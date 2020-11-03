package com.marceloserpa.twostack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticExpressionProcessorTest {


    @Test
    public void test(){
        String arithmeticExpression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";

        ArithmeticExpressionProcessor processor = new ArithmeticExpressionProcessor();
        Double result = processor.process(arithmeticExpression);

        assertEquals(101.0D, result);
    }



}