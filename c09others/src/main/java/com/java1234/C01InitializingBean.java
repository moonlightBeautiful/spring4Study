package com.java1234;

import org.springframework.beans.factory.InitializingBean;

public class C01InitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("在初始化bean的时候都会执行该方法afterPropertiesSet");
    }

    public void testInit() {
        System.out.println("测试 init-method");
    }
}
