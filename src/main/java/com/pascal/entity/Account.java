package com.pascal.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "mst_account")
public class Account {
    public static final String entityName = "ACCOUNT";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;
    @NotBlank
    private String biologicalMomName;
    @NotBlank
    private String accountNumber;
    @NotBlank
    private String password;
    @NotBlank
    private String userName;

    public Account() {
    }

    public Account(String name, String email, String phone, String address, String biologicalMomName, String accountNumber, String password, String userName) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.biologicalMomName = biologicalMomName;
        this.accountNumber = accountNumber;
        this.password = password;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getBiologicalMomName() {
        return biologicalMomName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(name, account.name) && Objects.equals(email, account.email) && Objects.equals(phone, account.phone) && Objects.equals(address, account.address) && Objects.equals(biologicalMomName, account.biologicalMomName) && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(password, account.password) && Objects.equals(userName, account.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, address, biologicalMomName, accountNumber, password, userName);
    }
}
