package com.pascal.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "mst_merchant")
public class Merchant {
    public static final String entityName = "MERCHANT";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @NotBlank
    private String name;
    private Integer bill;

    @Transient
    private String walletId;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    private String status;

    public Merchant() {
    }

    public Merchant(String name, Integer bill, String walletId) {
        this.name = name;
        this.bill = bill;
        this.walletId = walletId;
        this.status = "UNPAID";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBill() {
        return bill;
    }

    public String getWalletId() {
        return walletId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merchant merchant = (Merchant) o;
        return Objects.equals(id, merchant.id) && Objects.equals(name, merchant.name) && Objects.equals(bill, merchant.bill) && Objects.equals(walletId, merchant.walletId) && Objects.equals(wallet, merchant.wallet) && Objects.equals(status, merchant.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bill, walletId, wallet, status);
    }
}
