AOP（Aspect Oriented Programming）面向切面编程
    简介：
        面向切面编程，可拔插，主要用作做日志、权限、事务、缓存等
    WhyAOP：
        耦合度低，不用侵入代码
    基本概念：
        连接点：程序运行的运行中，一个一个独立的方法是连接点，连接起来就是程序的运行。
        通知：可对指定的连接点运行前中后下达通知，通知是操作。
        切点：收到通知的连接点叫做切点。
        切面：通知和切点的集合。 其实我觉得叫做拦截器更好。      
通知：
    类型，有5种：
        1.前置通知：在方法执行之前执行。
        2.后置通知：在方法执行之后执行。（如果方法发生异常，则先执行后置通知在输出异常，这个是不是说明抛出异常也是方法执行完的一种方式）
        3.环绕通知：在方法执行之前和之后执行。（如果方法发生异常，则环绕通知之后的部分不执行）
        4.返回通知：方法执行完之后执行的代码。（如果方法发生异常，则返回通知不执行）
        5.异常通知：方法执行发生异常后执行。
    参数：
        ProceedingJoinPoint和JoinPoint
            可以获取切点的类和方法相关信息
    通知优先级：
        环绕通知、前置通知【按照配置顺序决定优先级，先配置优先级高】
        > 异常通知(发生异常时，环绕通知后半部分和返回通知无）
        > 环绕通知、后置通知、返回通知【按照配置顺序决定优先级，先配置优先级高】
通知方式有2中
    1.xml式：
        1.切面类，方法就是通知
        2.切面切入切点  
            <bean id="切面实例" class="com.java1234.c03AOP.advice.StudentServiceAspect"></bean>
            <aop:config>
                <aop:pointcut expression="execution(* com.java1234.service..*.*(..))" id="切点名"/>
                <aop:aspect id="切面名" ref="切面实例">
                    <aop:before method="切面的通知" pointcut-ref="切点名"/>
                    <aop:after-throwing method="切面的通知，异常通知特别一点" pointcut-ref="切点名" throwing="ex"/>
                </aop:aspect>
            </aop:config>
    2.编码注解式：先开启aop注解功能，然后使用注解定义切面、切点、通知
        在切面类中使用
            @Aspect  ：定义切面类
                类上使用
            @Pointcut("execution(* com.java1234.c03AOP.com.java1234.com.java1234.service.*.*(..))")
                切点，随便找个没有用的方法上使用
            @各种通知("pointcutName()")
                @Before()、@After()、@Around()、@After-returning、@After-throwing：
                通知，通知方法上使用
        xml开启注解功能
            <!-- 启动aop的注解解析器 -->
            <aop:aspectj-autoproxy/>
问题积累
    1.类中，方法A和方法B都是切点，方法A中调用方法B，默认只会拦截方法A。
        解决：
            1.不要出现“自调用”的情况：这是Spring文档中推荐的“最佳”方案；
            2.expose-proxy="true"，但是 我测试了 不管用
                <aop:aspectj-autoproxy expose-proxy="true" />
        所以
            使用1解决方案