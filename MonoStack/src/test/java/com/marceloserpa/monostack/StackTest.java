package com.marceloserpa.monostack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void testCase1(){
        MonoStack stack = new MonoStack(5);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
    }

    @Test
    public void testCase2(){
        MonoStack stack = new MonoStack(5);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(1);

        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

}