package com.java1234.service;

public interface BankService {

    /**
     * userA向userB转账count元
     *
     * @param count
     * @param userAId
     * @param userBId
     */
    void transferAccountsNoTransaction(int count, int userAId, int userBId);

    void transferAccountsCodingTransaction(int count, int userAId, int userBId);

    void transferAccountsXmlTransaction(int count, int userAId, int userBId);
}
