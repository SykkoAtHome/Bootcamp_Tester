package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashMachineTestSuite {
    @Test
    public void testDeposit() {
        CashMachine cashMachine = new CashMachine(100);
        Transaction depositTransaction = new Transaction(100);

        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);

        assertEquals(600, cashMachine.getBalance());
        assertEquals(5, cashMachine.getDepositCount());
    }
    @Test
    public void testWithdraw() {
        CashMachine cashMachine = new CashMachine(1000);
        Transaction withdrawTransaction = new Transaction(-100);

        cashMachine.processTransaction(withdrawTransaction);
        cashMachine.processTransaction(withdrawTransaction);
        cashMachine.processTransaction(withdrawTransaction);
        cashMachine.processTransaction(withdrawTransaction);
        cashMachine.processTransaction(withdrawTransaction);
        cashMachine.processTransaction(withdrawTransaction);
        cashMachine.processTransaction(withdrawTransaction);
        cashMachine.processTransaction(withdrawTransaction);

        assertEquals(200, cashMachine.getBalance());
        assertEquals(8, cashMachine.getWithdrawCount());
    }
    @Test
    public void testProcessTransactionWithZero() {
        CashMachine cashMachine = new CashMachine(1000);
        Transaction zeroTransaction = new Transaction(0);

        cashMachine.processTransaction(zeroTransaction);

        assertEquals(1000, cashMachine.getBalance());
        assertEquals(0, cashMachine.getWithdrawCount());
        assertEquals(0, cashMachine.getDepositCount());
        assertEquals(0, cashMachine.getCashMachineTotalWithdrawAmount());
    }
    @Test
    public void testWithdrawAboveBalance() {
        CashMachine cashMachine = new CashMachine(100);
        Transaction withdrawTransaction = new Transaction(-200);

        cashMachine.processTransaction(withdrawTransaction);

        assertEquals(100, cashMachine.getBalance());
        assertEquals(0, cashMachine.getWithdrawCount());
        assertEquals(0, cashMachine.getCashMachineTotalWithdrawAmount());
    }
    @Test
    public void testCashMachineTotalWithdraw() {
        CashMachine cashMachine = new CashMachine(1000);
        Transaction withdrawTransaction = new Transaction(-100);

        cashMachine.processTransaction(withdrawTransaction);
        cashMachine.processTransaction(withdrawTransaction);

        assertEquals(200, cashMachine.getCashMachineTotalWithdrawAmount());
    }
    @Test
    public void testCashMachineTotalDeposit() {
        CashMachine cashMachine = new CashMachine(100);
        Transaction depositTransaction = new Transaction(100);

        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);

        assertEquals(200, cashMachine.getCashMachineTotalDepositAmount());
    }
    @Test
    public void testTransactionHistory() {
        CashMachine cashMachine = new CashMachine(100);
        Transaction depositTransaction = new Transaction(100);
        Transaction withdrawTransaction = new Transaction(-100);

        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(depositTransaction);
        cashMachine.processTransaction(withdrawTransaction);
        cashMachine.processTransaction(withdrawTransaction);

        assertEquals(8, cashMachine.getTransactionHistory().length);
    }
}
