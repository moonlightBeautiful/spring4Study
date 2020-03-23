package com.ims;

import com.ims.c04annotationAopTransaction.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class C04annotationAopAppTest {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c04annotationAopTransaction.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccounts(5000, 1, 2);
    }
}
