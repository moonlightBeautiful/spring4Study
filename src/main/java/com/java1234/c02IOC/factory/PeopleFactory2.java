package com.java1234.c02IOC.factory;


import com.java1234.c02IOC.entity.People;

public class PeopleFactory2 {

    public static People createPeople() {
        People p = new People();
        p.setId(6);
        p.setName("小6");
        p.setAge(16);
        return p;
    }
}
