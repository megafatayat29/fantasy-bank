package com.pascal.service;

import com.pascal.entity.Transaction;
import com.pascal.entity.Wallet;

public interface WalletService {
    public Wallet createWallet(Wallet wallet);
    public String saveMoney(Transaction transaction);
    public String withdrawMoney(Transaction transaction);
    public Wallet getById(String id);
    public String payBill(String merchantId);
}
