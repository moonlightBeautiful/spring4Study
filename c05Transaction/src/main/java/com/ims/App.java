package com.ims;

import com.ims.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //没有事物管理的时候，A向B转账，先执行转出，再执行转入。转出方法没问题，转入方法有问题。
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans0.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccountsNoTransaction(50, 1, 2);

        //编程式事务管理
        /*ApplicationContext ac = new ClassPathXmlApplicationContext("beans1.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccountsCodingTransaction(50, 1, 2);*/

        //xml的AOP式事务管理
        /*ApplicationContext ac = new ClassPathXmlApplicationContext("beans2.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccountsXmlTransaction(50, 1, 2);*/

        //注解式事务管理
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("beans3.xml");
        BankService bankService = (BankService) ac.getBean("bankService");
        bankService.transferAccountsXmlTransaction(50, 1, 2);*/
    }
}
