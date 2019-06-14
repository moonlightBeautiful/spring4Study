package com.java1234.c02IOC;

import com.java1234.c02IOC.entity.Hunter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //ApplicationContext：IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("c02beans.xml");//加载bean配置文件

      /*  // 属性注入
        People people1 = (People) ac.getBean("people1");
        System.out.println(people1);

        // 构造方法注入 - type
        People people2 = (People) ac.getBean("people2");
        System.out.println(people2);

        // 构造方法注入 - index
        People people3 = (People) ac.getBean("people3");
        System.out.println(people3);
        // 构造方法注入 - type和index
        People people4 = (People) ac.getBean("people4");
        System.out.println(people4);

        // 工厂方法注入
        People people5 = (People) ac.getBean("people5");
        System.out.println(people5);

        People people6 = (People) ac.getBean("people6");
        System.out.println(people6);*/

        //注入类型是bean-外部注入
        Hunter hunter1 = (Hunter) ac.getBean("hunter1");
        System.out.println(hunter1);

        //注入类型是bean-内部注入
        Hunter hunter2 = (Hunter) ac.getBean("hunter2");
        System.out.println(hunter2);

        //注入类型是null
        Hunter hunter3 = (Hunter) ac.getBean("hunter3");
        System.out.println(hunter3);

        //级联注入
        Hunter hunter4 = (Hunter) ac.getBean("hunter4");
        System.out.println(hunter4);

        //集合和映射注入
        Hunter hunter5 = (Hunter) ac.getBean("hunter5");
        System.out.println(hunter5);

    }
}
