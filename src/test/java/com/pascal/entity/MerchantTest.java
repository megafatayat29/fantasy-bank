package com.pascal.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MerchantTest {

    @Test
    public void able_to_createAMerchant() {
        Merchant merchant = new Merchant("PLN", 100000, "io0979862etiuwt");
        assertNotNull(merchant);
    }

    @Test
    public void able_to_createAMerchant_with_given_information() {
        Merchant expectedMerchant = new Merchant("PLN", 100000, "io0979862etiuwt");
        Merchant actualMerchant = new Merchant("PLN", 100000, "io0979862etiuwt");
        assertEquals(expectedMerchant, actualMerchant);
    }

    @Test
    public void shouldNotEquals_when_compareDifferentMerchant_with_differentInformation() {
        Merchant expectedMerchant = new Merchant("PLN", 100000, "io0979862etiuwt");
        Merchant actualMerchant = new Merchant("PDAM", 150000, "io0979862etiuwt");
        assertNotEquals(expectedMerchant, actualMerchant);
    }

}