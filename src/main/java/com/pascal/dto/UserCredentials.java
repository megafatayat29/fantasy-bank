package com.pascal.dto;

import javax.validation.constraints.NotBlank;

public class UserCredentials {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserCredentials() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
