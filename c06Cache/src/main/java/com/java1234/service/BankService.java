package com.java1234.service;

import org.springframework.cache.annotation.Cacheable;


public interface BankService {

    /**
     * userA向userB转账count元
     *
     * @param count
     * @param userAId
     * @param userBId
     */
    int transferAccounts(int count, int userAId, int userBId);

    int modeTst(int count, int userAId, int userBId);

    void deleteAll();
}