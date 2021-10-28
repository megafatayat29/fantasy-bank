package com.pascal.service;

import com.pascal.constant.ResponseMessage;
import com.pascal.entity.Merchant;
import com.pascal.entity.Transaction;
import com.pascal.entity.Wallet;
import com.pascal.exception.DataNotFoundException;
import com.pascal.exception.NotEnoughBalanceException;
import com.pascal.repo.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceDbImpl implements WalletService{

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    MerchantService merchantService;

    @Override
    public Wallet createWallet(Wallet wallet) {
        wallet.setAccount(accountService.getById(wallet.getAccountId()));
        return walletRepository.save(wallet);
    }

    @Override
    public String saveMoney(Transaction transaction) {
        Wallet wallet = walletRepository.getById(transaction.getWalletId());
        String message = wallet.save(transaction.getNominal());
        transaction.setType("Saving Money");
        walletRepository.save(wallet);
        return message + "\nIn wallet with username: "+wallet.getAccount().getUserName();
    }

    @Override
    public String withdrawMoney(Transaction transaction) {
        Wallet wallet = walletRepository.getById(transaction.getWalletId());
        if (wallet.getBalance() < transaction.getNominal()) {
            throw new NotEnoughBalanceException(String.format(ResponseMessage.NOT_ENOUGH_BALANCE,
                    wallet.getBalance(),transaction.getNominal()));
        }
        String message = wallet.withdraw(transaction.getNominal());
        transaction.setType("Withdraw Money");
        walletRepository.save(wallet);
        return message + "\nIn wallet with username: "+wallet.getAccount().getUserName();
    }

    @Override
    public Wallet getById(String id) {
        if (!walletRepository.findById(id).isPresent()) {
            throw new DataNotFoundException(String.format(ResponseMessage.DATA_NOT_FOUND,
                    Wallet.entityName, id));
        }
        return walletRepository.findById(id).get();
    }

    @Override
    public String payBill(String merchantId) {
        Merchant merchant = merchantService.getById(merchantId);
        Wallet wallet = merchant.getWallet();
        if (wallet.getBalance() < merchant.getBill()) {
            throw new NotEnoughBalanceException(String.format(ResponseMessage.NOT_ENOUGH_BALANCE_PAYBILL,
                    wallet.getBalance(),merchant.getBill()));
        }
        String message = wallet.payBill(merchant.getBill());
        merchant.setStatus("PAID");
        merchantService.update(merchant);
        walletRepository.save(wallet);
        return message + "\nTo merchant: "+merchant.getName()+"\nIn wallet with username: "+wallet.getAccount().getUserName();
    }
}
