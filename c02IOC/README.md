#Study
1.IOC
    简介：
        控制反转（或者叫依赖注入），就是实例化类交给spring。     
    依赖注入：实例化类的时候注入属性值。
        1.注入方式：类要有显式的无参构造方法
            1.属性（setter）：类的属性要有setter方法，按照属性名匹配注入。
            2.构造器（构造方法）：类要有构造方法，按照构造方法参数的索引或类型或其组合来匹配注入。
            3.工厂（其他类的方法）：类的属性值来自工厂类方法的产生值。    
                工厂类方法有非静态和静态2种
        2.注入参数类型：
            1.基本类型。
            2.bean类型：外部bean和内部bean。
            3.null类型。
            4.级联类型：类属性必须 = new 实例化 
            5.集合（list、set）类型、映射（map）类型、property类型**
        3.bean类型自动注入：
            有beans 标签的default-autowire属性控制，默认值default。
            1.通过名自动注入，default-autowire=byName。
            2.通过类型自动注入，default-autowire=byType。  
                如果有多个类型相同的bean，则无法判断哪一个，报错。
            3.通过构造器自动注入，default-autowire=constructor。 
                要有对应的构造方法(Bean类型)，构造方法根据的是类型。
            不建议使用，很容易出错 
        4.bean之间的关系
            1.继承：
                如果大多数bean有相同的属性值，可以抽象出一个抽象bean，bean的abstract=true。
                然后大多数继承这个抽象bean，bean的parent=抽象bean的id，大多数bean的就有相同的属性值了。
            2.引用：
                一直在用，就不说了。
            3.依赖：
                依赖的bean先实例化后，才能实例化自己。 bean的 depends-on="依赖的bean"
        5.每次获取bean的范围：scope    
            1.singleton（默认）：单例，每次获取的bean都是同一个。
            2.prototype：多例，每次获取的bean都是新的。
            3.单例和多例组合使用：
                bean1配置成单例，属性bean2配置成多例。默认每次获取的bean1和属性bean2依然是单例。
                bean1配置成单例，属性bean2配置成多例。可以每次获取的bean1单例和属性bean2多例,使用方法注入，但是基本不用。
            4.request：每次http请求产生一个新bean
            5.session：同一个http session 共享一个bean
            6.global-session：同一个全局http session 共享一个bean
            7.application：同一个application 共享一个bean  
            4567了解即可
    额外小知识
        方法注入：
            简介
                实现每次获取bean是单例，bean的bean类型属性都是新的。
            使用
                0.猎人有狗属性，猎人scope是单例，狗scope是多例。
                1.猎人的getDoa方法改为抽象方法 public abstract Dog getDog(); 且类改成抽象类
                2.xml文件配置，
                    狗：<bean id="dog" class="com.java1234.entity.Dog" scope="prototype"></bean>
                    猎人的狗属性注入设置为：<lookup-method name="getDog" bean="dog"></lookup-method>
            很少很少使用，了解即可
        方法替换：
            简介
                人类和猎人都有狗属性，实例化猎人的时候，猎人的狗属性的getter方法调用人类的狗属性的getter方法。
            使用
                1.人类实现MethodReplacer接口，实现reimplement方法，返回getter方法的结果。
                2.xml文件配置，
                    人类：<bean id="people" class = "...."></bean
                    猎人的狗属性注入设置为 ：<replace-method name="getDog" replacer = "people""></replace-method>
            很少很少使用，了解即可    
            
    