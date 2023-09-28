package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTestSuite {
    @Test
    public void testAddCashMachine() {
        Bank bank = new Bank();
        CashMachine euroNet = new CashMachine(10000);
        CashMachine planetCash = new CashMachine(10000);

        assertEquals(0, bank.getCashMachines().length);

        bank.addCashMachine(euroNet);
        bank.addCashMachine(planetCash);

        assertEquals(2, bank.getCashMachines().length);
    }
    @Test
    public void testTotalBalance() {
        Bank bank = new Bank();
        CashMachine euroNet = new CashMachine(100);
        CashMachine planetCash = new CashMachine(100);
        bank.addCashMachine(euroNet);
        bank.addCashMachine(planetCash);
        assertEquals(200,bank.getTotalBalance());
    }
    @Test
    public void testTotalWithdrawCount() {
        Bank bank = new Bank();
        CashMachine euroNet = new CashMachine(1000);
        CashMachine planetCash = new CashMachine(1000);
        bank.addCashMachine(euroNet);
        bank.addCashMachine(planetCash);

        Transaction withdrawTransaction = new Transaction(-100);
        Transaction zero = new Transaction(0);

        euroNet.processTransaction(withdrawTransaction);
        euroNet.processTransaction(withdrawTransaction);
        planetCash.processTransaction(withdrawTransaction);
        euroNet.processTransaction(zero);

        assertEquals(3, bank.getTotalWithdrawCount());
    }
    @Test
    public void testTotalDepositCount() {
        Bank bank = new Bank();
        CashMachine euroNet = new CashMachine(0);
        CashMachine planetCash = new CashMachine(0);
        bank.addCashMachine(euroNet);
        bank.addCashMachine(planetCash);

        Transaction depositTransaction = new Transaction(100);
        Transaction zero = new Transaction(0);

        euroNet.processTransaction(depositTransaction);
        euroNet.processTransaction(depositTransaction);
        planetCash.processTransaction(depositTransaction);
        euroNet.processTransaction(zero);

        assertEquals(3, bank.getTotalDepositCount());
    }
    @Test
    public void testAverageWithdraw() {
        Bank bank = new Bank();
        CashMachine euroNet = new CashMachine(1000);
        CashMachine planetCash = new CashMachine(1000);
        bank.addCashMachine(euroNet);
        bank.addCashMachine(planetCash);

        Transaction withdrawTransaction1 = new Transaction(-127);
        Transaction withdrawTransaction2 = new Transaction(-79);
        Transaction withdrawTransaction3 = new Transaction(-212);
        Transaction withdrawTransaction4 = new Transaction(-59);
        Transaction zero = new Transaction(0);

        euroNet.processTransaction(withdrawTransaction1);
        euroNet.processTransaction(withdrawTransaction2);
        planetCash.processTransaction(withdrawTransaction3);
        planetCash.processTransaction(withdrawTransaction4);
        euroNet.processTransaction(zero);

        assertEquals(119.25, bank.getAverageWithdraw(), 0.01);
    }
    @Test
    public void testAverageDeposit() {
        Bank bank = new Bank();
        CashMachine euroNet = new CashMachine(1000);
        CashMachine planetCash = new CashMachine(1000);
        bank.addCashMachine(euroNet);
        bank.addCashMachine(planetCash);

        Transaction depositTransaction1 = new Transaction(90);
        Transaction depositTransaction2 = new Transaction(70);
        Transaction depositTransaction3 = new Transaction(34);
        Transaction depositTransaction4 = new Transaction(656);
        Transaction zero = new Transaction(0);

        euroNet.processTransaction(depositTransaction1);
        euroNet.processTransaction(depositTransaction2);
        planetCash.processTransaction(depositTransaction3);
        planetCash.processTransaction(depositTransaction4);
        euroNet.processTransaction(zero);

        assertEquals(212.5, bank.getAverageDeposit(), 0.01);
    }
}
