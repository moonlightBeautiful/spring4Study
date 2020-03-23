package com.ims;

import com.ims.c02programmingTransaction.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class C02programmingTransactionAppTest {

    @Test
    public void test() {
        //编程式事务管理
        ApplicationContext ac = new ClassPathXmlApplicationContext("c02programmingTransaction.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccounts(500, 1, 2);
    }
}
