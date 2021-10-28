package com.pascal.service;

import com.pascal.entity.Wallet;
import com.pascal.repo.WalletRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class WalletServiceDbImplTest {

    @Autowired
    WalletService walletService;

    @Autowired
    WalletRepository walletRepository;

    @BeforeEach
    public void reset() {
        walletRepository.deleteAll();
    }

}