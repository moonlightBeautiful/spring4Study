#Study
1.IOC
    简介：
        控制反转（或者叫依赖注入），就是实例化类交给spring。     
    注入参数：实例化类的时候注入属性值。
        1.注入参数方式：类要有无参构造方法
            1.属性（setter）：类的属性要有setter方法，按照属性名匹配注入。
            2.构造器（构造方法）：类要有构造方法，按照构造方法参数的索引或类型或其组合来匹配注入。
            3.工厂（其他类的方法）：类的属性值来自工厂类方法的产生值。    
        2.注入参数类型：
            1.基本类型。
            2.bean类型：外部bean和内部bean。
            3.null类型。
            4.集合类型：list和set。
            5.Map类型。
            6.property类型。
        3.bean类型自动注入：默认不开启，开启头部加入default-autowire
            1.通过名自动注入，default-autowire=byName。
            2.通过类型自动注入，default-autowire=byType。
            3.通过构造器自动注入，default-autowire=constructor。
            不建议使用，很容易出错
        4.每次获取bean的范围：scope    
            1.singleton（默认）：单例，每次获取的bean都是同一个。
            2.prototype：多例，每次获取的bean都是新的。
            3.单例和多例组合使用：
                bean配置成单例，属性bean配置成多例。bean依然是单例。
                bean配置成单例，属性bean配置成多例。bean可以更改成多例：但是小峰工作这么多年，没用过
            4.request：每次http请求产生一个新bean
            5.session：同一个http session 共享一个bean
            6.global-session：同一个全局http session 共享一个bean
            7.application：同一个application 共享一个bean  
        5.bean之间的关系
            1.继承：
                如果大多数bean有相同的属性值，可以抽象出一个抽象bean，然后大多数继承这个抽象bean，大多数bean的就有相同的属性值了。
            2.引用：一直在用，就不说了。
            3.依赖：
                依赖的bean先实例化后，才能实例化自己。

        
    