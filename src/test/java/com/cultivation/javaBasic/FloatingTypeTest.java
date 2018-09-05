package com.cultivation.javaBasic;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FloatingTypeTest {
    @Test
    void should_not_get_rounded_result_if_convert_floating_number_to_integer() {
        final float floatingPointNumber = 2.75f;
        final int integer = (int) floatingPointNumber;

        // TODO: Please change the result to pass the test.
        // <!--start
        final int expected = 2;
        // --end-->

        assertEquals(expected, integer);
    }

    @Test
    void should_transite() {
        byte byteNum=0;
        short shortNum=1;
        int intNum=2;
        long longNum=3;
        float floatNum=4.1f;
        double doubleNum=5.1;

        byte byteNum1=(byte) shortNum;
        byte byteNum2=(byte) intNum;
        byte byteNum3=(byte) longNum;
        byte byteNum4=(byte) floatNum;
        byte byteNum5=(byte) doubleNum;

        short shortNum1=byteNum;
        short shortNum2=(short) intNum;
        short shortNum3=(short) intNum;
        short shortNum4=(short) intNum;
        short shortNum5=(short) intNum;

        int intNum1=byteNum;
        int intNum2=shortNum;
        int intNum3=(int) longNum;
        int intNum4=(int)floatNum;
        int intNum5=(int)doubleNum;

        long longNum1=byteNum;
        long longNum2=shortNum;
        long longNum3=intNum;
        long longNum4=(long) floatNum;
        long longNum5=(long) doubleNum;

        float floatNum1=byteNum;
        float floatNum2=shortNum;
        float floatNum3=intNum;
        float floatNum4=longNum;
        float floatNum5=(float) doubleNum;


        double doubleNum1=byteNum;
        double doubleNum2=shortNum;
        double doubleNum3=intNum;
        double doubleNum4=longNum;
        double doubleNum5=floatNum;

    }

    @SuppressWarnings({"divzero", "NumericOverflow"})
    @Test
    void should_judge_special_double_cases() {
        assertTrue(isInfinity(1d / 0d));
        assertTrue(isInfinity(-1d / 0d));
        assertFalse(isInfinity(2d));
        assertFalse(isInfinity(Double.NaN));

        assertTrue(isNan(0d / 0d));
        assertFalse(isNan(Double.NEGATIVE_INFINITY));
        assertFalse(isNan(Double.POSITIVE_INFINITY));
    }

    @Test
    void should_not_round_number_when_convert_to_integer() {
        final float floatingPointNumber = 2.75f;
        final int integer = (int) floatingPointNumber;

        // TODO: Please change the result to pass the test.
        // <!--start
        final int expected = 2;
        // --end-->

        assertEquals(expected, integer);
    }

    @SuppressWarnings("unused")
    @Test
    void should_round_number() {
        final double floatingPointNumber = 2.75;

        // TODO: Please call some method to round the floating point number.
        // <!--start
        final long rounded = Math.round(floatingPointNumber);
        // --end-->

        assertEquals(3L, rounded);
    }

    @SuppressWarnings("unused")
    private boolean isNan(double realNumber) {
        // TODO: please implement the method to pass the test.
        return Double.isNaN(realNumber);
    }

    @SuppressWarnings("unused")
    private boolean isInfinity(double realNumber) {
        // TODO: please implement the method to pass the test.
        return Double.isInfinite(realNumber);
    }

    /*
     * The coach should ask the following questions for the correspond test method:
     *
     * - Can we compare NaN using == directly?
     * - Can we compare XXX_INFINITY using == directly?
     */
}
