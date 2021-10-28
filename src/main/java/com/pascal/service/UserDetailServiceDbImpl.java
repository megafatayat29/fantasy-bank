package com.pascal.service;

import com.pascal.entity.Account;
import com.pascal.repo.AccountRepository;
import com.pascal.security.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceDbImpl implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (!accountRepository.findAccountByUserName(userName).isPresent()) {
            throw new UsernameNotFoundException("UserName Tidak Ditemukan!");
        }
        //Dari Database
        Account account = accountRepository.findAccountByUserName(userName).get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        UserDetails userDetails = new UserDetailImpl(account.getUserName(), account.getPassword(), authorities);
        return userDetails;
    }
}
