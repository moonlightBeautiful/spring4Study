package com.java1234.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.java1234.dao.BankDao;
import com.java1234.service.BankService;

/*@Transactional*/
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
     * 无事物管理
     *
     * @param count
     * @param userAId
     * @param userBId
     */
    @Override
    public void transferAccountsNoTransaction(int count, int userAId, int userBId) {
        // TODO Auto-generated method stub
        bankDao.outMoney(count, userAId);
        bankDao.inMoney(count, userBId);
    }

    @Override
    public void transferAccountsCodingTransaction(final int count, final int userAId, final int userBId) {
        /*// TODO Auto-generated method stub
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                // TODO Auto-generated method stub
                bankDao.outMoney(count, userAId);
                bankDao.inMoney(count, userBId);
            }
        });*/
    }

    @Override
    public void transferAccountsXmlTransaction(final int count, final int userAId, final int userBId) {
        // TODO Auto-generated method stub
        bankDao.outMoney(count, userAId);
        bankDao.inMoney(count, userBId);
    }

}
