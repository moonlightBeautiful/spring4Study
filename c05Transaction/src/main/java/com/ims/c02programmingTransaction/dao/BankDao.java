package com.ims.c02programmingTransaction.dao;

public interface BankDao {

    void inMoney(int money, int userId);

    void outMoney(int money, int userId);
}
