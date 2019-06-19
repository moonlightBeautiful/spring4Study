package com.java1234.c05transaction.service.impl;

import com.java1234.c05transaction.dao.BankDao;
import com.java1234.c05transaction.service.BankService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;


public class BankServiceImpl implements BankService {

    private BankDao bankDao;

    /*private TransactionTemplate transactionTemplate;*/

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }


    /*public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }*/

    /**
     * 编程式事务管理
     *
     * @param count
     * @param userIdA
     * @param userIdB
     *//*
    @Override
    public void transferAccounts(final int count, final int userIdA, final int userIdB) {
        // TODO Auto-generated method stub
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                // TODO Auto-generated method stub
                bankDao.outMoney(count, userIdA);
                bankDao.inMoney(count, userIdB);
            }
        });
    }
*/
    @Override
    @Transactional
    public void transferAccounts(int count, int userIdA, int userIdB) {
        // TODO Auto-generated method stub
        bankDao.outMoney(count, userIdA);
        bankDao.inMoney(count, userIdB);
    }

}
