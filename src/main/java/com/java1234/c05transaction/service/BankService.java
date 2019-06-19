package com.java1234.c05transaction.service;

public interface BankService {

	/**
	 * A��Bת��countԪ
	 * @param count
	 * @param userIdA
	 * @param userIdB
	 */
	public void transferAccounts(int count, int userIdA, int userIdB);
}
