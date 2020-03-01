package com.java1234;

import com.java1234.entity.Dog;
import com.java1234.entity.Hunter;
import com.java1234.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class InjectionMethodTest1 {
    private ApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext("springContext.xml");//加载bean配置文件
    }

    @After
    public void tearDown() throws Exception {

    }



    /**
     * 每次获取bean的范围：1.单例 2.bean类型 3.nulll类型 4.集合类型 5.map类型 6.pro类型
     */
    @Test
    public void iocScope() {
        //1.单例（默认）singleton
        Dog myDog1 = (Dog) ac.getBean("myDog1");
        Dog myDog2 = (Dog) ac.getBean("myDog1");
        System.out.println("每次获取bean的范围，单例（默认）singleton，每次获取的bean都是一样的：" + (myDog1 == myDog2));
        //2.多例 prototype
        Dog myDog3 = (Dog) ac.getBean("myDog2");
        Dog myDog4 = (Dog) ac.getBean("myDog2");
        System.out.println("每次获取bean的范围，多例prototype，每次获取的bean都是新的：" + (myDog3 == myDog4));
        //3.bean配置成单例，属性bean配置成多例。bean依然是单例
        Hunter hunter61 = (Hunter) ac.getBean("hunter6");
        Hunter hunter62 = (Hunter) ac.getBean("hunter6");
        System.out.println("每次获取bean的范围，bean配置成单例，属性bean配置成多例，每次获取的bean都是一样的：" + (hunter61.getDog() == hunter62.getDog()));
        //bean配置成单例，属性bean配置成多例。获取bean后，属性bean是单例，可以更改成多例：bean改成抽象 2.属性bean的getter方法改成抽象的 3.如xml配置
    }

    /**
     * bean之间的关系：1.继承 2.引用 3.依赖
     */
    @Test
    public void iocBeanRelation() {
        //1.继承：如果大多数bean有相同的属性值，可以抽象出一个抽象bean，然后大多数继承这个抽象bean，大多数bean的就有相同的属性值了
        Student zhangsan = (Student) ac.getBean("zhangsan");
        System.out.println("张三：" + zhangsan);
        Student lisi = (Student) ac.getBean("lisi");
        System.out.println("李四：" + lisi);
        //2.引用  一直在用，就不说了
        //3.依赖
        Student wangwu = (Student) ac.getBean("wangwu");
        System.out.println("王五的实例化，依赖于autority的实例化" + wangwu);
    }
}
