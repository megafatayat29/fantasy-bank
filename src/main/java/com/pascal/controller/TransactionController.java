package com.pascal.controller;

import com.pascal.entity.Transaction;
import com.pascal.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public Transaction create(@Valid @RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }
}
