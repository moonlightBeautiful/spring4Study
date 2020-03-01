package com.java1234;

import com.java1234.entity.Dog;
import com.java1234.entity.Hunter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class C05_BeanScope {
    private ApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext("05beanScope.xml");//加载bean配置文件
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * 每次获取bean的范围：1.单例 2.bean类型 3.nulll类型 4.集合类型 5.map类型 6.pro类型
     */
    @Test
    public void beanScope() {
        //1.单例（默认）singleton
        Dog myDog11 = (Dog) ac.getBean("myDog1");
        Dog myDog12 = (Dog) ac.getBean("myDog1");
        System.out.println("单例（默认）singleton，每次获取的bean都是一样的：" + (myDog11 == myDog12));

        //2.多例 prototype
        Dog myDog21 = (Dog) ac.getBean("myDog2");
        Dog myDog22 = (Dog) ac.getBean("myDog2");
        System.out.println("多例prototype，每次获取的bean都是新的：" + (myDog21 == myDog22));

        //3.bean配置成单例，属性bean配置成多例。bean依然是单例
       /* Hunter hunter31 = (Hunter) ac.getBean("hunter3");
        Hunter hunter32 = (Hunter) ac.getBean("hunter3");
        System.out.println("bean1配置成单例，属性bean2配置成多例。默认每次获取的bean1和属性bean2依然是单例：" + (hunter31 == hunter32));
        System.out.println("bean1配置成单例，属性bean2配置成多例。默认每次获取的bean1和属性bean2依然是单例：" + (hunter32.getDog() == hunter32.getDog()));*/

        //4.bean1配置成单例，属性bean2配置成多例。可以每次获取的bean1单例和属性bean2多例,使用方法注入，但是基本不用。
        Hunter hunter41 = (Hunter) ac.getBean("hunter4");
        Hunter hunter42 = (Hunter) ac.getBean("hunter4");
        System.out.println("bean1配置成单例，属性bean2配置成多例。默认每次获取的bean1和属性bean2依然是单例：" + (hunter41 == hunter42));
        System.out.println("bean1配置成单例，属性bean2配置成多例。默认每次获取的bean1和属性bean2依然是单例：" + (hunter41.getDog() == hunter42.getDog()));
      }

}
