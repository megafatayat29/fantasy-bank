package com.pascal.service;

import com.pascal.entity.Merchant;
import com.pascal.entity.Transaction;
import com.pascal.entity.Wallet;
import com.pascal.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class TransactionServiceDbImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    WalletService walletService;

    @Autowired
    MerchantService merchantService;

    @Override
    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        if (!(transaction.getMerchantId()==null)) {
            Merchant merchant = merchantService.getById(transaction.getMerchantId());
            transaction.setNominal(merchant.getBill());
            transaction.setType("Payment "+merchant.getName());
            transaction.setMerchant(merchant);
            transaction.setWallet(merchant.getWallet());
        } else {
            Wallet wallet = walletService.getById(transaction.getWalletId());
            transaction.setWallet(wallet);
        }
        transaction.setTxDate(new Date(System.currentTimeMillis()));
        return transactionRepository.save(transaction);
    }
}
