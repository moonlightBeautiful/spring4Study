package com.ims;

import com.ims.c04annotationAopTransaction.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class C01noTransactionAppTest {

    @Test
    public void test() {
        //没有事物管理的时候，A向B转账，先执行转出，再执行转入。转出方法没问题，转入方法有问题。
        ApplicationContext ac = new ClassPathXmlApplicationContext("c01noTransaction.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccounts(50, 1, 2);
    }
}
