package com.java1234.c03AOP.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class StudentServiceAspect {

    /**
     * 切点执行之前的动作
     * @param jp
     */
    public void doBefore(JoinPoint jp) {
        System.out.println("类名:" + jp.getTarget().getClass().getName());
        System.out.println("方法名：" + jp.getSignature().getName());
        System.out.println("开始添加学生：" + jp.getArgs()[0]);
    }
    /**
     * 切点执行之后的动作
     * @param jp
     */
    public void doAfter(JoinPoint jp) {
        System.out.println("类名:" + jp.getTarget().getClass().getName());
        System.out.println("方法名：" + jp.getSignature().getName());
        System.out.println("学生添加完成：" + jp.getArgs()[0]);
    }

    /**
     * 切点执行之前后的动作。优先级比前置通知低和比后置通知高。
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
     * @param jp
     */
    public void doAfterReturning(JoinPoint jp) {
        System.out.println("返回通知");
    }

    /**
     * 切点执行时发生异常后的动作。会屏蔽发生异常之后的动作。
     * @param jp
     * @param ex
     */
    public void doAfterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("异常通知");
        System.out.println("异常信息：" + ex.getMessage());
    }
}
