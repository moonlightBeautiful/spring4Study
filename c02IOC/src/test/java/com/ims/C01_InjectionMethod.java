package com.ims;

import com.ims.entity.People;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注入方式4种：1.属性注入、2.构造方法注入、3.工厂注入、4.级联注入
 */
public class C01_InjectionMethod {
    private ApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext("01injectionMethod.xml");
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * 0.无注入
     */
    @Test
    public void noInjection() {
        People people = (People) ac.getBean("people");
        System.out.println("无注入，使用默认值：" + people);
    }

    /**
     * 1.属性注入，实质setter方法
     */
    @Test
    public void propertyInjection() {
        People people1 = (People) ac.getBean("people1");
        System.out.println("属性注入：" + people1);
    }

    /**
     * 2.构造方法注入，实质constructor方法
     */
    @Test
    public void constructorInjection() {
        People people2 = (People) ac.getBean("people2");
        System.out.println("构造方法注入：" + people2);
    }

    /**
     * 3.工厂注入，1、工厂非静态方法 2、工厂静态方法
     */
    @Test
    public void factoryInjection() {
        People people31 = (People) ac.getBean("people31");
        System.out.println("工厂非静态方法注入：" + people31);

        People people32 = (People) ac.getBean("people32");
        System.out.println("工厂静态方法注入：" + people32);
    }

}
