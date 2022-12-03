package com.test.web3labs;

public interface BankingService {
    /**
     * Returns the amount of money in the account
     *
     * @param accountId id of an account, should be non-negative
     * @return the amount of money on the account
     */
    double getBalance(int accountId);

    /**
     * Withdraws the money from the account
     *
     * @param accountId id of an account, should be non-negative.
     * @param amount    amount of money to withdraw, should be a positive number.
     * @throws IllegalArgumentException if account does not exist, the amount is invalid or
     *                                  there is insufficient money on the account.
     */
    void withdraw(int accountId, double amount);

    /**
     * Deposit the money to the account
     *
     * @param accountId id of the account, should be non-negative.
     * @param amount    amount of money to deposit, should be a positive number.
     * @throws IllegalArgumentException if account does not exist or the amount is invalid.
     */
    void deposit(int accountId, double amount);
}
