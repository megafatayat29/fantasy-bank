package com.pascal.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    public void able_to_createAWallet() {
        Wallet wallet = new Wallet("Dana Pensiun", 10000000, "id897521463ewr671326tew7");
        assertNotNull(wallet);
    }

    @Test
    public void able_to_createAWallet_with_given_information() {
        Wallet expectedWallet = new Wallet("Dana Pensiun", 10000000, "id897521463ewr671326tew7");
        Wallet actualWallet = new Wallet("Dana Pensiun", 10000000, "id897521463ewr671326tew7");
        assertEquals(expectedWallet, actualWallet);
    }

    @Test
    public void shouldNotEquals_when_compareDifferentWallet_with_differentInformation() {
        Wallet expectedWallet = new Wallet("Dana Pensiun", 10000000, "id897521463ewr671326tew7");
        Wallet actualWallet = new Wallet("Dana Darurat", 10000000, "id897521463ewr671326tew7");
        assertNotEquals(expectedWallet, actualWallet);
    }
}