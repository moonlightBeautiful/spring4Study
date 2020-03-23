package com.ims;

import com.ims.c03xmlCache.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class C03xmlAppTest {

    @Test
    public void c02annotationCache() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c03xmlCache.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        for (int i = 1; i <= 10; i++) {
            bankService.serviceA(5);
            if(i == 7){
                bankService.deleteCache();
            }
        }
    }
}
