package com.ims;

import com.ims.entity.Hunter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class C03_AutoInjection {
    private ApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext("03autoInject.xml");//加载bean配置文件
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * bean类型自动注入：1.buName 2.byType 3.constructor
     */
    @Test
    public void autoInject() {
       /* Hunter hunter1 = (Hunter) ac.getBean("hunter1");
        System.out.println("bean类型自动注入byName：" + hunter1);*/

        /*Hunter hunter2 = (Hunter) ac.getBean("hunter2");
        System.out.println("bean类型自动注入byType：" + hunter2);*/

        Hunter hunter3 = (Hunter) ac.getBean("hunter3");
        System.out.println("bean类型自动注入constructor：" + hunter3);
    }

}
