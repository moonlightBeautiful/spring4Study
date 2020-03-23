package com.ims.c03xmlCache.service;


public interface BankService {

    /**
     * userA向userB转账count元
     *
     * @param count
     */
    int serviceA(int count);

    int serviceB(int count);

    void deleteCache();
}
