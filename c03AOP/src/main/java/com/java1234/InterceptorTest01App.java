package com.java1234;

import com.java1234.service.ServiceTest01;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InterceptorTest01App {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("04AopTest.xml");
        ServiceTest01 customerService = (ServiceTest01) ac.getBean("customerService");
        customerService.doSomething1();
    }
}
