package com.java1234.c04jdbc.model;

/**
 * @author gaoxu
 * @date 2019-06-18 11:29
 * @description ... 类
 */
public class Student {
    private int id;
    private String name;
    private int age;


    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }


    public Student(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
