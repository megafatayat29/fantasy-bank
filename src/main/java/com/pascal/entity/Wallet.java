package com.pascal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "mst_wallet")
public class Wallet {
    public static final String entityName = "WALLET";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @NotBlank
    private String name;
    private Integer balance;

    @Transient
    private String accountId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Wallet() {
    }

    public Wallet(String name, Integer balance, String accountId) {
        this.name = name;
        this.balance = balance;
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String save(Integer nominal) {
        setBalance(getBalance()+nominal);
        return "Success to saving with nominal: "+nominal;
    }

    public String withdraw(Integer nominal) {
        setBalance(getBalance()-nominal);
        return "Success to withdraw with nominal: "+nominal;
    }

    public String payBill(Integer bill) {
        setBalance(getBalance()-bill);
        return "Success to pay bill with nominal: "+bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(name, wallet.name) && Objects.equals(balance, wallet.balance) && Objects.equals(accountId, wallet.accountId) && Objects.equals(account, wallet.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance, accountId, account);
    }
}
