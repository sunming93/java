package com.cultivation.javaBasic;

import com.cultivation.javaBasic.util.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LambdaTest {
    @Test
    void should_apply_to_interface_with_single_abstract_method() {
        StringFunc lambda = () -> "Hello";

        // TODO: please modify the following code to pass the test
        // <--start
        final String expect = "Hello";
        // --end-->

        assertEquals(expect, lambda.getString());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_be_able_to_bind_to_instance_method() {
        // TODO: please bind lambda to instanceMethod.
        // <--start
        StringFunc lambda = this::instanceMethod;
        // --end-->

        assertEquals("instanceMethod", lambda.getString());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_be_able_to_bind_to_static_method() {
        // TODO: please bind lambda to staticMethod
        // <--start
        StringFunc lambda = LambdaTest::staticMethod;
        // --end-->

        assertEquals("staticMethod", lambda.getString());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_bind_to_constructor() {
        // TODO: please bind lambda to constructor of ArrayList<Integer>
        // <--start
        GenericFunc<ArrayList<Integer>> lambda = ArrayList::new;
        // --end-->

        ArrayList<Integer> value = lambda.getValue();

        assertEquals(0, value.size());
    }

    @Test
    void should_capture_variable_in_a_closure() {
        int captured = 5;

        StringFunc lambda = () -> captured + " has been captured.";

        final String message = lambda.getString();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "5 has been captured.";
        // --end-->

        assertEquals(expected, message);
    }

    @Test
    void should_evaluate_captured_variable_when_executing() {
        ValueHolder<String> value = new ValueHolder<>();
        value.setValue("I am the King of the world!");

        StringFunc lambda = () -> "The length of captured value is: " + value.getValue().length();

        // TODO: please write down the expected string directly.
        // <--start
        final String expected = "The length of captured value is: 4";
        // --end-->

        value.setValue("Blah");
        assertEquals(expected, lambda.getString());
    }

    @Test
    void should_extend_variable_scope() {
        StringFunc stringFunc = returnLambda();
        String message = stringFunc.getString();

        // TODO: please write down the expected string directly.
        // <--start
        final String expected = "In the year 2019";
        // --end-->

        assertEquals(expected, message);
    }

    @Test
    void should_capture_this_variable() {//this指的是定义时的环境的this
        ThisInClosure instance = new ThisInClosure();
        StringFunc stringFunc = instance.getLambda();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "ThisInClosure";
        // --end-->

        assertEquals(expected, stringFunc.getString());
    }

    private static StringFunc returnLambda() {
        int year = 2019;
        return () -> "In the year " + year;
    }

    @SuppressWarnings("unused")
    private static String staticMethod() {
        return "staticMethod";
    }

    @SuppressWarnings("unused")
    private String instanceMethod() {
        return "instanceMethod";
    }

    @Test
    void should_return_the_int() {
        IntSupplier intSupplier = () -> 1;
        int result = intSupplier.getAsInt();

        int expected = 1;
        assertEquals(expected,result);
    }

    @Test
    void should_return_the_char() {
        CharSupplier charSupplier = () -> 'a';
        char result = charSupplier.getAsChar();

        char expected = 'a';
        assertEquals(expected,result);
    }

    @Test
    void should_return_the_input() {
        IntFunctionalInterface intFunctionalInterface = n -> n;

        int result = intFunctionalInterface.apply(5);
        int expected = 5;
        assertEquals(expected,result);
    }

    @Test
    void should_return_the_sum() {
        IntBiFunction intBiFunction = (a,b) -> a+b;

        int result = intBiFunction.apply(1,2);
        int expected = 3;
        assertEquals(expected,result);
    }

    @Test
    void should_exchange_first_and_second_element() {
        Consumer consumer = n -> {
            if(n == null)
                return;

            if(n.length >= 2){
                int temp = n[0];
                n[0] = n[1];
                n[1] = temp;
            }
        };

        int[] n1= new int[]{1};
        consumer.accept(n1);
        assertArrayEquals(new int[]{1},n1);

        int[] n2= new int[]{1,2};
        consumer.accept(n2);
        assertArrayEquals(new int[]{2,1},n2);

        int[] n3 = new int[]{1,2,3};
        consumer.accept(n3);
        assertArrayEquals(new int[]{2,1,3},n3);
    }

    @Test
    void should_sum_the_array() {
        SummerFunction summer = n -> {
            if(n == null)
                return 0;

            int sum = 0;
            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }
            return sum;
        };

        int[] nullArray = null;
        assertEquals(0,summer.apply(nullArray));

        int[] oneElementArray = new int[]{1};
        assertEquals(1,summer.apply(oneElementArray));

        int[] fiveElementArray = new int[]{1,2,3,4,5};
        assertEquals(15,summer.apply(fiveElementArray));
    }
}

/*
 * - Do you think you can assign a lambda expression to an Object instance?
 */
