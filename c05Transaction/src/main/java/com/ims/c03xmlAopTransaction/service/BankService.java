package com.ims.c03xmlAopTransaction.service;

public interface BankService {

    /**
     * userA向userB转账count元
     *
     * @param count
     * @param userAId
     * @param userBId
     */

    void transferAccounts(int count, int userAId, int userBId);
}
