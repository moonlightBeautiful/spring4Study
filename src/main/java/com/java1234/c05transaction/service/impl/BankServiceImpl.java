package com.java1234.c05transaction.service.impl;

import com.java1234.c05transaction.dao.BankDao;
import com.java1234.c05transaction.service.BankService;


public class BankServiceImpl implements BankService {

    private BankDao bankDao;

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    /*  *//**
     * 1.编程式事务编程需要用到TransactionTemplate
     *//*
    private TransactionTemplate myTransactionTemplate;

    public void setMyTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.myTransactionTemplate = transactionTemplate;
    }

    *//**
     * 1.编程式事务管理
     *
     * @param count
     * @param userIdA
     * @param userIdB
     *//*
    @Override
    public void transferAccounts(final int count, final int userIdA, final int userIdB) {
        // TODO Auto-generated method stub
        myTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                // TODO Auto-generated method stub
                bankDao.outMoney(count, userIdA);
                bankDao.inMoney(count, userIdB);
            }
        });
    }*/

    /**
     * 2.1切面式事务管理
     *
     * @param count
     * @param userIdA
     * @param userIdB
     */
    @Override
    public void transferAccounts(int count, int userIdA, int userIdB) {
        // TODO Auto-generated method stub
        bankDao.outMoney(count, userIdA);
        bankDao.inMoney(count, userIdB);
    }

    /**
     * 2.2注解式事务管理
     * @param count
     * @param userIdA
     * @param userIdB
     *//*
    @Override
    @Transactional
    public void transferAccounts(int count, int userIdA, int userIdB) {
        // TODO Auto-generated method stub
        bankDao.outMoney(count, userIdA);
        bankDao.inMoney(count, userIdB);
    }*/

}
