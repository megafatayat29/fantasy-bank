package com.pascal.service;

import com.pascal.dto.UserCredentials;
import com.pascal.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationTokenService {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailServiceDbImpl userDetailServiceDb;

    public Map<String, Object> signIn(UserCredentials userCredentials) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword());

        //validate username and password
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //ambil UserDetails
        UserDetails userDetails = userDetailServiceDb.loadUserByUsername(userCredentials.getUsername());

        //Bikin Token
        String token = jwtTokenUtil.generateToken(userDetails);

        //Bikin Wrapper, agar bisa diconvert ke JSON
        Map<String, Object> tokenWrapper = new HashMap<>();
        tokenWrapper.put("token", token);

        return tokenWrapper;
    }
}
