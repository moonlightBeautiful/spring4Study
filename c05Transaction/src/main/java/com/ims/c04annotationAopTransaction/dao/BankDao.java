package com.ims.c04annotationAopTransaction.dao;

public interface BankDao {

    void inMoney(int money, int userId);

    void outMoney(int money, int userId);
}
