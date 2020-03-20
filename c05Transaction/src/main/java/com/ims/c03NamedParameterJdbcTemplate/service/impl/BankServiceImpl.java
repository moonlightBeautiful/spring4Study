package com.ims.c03NamedParameterJdbcTemplate.service.impl;

import com.ims.c03NamedParameterJdbcTemplate.dao.BankDao;
import com.ims.c03NamedParameterJdbcTemplate.service.BankService;

/*@Transactional*/
public class BankServiceImpl implements BankService {

    private BankDao bankDao;

    //TransactionTemplate编程式事务需要
    /*private TransactionTemplate transactionTemplate;
*/
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
