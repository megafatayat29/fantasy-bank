package com.pascal.controller;

import com.pascal.dto.UserCredentials;
import com.pascal.entity.Account;
import com.pascal.service.AccountService;
import com.pascal.service.AuthenticationTokenService;
import com.pascal.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    @Autowired
    StorageService storageService;

    //API Generate Token
    @PostMapping("/signIn")
    public Map<String, Object> signIn(@Valid @RequestBody UserCredentials userCredentials) {
        return authenticationTokenService.signIn(userCredentials);
    }

    //Boleh Siapa Aja
    @PostMapping("/register")
    public Account register(@Valid @RequestBody Account account) {
        return accountService.register(account);
    }

    //Harus LOGIN & Hanya boleh role ADMIN
//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/accounts")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestPart(name = "profilePicture") MultipartFile file,
                           @RequestPart(name = "id") String id) throws IOException {
        storageService.saveFileTo(file, id);
        return "Success to upload picture!";
    }
}
