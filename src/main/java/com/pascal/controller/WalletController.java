package com.pascal.controller;

import com.pascal.entity.Transaction;
import com.pascal.entity.Wallet;
import com.pascal.service.TransactionService;
import com.pascal.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class WalletController {
    @Autowired
    WalletService walletService;

    @Autowired
    TransactionService transactionService;

    @PostMapping("/wallet")
    public Wallet createWallet(@Valid @RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    @PostMapping("/saving")
    public String savingMoney(@RequestBody Transaction transaction) {
        transactionService.createTransaction(transaction);
        return walletService.saveMoney(transaction);
    }

    @PostMapping("/withdrawal")
    public String withdrawMoney(@RequestBody Transaction transaction) {
        transactionService.createTransaction(transaction);
        return walletService.withdrawMoney(transaction);
    }

    @PostMapping("/bill-payment")
    public String payBill(@RequestBody Transaction transaction) {
        transactionService.createTransaction(transaction);
        return walletService.payBill(transaction.getMerchantId());
    }
}
