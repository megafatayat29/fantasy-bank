package com.pascal.controller;

import com.pascal.entity.Merchant;
import com.pascal.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping("/merchant")
    public Merchant create(@Valid @RequestBody Merchant merchant) {
        return merchantService.create(merchant);
    }

    @GetMapping("/merchant/{id}")
    public Merchant getById(@PathVariable(name = "id") String id) {
        return merchantService.getById(id);
    }
}
