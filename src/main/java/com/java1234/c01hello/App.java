package com.java1234.c01hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //ApplicationContext：IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("c01beans.xml");//加载bean配置文件
        //配置文件实例化Hello
        Hello hello = (Hello) ac.getBean("hello");
        hello.say();

        //注解实例化Hello
        HelloWorld helloWorld = (HelloWorld) ac.getBean("helloWorld");
        helloWorld.say();

    }
}
