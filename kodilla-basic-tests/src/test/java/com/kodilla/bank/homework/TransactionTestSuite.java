package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTestSuite {
    @Test
    public void testTransactionDepositAmount() {
        Transaction transaction = new Transaction(200);
        assertEquals(200, transaction.getAmount());
    }
    @Test
    public void testTransactionWithdrawAmount() {
        Transaction transaction = new Transaction(-200);
        assertEquals(-200, transaction.getAmount());
    }
}