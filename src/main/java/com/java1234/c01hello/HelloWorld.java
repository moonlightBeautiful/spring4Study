package com.java1234.c01hello;

import org.springframework.stereotype.Component;

/**
 * 使用注解来实例化HelloWorld
 */
@Component
public class HelloWorld {
    public void say() {
        System.out.println("Spring4大爷你好！helloWorld");
    }
}
