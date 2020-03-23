package com.ims.c02programmingTransaction.service.impl;

import com.ims.c02programmingTransaction.service.BankService;
import com.ims.dao.BankDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/*@Transactional*/
public class BankServiceImpl implements BankService {

    private BankDao bankDao;

    //TransactionTemplate编程式事务需要
    private TransactionTemplate transactionTemplate;
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }


    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }


    @Override
    public void transferAccounts(final int count, final int userAId, final int userBId) {
        // TODO Auto-generated method stub
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                // TODO Auto-generated method stub
                bankDao.outMoney(count, userAId);
                bankDao.inMoney(count, userBId);
            }
        });
    }


}
