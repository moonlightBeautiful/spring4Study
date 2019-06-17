package com.java1234.c02IOC.entity;

/**
 * @author gaoxu
 * @date 2019-06-17 17:54
 * @description ... 类
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private String className;


    public Student() {
        System.out.println("初始化Student");
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    @Override
    public String toString() {
        return "People [id=" + id + ", name=" + name + ", age=" + age
                + ", className=" + className;
    }
}
