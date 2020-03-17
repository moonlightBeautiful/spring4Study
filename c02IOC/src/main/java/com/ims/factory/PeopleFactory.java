package com.ims.factory;


import com.ims.entity.People;

public class PeopleFactory {

    public People createPeople1() {
        People p = new People();
        p.setId(31);
        p.setName("小31");
        p.setAge(13);
        return p;
    }

    public static People createPeople2() {
        People p = new People();
        p.setId(32);
        p.setName("小32");
        p.setAge(13);
        return p;
    }
}
