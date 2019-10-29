package com.java1234.c05transaction;

import com.java1234.c05transaction.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("c05transaction/c05beans.xml");//加载bean配置文件
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccounts(50, 1, 2);
    }
}
