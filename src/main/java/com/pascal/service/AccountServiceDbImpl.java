package com.pascal.service;

import com.pascal.constant.ResponseMessage;
import com.pascal.entity.Account;
import com.pascal.entity.Wallet;
import com.pascal.exception.DataNotFoundException;
import com.pascal.exception.UsernameAlreadyUsed;
import com.pascal.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AccountServiceDbImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Account register(Account account) {
        if (accountRepository.existsByUserName(account.getUserName())) {
            throw new UsernameAlreadyUsed(String.format(ResponseMessage.USERNAME_ALREADY_USED, account.getUserName()));
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(String id) {
        if (!accountRepository.findById(id).isPresent()) {
            throw new DataNotFoundException(String.format(ResponseMessage.DATA_NOT_FOUND,
                    Account.entityName, id));
        }
        return accountRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        getById(id);
        accountRepository.deleteById(id);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }
}
