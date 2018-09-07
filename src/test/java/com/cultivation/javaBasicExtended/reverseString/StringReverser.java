package com.cultivation.javaBasicExtended.reverseString;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class StringReverser {
    @SuppressWarnings({"WeakerAccess", "unused"})
    public static String[] reverse(String input) {
        // TODO: please implement the method to pass all the tests.
        // <--start
        if(input == null)
            throw new IllegalArgumentException();

        if(input == "" || input.trim() == "") {
            return new String[0];
        }

        String[] reversed = input.split(" ");
        int length = reversed.length;

        for (int i = 0; i < length /2; i++) {
            String temp = reversed[i];
            reversed[i] = reversed[length-i-1];
            reversed[length-i-1] = temp;
        }

        return reversed;
        // --end-->
    }
}
