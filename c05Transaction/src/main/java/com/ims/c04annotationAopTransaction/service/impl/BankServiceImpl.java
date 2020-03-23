package com.ims.c04annotationAopTransaction.service.impl;

import com.ims.c04annotationAopTransaction.dao.BankDao;
import com.ims.c04annotationAopTransaction.service.BankService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BankServiceImpl implements BankService {

    private BankDao bankDao;


    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    /**
     * 注解式事务管理
     *
     * @param count
     * @param userAId
     * @param userBId
     */
    @Override
    public void transferAccounts(int count, int userAId, int userBId) {
        // TODO Auto-generated method stub
        bankDao.outMoney(count, userAId);
        bankDao.inMoney(count, userBId);
    }


}
