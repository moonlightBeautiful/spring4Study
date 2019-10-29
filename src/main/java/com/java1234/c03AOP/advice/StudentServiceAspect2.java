/*
package com.java1234.c03AOP.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect + @Pointcut() + 各种通知注解
//      @Aspect：实例化切面类
//      @Pointcut()：定一个切点
//      各种通知注解@Before()、@After()、@Around()、@After-returning、@After-throwing：通知切点
@Aspect
@Component
public class StudentServiceAspect2 {

    @Pointcut("execution(* com.java1234.c03AOP.service.*.*(..))")
    public void pointcutName() {
    }

    */
/**
     * 前置通知：在方法执行之前执行的代码。
     *
     * @param jp
     *//*

    @Before("pointcutName()")
    public void doBefore(JoinPoint jp) {
        System.out.println("前置通知==============");
        */
/*System.out.println("类名:" + jp.getTarget().getClass().getName());
        System.out.println("方法名：" + jp.getSignature().getName());
        System.out.println("参数：" + jp.getArgs()[0]);*//*

    }

    */
/**
     * 后置通知：在方法执行之后执行的代码. 无论该方法是否出现异常（发生异常，则执行后置通知在输出异常）。
     *
     * @param jp
     *//*

    @After("pointcutName()")
    public void doAfter(JoinPoint jp) {
        System.out.println("后置通知==============");
        */
/*System.out.println("类名:" + jp.getTarget().getClass().getName());
        System.out.println("方法名：" + jp.getSignature().getName());
        System.out.println("参数：" + jp.getArgs()[0]);*//*

    }

    */
/**
     * 环绕通知：在方法执行之前和之后执行的代码，如果出现异常，则只执行前前面的通知，后面的通知不执行。
     *
     * @param pjp
     * @return
     * @throws Throwable
     *//*

    @Around("pointcutName()")
    public void doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知1==============");
        Object retVal = pjp.proceed();
        System.out.println("环绕通知2==============");
        */
/*System.out.println(retVal);
        return retVal;*//*

    }

    */
/**
     * 返回通知：方法执行完之后执行的代码.如果出现异常，则不执行。
     *
     * @param jp
     *//*

    @AfterReturning("pointcutName()")
    public void doAfterReturning(JoinPoint jp) {
        System.out.println("返回通知==============");
    }

    */
/**
     * 异常通知：方法执行发生异常时，执行。
     *
     * @param jp
     * @param ex
     *//*

    @AfterThrowing(value = "pointcutName()", throwing = "ex")
    public void doAfterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("异常通知=============");
    }
}
*/
