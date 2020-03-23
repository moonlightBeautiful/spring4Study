package com.ims.c01noTransaction.service.impl;

import com.ims.c01noTransaction.service.BankService;
import com.ims.c04annotationAopTransaction.dao.BankDao;

/*@Transactional*/
public class BankServiceImpl implements BankService {

    private BankDao bankDao;

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }


    @Override
    public void transferAccounts(int count, int userAId, int userBId) {
        // TODO Auto-generated method stub
        bankDao.outMoney(count, userAId);
        bankDao.inMoney(count, userBId);
    }


}
