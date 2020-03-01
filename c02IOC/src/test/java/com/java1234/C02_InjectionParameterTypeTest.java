package com.java1234;

import com.java1234.entity.Hunter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注入参数类型6种：
 * 1.基本类型。
 * 2.bean类型：外部bean和内部bean。
 * 3.null类型。
 * 4.集合类型：list和set。
 * 5.Map类型。
 * 6.property类型。
 */
public class C02_InjectionParameterTypeTest {
    private ApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext("02injectionParameterType.xml");
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * 1.基本数据类型 不举例
     */


    /**
     * 2.bean类型参数注入：外部bean和内部bean
     */
    @Test
    public void beanTypeParameterInjection() {
        Hunter hunter1 = (Hunter) ac.getBean("hunter21");
        System.out.println("bean类型（外部bean）注入：" + hunter1);

        Hunter hunter2 = (Hunter) ac.getBean("hunter22");
        System.out.println("bean类型（内部bean）注入：" + hunter2);
    }

    /**
     * 3.null类型参数注入
     */
    @Test
    public void nullTypeParameterInjection() {
        Hunter hunter3 = (Hunter) ac.getBean("hunter3");
        System.out.println("null类型注入：" + hunter3);
    }

    /**
     * 4.级联类型参数注入
     */
    @Test
    public void cascadeTypeParameterInjection() {
        Hunter hunter4 = (Hunter) ac.getBean("hunter4");
        System.out.println("级联类型注入：" + hunter4);
    }

    /**
     * 5.级联类型参数注入
     */
    @Test
    public void collectionMaoPropertyTypeParameterInjection() {
        Hunter hunter5 = (Hunter) ac.getBean("hunter5");
        System.out.println("list、set、map、property类型注入：" + hunter5);
    }
}
