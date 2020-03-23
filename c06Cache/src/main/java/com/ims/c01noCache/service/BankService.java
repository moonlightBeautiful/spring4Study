package com.ims.c01noCache.service;


public interface BankService {

    /**
     * userA向userB转账count元
     *
     * @param count
     */
    int serviceA(int count);

    int serviceB(int count);

}
