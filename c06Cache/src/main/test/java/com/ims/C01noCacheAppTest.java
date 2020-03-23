package com.ims;

import com.ims.c01noCache.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class C01noCacheAppTest {

    @Test
    public void c01noCache() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c01noCache.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        for (int i = 1; i <= 10; i++) {
            bankService.serviceA(5);
        }
    }

}
