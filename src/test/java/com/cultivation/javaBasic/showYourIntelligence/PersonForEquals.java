package com.cultivation.javaBasic.showYourIntelligence;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("unused")
public class PersonForEquals implements Comparable{
    private final String name;
    private final short yearOfBirth;

    public PersonForEquals(String name, short yearOfBirth) {
        if (name == null) {
            throw new IllegalArgumentException("name is mandatory.");
        }

        if (yearOfBirth <= 1900 || yearOfBirth >= 2019) {
            throw new IllegalArgumentException("year of birth is out of range.");
        }

        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }


    public String getName() {
        return name;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    @SuppressWarnings("Contract")
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        PersonForEquals that = (PersonForEquals) obj;
        return that.yearOfBirth == yearOfBirth && that.name.equals(name);
    }

    @Override
    public int hashCode() {
        // TODO: please modify the following code to pass the test
        // <--start
//        int result = yearOfBirth;
//        result = 31 * result + name.hashCode();
//        return result;
        return Objects.hash(name,yearOfBirth);
        // --end-->
    }

    @Override
    public int compareTo(Object obj) {
        if(obj == null)
            throw new NullPointerException();

        PersonForEquals that = (PersonForEquals) obj;

        int nameCompare = this.name.compareTo(that.name);
        if(nameCompare != 0){
            return nameCompare;
        }

        return yearOfBirth == that.yearOfBirth ? 0 : (yearOfBirth - that.yearOfBirth > 0 ? 1 : -1);
    }
}
