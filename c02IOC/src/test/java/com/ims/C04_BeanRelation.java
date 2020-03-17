package com.ims;

import com.ims.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class C04_BeanRelation {
    private ApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext("04beanRelation.xml");//加载bean配置文件
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * bean类型自动注入：1.继承 2.引用 3.依赖
     */
    @Test
    public void beanRelation() {
        Student zhangSan = (Student) ac.getBean("zhangSan");
        System.out.println("继承：" + zhangSan);

        Student liSi = (Student) ac.getBean("liSi");
        System.out.println("依赖：" + liSi);
    }

}
