package com.java1234.c05transaction.dao;

public interface BankDao {

    public void inMoney(int money, int userId);

    public void outMoney(int money, int userId);
}
