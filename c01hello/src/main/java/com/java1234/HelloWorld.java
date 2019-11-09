package com.java1234;

import org.springframework.stereotype.Component;

/**
 * 通过注解来实例化HelloWorld
 */
@Component
public class HelloWorld {

    public void say() {
        System.out.println("Spring4大爷你好！helloWorld");
    }
}
