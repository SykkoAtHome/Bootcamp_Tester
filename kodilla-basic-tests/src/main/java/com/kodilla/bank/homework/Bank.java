package com.kodilla.bank.homework;

public class Bank {
    private CashMachine[] cashMachines;


    public Bank() {
        this.cashMachines = new CashMachine[0];
    }
    public void addCashMachine(CashMachine cashMachine) {
        CashMachine[] newCashMachines = new CashMachine[cashMachines.length + 1];
        System.arraycopy(cashMachines, 0, newCashMachines, 0, cashMachines.length);
        newCashMachines[cashMachines.length] = cashMachine;
        cashMachines = newCashMachines;
    }
    public int getTotalBalance() {
        int totalBalance = 0;
        for (CashMachine cashMachine : cashMachines) {
            totalBalance += cashMachine.getBalance();
        }
        return totalBalance;
    }
    public int getTotalWithdrawCount() {
        int totalWithdrawCount = 0;
        for (CashMachine cashMachine : cashMachines) {
            totalWithdrawCount += cashMachine.getWithdrawCount();
        }
        return totalWithdrawCount;
    }
    public int getTotalDepositCount() {
        int totalDepositCount = 0;
        for (CashMachine cashMachine : cashMachines) {
            totalDepositCount += cashMachine.getDepositCount();
        }
        return totalDepositCount;
    }
    public double getAverageWithdraw() {
        int totalWithdrawAmount = 0;
        int totalWithdrawCount = 0;
        for (CashMachine cashMachine : cashMachines) {
            totalWithdrawAmount += cashMachine.getCashMachineTotalWithdrawAmount();
            totalWithdrawCount += cashMachine.getWithdrawCount();
        }
        if (totalWithdrawCount == 0) {
            return 0;
        }
        return (double) totalWithdrawAmount / totalWithdrawCount;
    }
    public double getAverageDeposit() {
        int totalDepositAmount = 0;
        int totalDepositCount = 0;
        for (CashMachine cashMachine : cashMachines) {
            totalDepositAmount += cashMachine.getCashMachineTotalDepositAmount();
            totalDepositCount += cashMachine.getDepositCount();
        }
        if (totalDepositCount == 0) {
            return 0;
        }
        return (double) totalDepositAmount / totalDepositCount;
    }
}