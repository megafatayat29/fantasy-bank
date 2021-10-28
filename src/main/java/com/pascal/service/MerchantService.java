package com.pascal.service;

import com.pascal.entity.Merchant;

public interface MerchantService {
    public Merchant create(Merchant merchant);
    public Merchant getById(String id);
    public void deleteById(String id);
    public Merchant update(Merchant merchant);
}
