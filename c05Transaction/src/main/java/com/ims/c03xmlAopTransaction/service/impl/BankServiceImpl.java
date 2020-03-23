package com.ims.c03xmlAopTransaction.service.impl;


import com.ims.c03xmlAopTransaction.dao.BankDao;
import com.ims.c03xmlAopTransaction.service.BankService;

public class BankServiceImpl implements BankService {

    private BankDao bankDao;

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }


    @Override
    public void transferAccounts(final int count, final int userAId, final int userBId) {
        // TODO Auto-generated method stub
        bankDao.outMoney(count, userAId);
        bankDao.inMoney(count, userBId);
    }

}
