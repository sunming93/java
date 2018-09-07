package com.cultivation.javaBasic;

import com.cultivation.javaBasic.showYourIntelligence.NameImpl;
import com.cultivation.javaBasic.showYourIntelligence.PersonForEquals;
import com.cultivation.javaBasic.util.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InterfaceTest {

    @Test
    void should_support_default_method() {
        InterfaceWithDefaultMethodImpl instance = new InterfaceWithDefaultMethodImpl();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "The truth of the universe is 42";
        // --end-->

        assertEquals(expected, instance.tellMeTheTruthOfTheUniverse());
    }

    @Test
    void should_choose_override_method() {
        InterfaceWithOverrideDefaultImpl instance = new InterfaceWithOverrideDefaultImpl();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "The truth of the universe is Anime";
        // --end-->

        assertEquals(expected, instance.tellMeTheTruthOfTheUniverse());
    }

    @Test
    void should_choose_override_method_continued() {
        InterfaceExtendsInterfaceWithDefaultMethod instance = new InterfaceExtendsInterfaceWithDefaultMethodImpl();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "The truth of the universe is Game";
        // --end-->

        assertEquals(expected, instance.tellMeTheTruthOfTheUniverse());
    }

    @Test
    void should_resolve_ambiguity_by_yourself() {
        NameImpl instance = new NameImpl();
//        System.out.println(instance);

        String name = instance.getName();

        assertEquals("Person", name);
    }

    @Test
    void should_be_sorted() {
        PersonForEquals personForEquals1 = new PersonForEquals("Alice", (short) 1990);
        PersonForEquals personForEquals2 = new PersonForEquals("Bob", (short) 1991);
        PersonForEquals personForEquals3 = new PersonForEquals("Celin", (short) 1990);

        PersonForEquals[] personForEqualsArray = new PersonForEquals[]{personForEquals3, personForEquals2, personForEquals1};

        Arrays.sort(personForEqualsArray);

        assertArrayEquals(new PersonForEquals[]{personForEquals1,personForEquals2,personForEquals3},personForEqualsArray);
    }
}

/*
 * - Can you clone an object without a default constructor?
 */
