package com.pascal.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void able_to_createAnAccount() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        assertNotNull(account);
    }

    @Test
    public void able_to_createAnAccount_with_given_information() {
        Account expectedAccount = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        Account actualAccount = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        assertEquals(expectedAccount, actualAccount);
    }

    @Test
    public void shouldNotEquals_when_compareDifferentAccount_with_differentInformation() {
        Account expectedAccount = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        Account actualAccount = new Account("Vincent", "vincent@gmail.com", "085677897821", "Jl. Dulu", "Anyong", "14068778921", "12345678", "vincentganteng");
        assertNotEquals(expectedAccount, actualAccount);
    }

}