AOP（Aspect Oriented Programming）面向切面编程的学习
    通知：插入切点后执行的动作。也就是切面的工作。什么和何时。
    连接点：程序运行的运行中，一个一个独立的方法是连接点，连接起来就是程序的运行。
    切点：连接点的前中后的位置为切点，可以插入通知。何处。
    切面 ：切面是通知和切点的集合
切面实现：
    通知有5种：
        1.前置通知：在方法执行之前执行的代码。
        2.后置通知：在方法执行之后执行的代码. 无论该方法是否出现异常（发生异常，则执行后置通知在输出异常）。
        3.环绕通知：在方法执行之前和之后执行的代码，如果出现异常，则之后的部分不执行。
        4.返回通知：方法执行完之后执行的代码.如果出现异常，则不执行。
        5.异常通知：方法执行发生异常时，执行。
    通知优先级：
        环绕通知（发生异常时，后半通知不执行）>前置通知>后置通知（发生异常时，照样执行）>异常通知>返回通知
    方式有2中
        1.xml式   
            <bean id="studentServiceAspect" class="com.java1234.c03AOP.advice.StudentServiceAspect"></bean>
            <aop:config>
                <aop:pointcut expression="execution(* com.java1234.c03AOP.service.*.*(..))" id="studentServicePointcut"/>
                <aop:aspect id="studentServiceAspect" ref="studentServiceAspect">
                    <aop:before method="doBefore" pointcut-ref="studentServicePointcut"/>
                    <aop:after method="doAfter" pointcut-ref="studentServicePointcut"/>
                    <aop:around method="doAround" pointcut-ref="studentServicePointcut"/>
                    <aop:after-returning method="doAfterReturning" pointcut-ref="studentServicePointcut"/>
                    <aop:after-throwing method="doAfterThrowing" pointcut-ref="studentServicePointcut" throwing="ex"/>
                </aop:aspect>
            </aop:config>
        2.注解式
            在切面类中使用
                @Aspect
                @Component
                @Pointcut("execution(* com.java1234.c03AOP.service.*.*(..))")
                @Before("pointcutName()")
            xml开启注解功能
                <!-- 注解扫描 -->
                <context:component-scan base-package="com.java1234.c03AOP.advice"/>
                <!-- 启动aop的注解解析器 -->
                <aop:aspectj-autoproxy/>