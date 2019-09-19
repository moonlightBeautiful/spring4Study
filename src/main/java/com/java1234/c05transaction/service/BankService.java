package com.java1234.c05transaction.service;

public interface BankService {


    /**
     * A向B转账金钱
     *
     * @param count
     * @param userIdA
     * @param userIdB
     */
    public void transferAccounts(int count, int userIdA, int userIdB);
}
