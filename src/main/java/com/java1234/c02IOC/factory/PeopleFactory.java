package com.java1234.c02IOC.factory;


import com.java1234.c02IOC.entity.People;

public class PeopleFactory {

    public People createPeople() {
        People p = new People();
        p.setId(5);
        p.setName("小5");
        p.setAge(15);
        return p;
    }
}
