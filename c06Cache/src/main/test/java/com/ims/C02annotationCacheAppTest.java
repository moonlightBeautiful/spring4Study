package com.ims;

import com.ims.c02annotationCache.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class C02annotationCacheAppTest {

    @Test
    public void c02annotationCache() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c02annotationCache.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        for (int i = 1; i <= 10; i++) {
            bankService.serviceA(5);
        }
    }
}
