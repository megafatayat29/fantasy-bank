package com.pascal.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    public void able_to_createATransaction() {
        Transaction transaction = new Transaction("idwallet7812673287", "idmerchant87291351234");
        assertNotNull(transaction);
    }

    @Test
    public void able_to_createATransaction_with_given_information() {
        Transaction expectedTransaction = new Transaction("idwallet7812673287", "idmerchant87291351234");
        Transaction actualTransaction = new Transaction("idwallet7812673287", "idmerchant87291351234");
        assertEquals(expectedTransaction, actualTransaction);
    }

    @Test
    public void shouldNotEquals_when_compareDifferentWallet_with_differentInformation() {
        Transaction expectedTransaction = new Transaction("idwallet7812673287", "idmerchant87291351234");
        Transaction actualTransaction = new Transaction("idwallet987123874327", "idmerchant87291351234");
        assertNotEquals(expectedTransaction, actualTransaction);
    }

}