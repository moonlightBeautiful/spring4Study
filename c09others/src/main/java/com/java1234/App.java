package com.java1234;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
     

    }
}
