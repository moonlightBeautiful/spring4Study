AOP（Aspect Oriented Programming）面向切面编程
    简介：不知道该怎么说，就是面向切面编程，可拔插，用作做日志、权限等
        连接点：程序运行的运行中，一个一个独立的方法是连接点，连接起来就是程序的运行。
        通知：可对指定的连接点运行前中后下达通知，通知是操作。
        切点：收到通知的连接点叫做切点。
        切面：通知和切点的集合。
通知：
    类型，有5种：
        1.前置通知：在方法执行之前执行。
        2.后置通知：在方法执行之后执行。（如果方法发生异常，则先执行后置通知在输出异常，这个是不是说明抛出异常也是方法执行完的一种方式）
        3.环绕通知：在方法执行之前和之后执行。（如果方法发生异常，则环绕通知之后的部分不执行）
        4.返回通知：方法执行完之后执行的代码。（如果方法发生异常，则返回通知不执行）
        5.异常通知：方法执行发生异常后执行。
    通知优先级：
        环绕通知（发生异常时，后半通知不执行）>前置通知>后置通知（发生异常时，照样执行）>异常通知>返回通知
通知方式有2中
    1.xml式：首先实例化切面，然后切入连接点（先定义切点+然后切面的通知通知切点）。  
        <bean id="studentServiceAspect" class="com.java1234.c03AOP.advice.StudentServiceAspect"></bean>
        <aop:config>
            <aop:pointcut expression="execution(* com.java1234.c03AOP.com.java1234.service.*.*(..))" id="studentServicePointcut"/>
            <aop:aspect id="studentServiceAspect" ref="studentServiceAspect">
                <aop:before method="doBefore" pointcut-ref="studentServicePointcut"/>
                <aop:after method="doAfter" pointcut-ref="studentServicePointcut"/>
                <aop:around method="doAround" pointcut-ref="studentServicePointcut"/>
                <aop:after-returning method="doAfterReturning" pointcut-ref="studentServicePointcut"/>
                <aop:after-throwing method="doAfterThrowing" pointcut-ref="studentServicePointcut" throwing="ex"/>
            </aop:aspect>
        </aop:config>
    2.注解式：先开启aop注解功能，然后使用注解定义切面、切点、通知
        在切面类中使用
            @Aspect
            @Component
            @Pointcut("execution(* com.java1234.c03AOP.com.java1234.service.*.*(..))")
            @Before("pointcutName()")
        xml开启注解功能
            <!-- 注解扫描 -->
            <context:component-scan base-package="com.java1234.c03AOP.advice"/>
            <!-- 启动aop的注解解析器 -->
            <aop:aspectj-autoproxy/>