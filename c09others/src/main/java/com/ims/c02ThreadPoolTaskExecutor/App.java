package com.ims.c02ThreadPoolTaskExecutor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class App {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) ac.getBean("taskExecutor");
        int n = 20;
        for (int i = 0; i < n; i++) {
            taskExecutor.execute(new MultiThreadDemo(i + ""));
            System.out.println("i：" + i + ", 线程池活动线程数量为:" + taskExecutor.getActiveCount());
        }
    }
}
