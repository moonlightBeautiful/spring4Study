package com.ims.c03xmlAopTransaction.dao;

public interface BankDao {

    void inMoney(int money, int userId);

    void outMoney(int money, int userId);
}
