package com.java1234.service.impl;

import com.java1234.service.ServiceTest01;

/**
 * 自调用测试
 */
public class ServiceTest01Impl implements ServiceTest01 {
    public void doSomething1() {
        System.out.println("CustomerServiceImpl.doSomething1()");
        doSomething2();
    }

    public void doSomething2() {
        System.out.println("CustomerServiceImpl.doSomething2()");
    }
}
