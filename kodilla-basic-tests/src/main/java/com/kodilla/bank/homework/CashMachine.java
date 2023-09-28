package com.kodilla.bank.homework;

public class CashMachine {
    private int balance;
    private int depositCount;
    private int withdrawCount;

    private Transaction[] transactionHistory;

    public CashMachine(int balance) {
        this.balance = balance;
        this.transactionHistory = new Transaction[0];
        this.depositCount = 0;
        this.withdrawCount = 0;
    }
    public void processTransaction(Transaction transaction) {
        int amount = transaction.getAmount();
        if (amount > 0) {
            deposit(amount);
            this.depositCount++;
            addHistory(transaction);
        } else if (amount < 0 && -amount <= this.balance) {
            withdraw(-amount);
            this.withdrawCount++;
            addHistory(transaction);
        }
    }
    private void addHistory(Transaction transaction) {
        Transaction[] newTransactionHistory = new Transaction[transactionHistory.length+1];
        System.arraycopy(transactionHistory, 0, newTransactionHistory, 0, transactionHistory.length);
        newTransactionHistory[transactionHistory.length] = transaction;
        transactionHistory = newTransactionHistory;
    }
    public Transaction[] getTransactionHistory() {
        return transactionHistory;
    }
    int getBalance() {
        return balance;
    }
    private void deposit(int amount) {
        this.balance += amount;
    }
    private void withdraw(int amount) {
        this.balance -= amount;
    }
    public int getWithdrawCount() {
        return withdrawCount;
    }
    public int getDepositCount() {
        return depositCount;
    }
    public int getCashMachineTotalDepositAmount() {
        int totalDepositAmount = 0;
        for (Transaction transaction : transactionHistory) {
            if (transaction.getAmount() > 0) {
                totalDepositAmount += transaction.getAmount();
            }
        }
        return totalDepositAmount;
    }
    public int getCashMachineTotalWithdrawAmount() {
        int totalWithdrawAmount = 0;
        for (Transaction transaction : transactionHistory) {
            if (transaction.getAmount() < 0) {
                totalWithdrawAmount += transaction.getAmount();
            }
        }
        return -totalWithdrawAmount;
    }
}
