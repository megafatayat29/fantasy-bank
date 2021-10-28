package com.pascal.service;

import com.pascal.constant.ResponseMessage;
import com.pascal.entity.Merchant;
import com.pascal.entity.Wallet;
import com.pascal.exception.DataNotFoundException;
import com.pascal.repo.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MerchantServiceDbImpl implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    WalletService walletService;

    @Override
    public Merchant create(Merchant merchant) {
        merchant.setWallet(walletService.getById(merchant.getWalletId()));
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant getById(String id) {
        if (!merchantRepository.findById(id).isPresent()) {
            System.out.println(merchantRepository.findById(id).isPresent());
            throw new DataNotFoundException(String.format(ResponseMessage.DATA_NOT_FOUND,
                    Merchant.entityName, id));
        }
        return merchantRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        merchantRepository.deleteById(id);
    }

    @Override
    public Merchant update(Merchant merchant) {
        return merchantRepository.save(merchant);
    }
}
