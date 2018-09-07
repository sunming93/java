package com.cultivation.javaBasic.showYourIntelligence;

import com.cultivation.javaBasic.util.Person;
import com.cultivation.javaBasic.util.WithName;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class NameImpl implements WithName, Person {
    @Override
    public String getName() {
        // TODO: please modify the following code to pass the test
        // <--start
//        System.out.println(this.getClass().toString());
//        System.out.println(Person.super.toString());
//        System.out.println(WithName.super.toString());

        return Person.super.getName();
        // --end-->
    }
}
