package com.java1234.c01hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //ApplicationContext：IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");//加载bean配置文件
        Hello helloWorld = (Hello) ac.getBean("helloWorld");//从bean配置文件获取helloWorld实例
        helloWorld.say();
    }
}
