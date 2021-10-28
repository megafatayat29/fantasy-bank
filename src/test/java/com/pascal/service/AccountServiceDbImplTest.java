package com.pascal.service;

import com.pascal.entity.Account;
import com.pascal.exception.DataNotFoundException;
import com.pascal.repo.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AccountServiceDbImplTest {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    public void reset() {
        accountRepository.deleteAll();
    }

    @Test
    public void able_to_registerOneAccount() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        accountService.register(account);
        Long count = accountRepository.count();
        assertEquals(1, count);
    }

    @Test
    public void able_to_registerTwoAccount() {
        Account account1 = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        Account account2 = new Account("Vincent", "vincent@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "vincentganteng");
        accountService.register(account1);
        accountService.register(account2);
        Long count = accountRepository.count();
        assertEquals(2, count);
    }

    @Test
    public void create_shouldCreateCorrectAccount_when_accountWithGivenInformationCreated() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        Account expectedAccount = accountService.register(account);
        Account actualAccount = accountRepository.findById(expectedAccount.getId()).get();
        assertEquals(expectedAccount, actualAccount);
    }

    @Test
    public void getAll_shouldBeNotNull_when_thereIsAnyAccount() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        accountRepository.save(account);
        List<Account> accounts = accountService.getAll();
        assertNotNull(accounts);
    }

    @Test
    public void getAll_shouldBeOne_when_oneAccountSaved() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        accountRepository.save(account);
        List<Account> accounts = accountService.getAll();
        assertEquals(1, accounts.size());
    }

    @Test
    public void getAll_shouldReturnCorrectList_when_twoAccountsSaved() {
        //prepare
        Account account1 = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        Account account2 = new Account("Vincent", "vincent@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "vincentganteng");
        accountService.register(account1);
        accountService.register(account2);

        List<Account> expectedList = new ArrayList<>();
        expectedList.add(account1);
        expectedList.add(account2);

        //test
        assertEquals(expectedList, accountService.getAll());
    }

    @Test
    public void getById_shouldBeNotNull_when_thereIsAccountFind() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        accountRepository.save(account);
        assertNotNull(accountService.getById(account.getId()));
    }

    @Test
    public void getById_shouldReturnCorrectAccount_whenCorrectIdGiven() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        accountRepository.save(account);
        assertEquals(account, accountService.getById(account.getId()));
    }

    @Test
    public void getById_shouldThrowDataNotFoundException_when_idNotFound() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        accountRepository.save(account);
        assertThrows(DataNotFoundException.class, ()->{accountService.getById("idDummy78123521");});
    }

    @Test
    public void deleteById_shouldDeleteAccount_when_idAccountWasFound() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        accountRepository.save(account);
        accountService.deleteById(account.getId());
        assertEquals(false, accountRepository.existsById(account.getId()));
    }

    @Test
    public void deleteById_shouldThrowDataNotFoundException_when_idAccountWasNotFound() {
        Account account = new Account("Joseph", "joseph@gmail.com", "085677897821", "Jl. Aja Dulu", "Suzana", "14068778921", "12345678", "josephganteng");
        accountRepository.save(account);
        assertThrows(DataNotFoundException.class, ()->{accountService.deleteById("idDummy863241547732");});
    }
}