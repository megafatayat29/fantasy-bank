package com.pascal.service;

import com.pascal.entity.Account;

import java.util.List;

public interface AccountService {
    public Account register(Account account);
    public List<Account> getAll();
    public Account getById(String id);
    public void deleteById(String id);
    public Account update(Account account);
}
