package com.java1234.c02IOC;

import com.java1234.c02IOC.entity.Dog;
import com.java1234.c02IOC.entity.Hunter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c02IOC/c02beans.xml");//加载bean配置文件

        /*
            注入参数方式3种：属性注入、构造方法注入、工厂注入
        */
        //无注入，属性采用默认值，int默认值0，String默认值null
        /*People people = (People) ac.getBean("people");
        System.out.println(people);*/

        //  属性注入
        /*People people1 = (People) ac.getBean("people1");
        System.out.println(people1);*/

        // 构造方法注入 - type
        /*People people2 = (People) ac.getBean("people2");
        System.out.println(people2);*/
        // 构造方法注入 - index
        /*People people3 = (People) ac.getBean("people3");
        System.out.println(people3);*/
        // 构造方法注入 - type和index
        /*People people4 = (People) ac.getBean("people4");
        System.out.println(people4);*/

        // 工厂方法注入   - 非静态方法
        /*People people5 = (People) ac.getBean("people5");
        System.out.println(people5);*/
        // 工厂方法注入   - 静态方法
        /*People people6 = (People) ac.getBean("people6");
        System.out.println(people6);*/

        /*
            注入参数类型6种：基本数据类型注入（不在演示，随处都能用到）、bean类型注入、null类型注入、级联注入、集合类型注入、Map类型注入
        */
        //注入类型是bean-外部注入
        /*Hunter hunter1 = (Hunter) ac.getBean("hunter1");
        System.out.println(hunter1);*/

        //注入类型是bean-内部注入
        /*Hunter hunter2 = (Hunter) ac.getBean("hunter2");
        System.out.println(hunter2);*/

        //注入类型是null
        /*Hunter hunter3 = (Hunter) ac.getBean("hunter3");
        System.out.println(hunter3);*/

        //级联注入
        /*Hunter hunter4 = (Hunter) ac.getBean("hunter4");
        System.out.println(hunter4);*/

        //集合和映射和property注入
       /* Hunter hunter5 = (Hunter) ac.getBean("hunter5");
        System.out.println(hunter5);*/

       /*
            bean的作用域2种：单例（默认）singleton和多例prototype
        */
        //单例（默认）singleton
        /*Dog myDog1 = (Dog) ac.getBean("myDog1");
        Dog myDog2 = (Dog) ac.getBean("myDog1");
        System.out.println("单例（默认）singleton，每次获取的bean都是一样的：");
        System.out.println(myDog1 == myDog2);*/
        //范围 多例 prototype
        /*Dog myDog3 = (Dog) ac.getBean("myDog2");
        Dog myDog4 = (Dog) ac.getBean("myDog2");
        System.out.println("多例（默认）prototype，每次获取的bean都是新的：");
        System.out.println(myDog3 == myDog4);*/
        //bean配置成单例，属性bean配置成多例。获取bean后，属性bean是单例，可以更改成多例
        /*Hunter hunter61 = (Hunter) ac.getBean("hunter6");
        Hunter hunter62 = (Hunter) ac.getBean("hunter6");
        System.out.println("外部bean是单例，注入的bean默认是单例的。");
        System.out.println(hunter61.getDog() == hunter62.getDog());*/
        //bean配置成单例，属性bean配置成多例。获取bean后，属性bean是单例，可以更改成多例
        // 1.bean改成抽象 2.属性bean的getter方法改成抽象的 3.如xml配置
        /*Hunter hunter71 = (Hunter) ac.getBean("hunter6");
        Hunter hunter72 = (Hunter) ac.getBean("hunter6");
        System.out.println("bean配置成单例，属性bean配置成多例。获取bean后，属性bean是单例，可以更改成多例：");
        System.out.println(hunter71.getDog() == hunter72.getDog());*/


        /*//继承
        Student zhangsan = (Student) ac.getBean("zhangsan");
        System.out.println(zhangsan);

        Student lisi = (Student) ac.getBean("lisi");
        System.out.println(lisi);*/

       /* //依赖
        Student wangwu = (Student) ac.getBean("wangwu");
        System.out.println(wangwu);

        //引用 不在测试*/


    }
}
