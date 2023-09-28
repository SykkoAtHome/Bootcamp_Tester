package com.kodilla.bank.homework;

public class Application {
    public static void main(String[] args) {
        Bank bank = new Bank();

        CashMachine euroNet = new CashMachine(10000);
        CashMachine planetCash = new CashMachine(10000);

        bank.addCashMachine(euroNet);
        bank.addCashMachine(planetCash);

        Transaction withdraw1 = new Transaction(-100);
        Transaction withdraw2 = new Transaction(-200);
        Transaction withdraw3 = new Transaction(-300);
        Transaction deposit1 = new Transaction(100);
        Transaction deposit2 = new Transaction(100);
        Transaction deposit3 = new Transaction(100);

        euroNet.processTransaction(withdraw1);
        euroNet.processTransaction(withdraw2);
        euroNet.processTransaction(withdraw3);
        euroNet.processTransaction(deposit1);
        euroNet.processTransaction(deposit2);
        euroNet.processTransaction(deposit3);

        planetCash.processTransaction(withdraw1);
        planetCash.processTransaction(withdraw1);
        planetCash.processTransaction(withdraw3);
        planetCash.processTransaction(deposit3);
        planetCash.processTransaction(deposit2);
        planetCash.processTransaction(deposit3);

        System.out.println("Total CashMachines balance: " + bank.getTotalBalance());
        System.out.println("Withdraw Total Count: " + bank.getTotalWithdrawCount());
        System.out.println("Deposit Total Count: " + bank.getTotalDepositCount());
        System.out.println("Withdraw Average Amount: " + bank.getAverageWithdraw());
        System.out.println("Deposit Average Amount: " + bank.getAverageDeposit());
    }
}
