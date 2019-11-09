package com.java1234.factory;


import com.java1234.entity.People;

public class PeopleFactory1 {

    public People createPeople() {
        People p = new People();
        p.setId(5);
        p.setName("小5");
        p.setAge(15);
        return p;
    }
}
