#Study
    1.hello
        简介：
            由Rod Johnson创建的轻量级的JAVA开源框架，解决企业级应用开发的复杂性，代替EJB，	     
        2个核心思想：
            IOC（控制反转）和AOP（面向切面）。
        下载地址
            http://repo.springsource.org/libs-release-local/org/springframework/spring/
        实例化bean：
            1.xml中实例化bean
            2.注解实例化bean，但是在xml要开始组件扫描
                实例化bean注解有
                    @Component  entity
                    @Service：业务层
                    @Controller：WEB层
                    @Repository：持久层
                虽然分了层，但目前这四个注解的功能是一样的。实例化的默认值值是类名的开头小写
    2.ioc
        控制反转（或者叫依赖注入），就是实例化bean交给spring。
        1.注入参数方式：属性、构造器、工厂
        2.注入参数类型：基本类型、bean类型、null类型、集合类型、Map类型、property类型
        3.自动匹配装配bean：default-autowire，默认不开启。byName、byType、constructor
            不建议使用，很容易出错
        4.bean的作用域：scope    
            singleton（默认），单例，每次获取的bean都是同一个
            prototype，多例，每次获取的bean都是新的
                bean配置成单例，属性bean配置成多例。获取bean后，属性bean是单例，可以更改成多例。使用lookup-method，但是小峰工作这么多年，没用过
            request：每次http请求产生一个新bean
            session：同一个http session 共享一个bean
            global session：同一个全局http session 共享一个bean
            application：同一个application 共享一个bean  
        5.bean之间的关系
            继承：如果有一个bean的属性，大多数bean都要用到相同的属性，可以抽象这个bean，然后继承这个bean。
            引用：一直在用，就不说了。
            依赖：依赖的bean先实例化，在实例化自己。
    3.aop
        面向切面编程。主要用于：日志记录、安全管理、事务管理
            连接点：程序运行的运行中，一个一个独立的方法是连接点，连接起来就是程序的运行。
            通知：插入切点后执行的动作。什么和何时。
            切点：连接点的前中后的位置为切点。何处。
            切面：通知和切点的集合
        手动做日志记录：要在每个方法前后手写日志，麻烦。
        AOP做日志：方便
        