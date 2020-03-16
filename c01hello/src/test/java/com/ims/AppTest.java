package com.ims;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testHello() {
        //ApplicationContext：IOC容器 ，加载bean配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("springContext.xml");

        //配置文件实例化Hello
        Hello hello = (Hello) ac.getBean("hello");
        hello.say();

    }
}
