package com.ims;

import com.ims.c03xmlAopTransaction.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class C03xmlAopTransactionAppTest {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c03xmlAopTransaction.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccounts(5000, 1, 2);
    }
}
