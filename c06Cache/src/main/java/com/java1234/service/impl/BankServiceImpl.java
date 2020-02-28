package com.java1234.service.impl;

import com.java1234.dao.BankDao;
import com.java1234.service.BankService;
import org.springframework.cache.annotation.Cacheable;

/*@Cacheable(value = "myCache")*/
public class BankServiceImpl implements BankService {

    private BankDao bankDao;

    private static int num = 1;

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }


    /**
     * 无事物管理，需要把@Cacheable注释掉
     *
     * @param count
     * @param userAId
     * @param userBId
     * @return
     */
    @Override
    public int transferAccounts(int count, int userAId, int userBId) {
        System.out.println("transferAccounts调用" + num + "次！");
        modeTst(count, userAId, userBId);
        return num++;
    }

    @Override
    public int modeTst(int count, int userAId, int userBId) {
        System.out.println("modeTst调用" + num + "次！");
        return num;
    }

    @Override
    public void deleteAll(){

    }
}
