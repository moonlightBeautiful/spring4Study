package com.java1234.c03AOP.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Aspect + @Pointcut()这两个注解就相当于之前配置文件里下边的内
 * @Aspect相当于之前配置文件里下边的内容相当于之前配置文件里下边的内容 <bean id="studentServiceAspect" class="com.java1234.c03AOP.advice.StudentServiceAspect"></bean>
 * @Pointcut()相当于之前配置文件里下边的内容相当于之前配置文件里下边的内容 <aop:pointcut expression="execution(* com.java1234.c03AOP.service.*.*(..))" id="studentServicePointcut"/>
 * @Before()、@After()、@Around()、@After-returning、@After-throwing、相当于之前配置文件里下边的内容相当于之前配置文件里下边的内容 <aop:aspect id="studentServiceAspect" ref="studentServiceAspect">
 * <aop:before method="doBefore" pointcut-ref="studentServicePointcut"/>
 * <aop:after method="doAfter" pointcut-ref="studentServicePointcut"/>
 * <aop:around method="doAround" pointcut-ref="studentServicePointcut"/>
 * <aop:after-returning method="doAfterReturning" pointcut-ref="studentServicePointcut"/>
 * <aop:after-throwing method="doAfterThrowing" pointcut-ref="studentServicePointcut" throwing="ex"/>
 * </aop:aspect>
 */

@Aspect
@Component
public class StudentServiceAspect2 {

    @Pointcut("execution(* com.java1234.c03AOP.service.*.*(..))")
    public void pointcutName() {
    }

    /**
     * 切点执行之前的动作
     *
     * @param jp
     */
    @Before("pointcutName()")
    public void doBefore(JoinPoint jp) {
        System.out.println("前置通知");
        System.out.println("类名:" + jp.getTarget().getClass().getName());
        System.out.println("方法名：" + jp.getSignature().getName());
        System.out.println("开始添加学生：" + jp.getArgs()[0]);
    }

    /**
     * 切点执行之后的动作
     *
     * @param jp
     */
    public void doAfter(JoinPoint jp) {
        System.out.println("类名:" + jp.getTarget().getClass().getName());
        System.out.println("方法名：" + jp.getSignature().getName());
        System.out.println("学生添加完成：" + jp.getArgs()[0]);
    }

    /**
     * 切点执行之前后的动作。优先级比前置通知低和比后置通知高。
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("添加学生前");
        Object retVal = pjp.proceed();
        System.out.println(retVal);
        System.out.println("添加学生后");
        return retVal;
    }

    /**
     * 切点执行中返回之前执行的动作。如果void，则后置通知没啥区别。优先级比后置通知高和环绕通知高。
     *
     * @param jp
     */
    public void doAfterReturning(JoinPoint jp) {
        System.out.println("返回通知");
    }

    /**
     * 切点执行时发生异常后的动作。会屏蔽发生异常之后的动作。
     *
     * @param jp
     * @param ex
     */
    public void doAfterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("异常通知");
        System.out.println("异常信息：" + ex.getMessage());
    }
}
