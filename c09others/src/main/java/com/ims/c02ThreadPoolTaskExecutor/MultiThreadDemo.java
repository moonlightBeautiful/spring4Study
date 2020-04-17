package com.ims.c02ThreadPoolTaskExecutor;

/**
 * 2  * 多线程并发处理demo
 * 3  * @author daniel.zhao
 * 4  *
 * 5
 */
public class MultiThreadDemo implements Runnable {
    private String threadName;

    public MultiThreadDemo(String threadName) {
        super();
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(this.threadName + "线程执行开始！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.threadName + "线程执行结束！");
    }
}