package com.test.web3labs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class BankingServiceImpl implements BankingService {

    private static final Map<Integer, Double> amountByAccount = new HashMap<>();
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public BankingServiceImpl(double[] accounts) {
        IntStream.range(0, accounts.length).forEach(accountId ->
                amountByAccount.put(accountId, accounts[accountId]));
    }

    @Override
    public double getBalance(int accountId) {
        if (accountId < 0)
            throw new IllegalArgumentException("accountId is less than 0");
        double balance = 0.0;
        lock.readLock().lock();

        if (!amountByAccount.containsKey(accountId)) {
            throw new IllegalArgumentException("Account = " + accountId + " not exists");
        }

        balance = amountByAccount.get(accountId);
        lock.readLock().unlock();
        return balance;
    }

    @Override
    public void withdraw(int accountId, double amount) {
        if (accountId < 0 || amount <= 0)
            throw new IllegalArgumentException("Invalid params accountId/amount");
        lock.writeLock().lock();
        if (!amountByAccount.containsKey(accountId)) {
            throw new IllegalArgumentException("Account = " + accountId + " not exists");
        }

        double currentBalance = amountByAccount.get(accountId);

        if (currentBalance > amount) {
            amountByAccount.put(accountId, currentBalance - amount);
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
        lock.writeLock().unlock();
    }

    @Override
    public void deposit(int accountId, double amount) {
        if (accountId < 0 || amount <= 0 || !amountByAccount.containsKey(accountId))
            throw new IllegalArgumentException("Invalid params accountId/amount");
        lock.writeLock().lock();

        amountByAccount.put(accountId, amountByAccount.get(accountId) + amount);
        lock.writeLock().unlock();
    }

    public static void main(String[] args) {
        double [] accounts = {3.0, 5.0, 6.0};

        BankingService service = new BankingServiceImpl(accounts);
        service.withdraw(4, 12.0);
    }
}
