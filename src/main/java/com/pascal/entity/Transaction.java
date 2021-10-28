package com.pascal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tx_account_wallet")
public class Transaction {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Transient
    private String walletId;
    @Transient
    private String merchantId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    private String type;
    private Integer nominal;
    private Date txDate;

    public Transaction() {
    }

    public Transaction(String walletId, String merchantId) {
        this.walletId = walletId;
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public String getId() {
        return id;
    }

    public String getWalletId() {
        return walletId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getType() {
        return type;
    }

    public Integer getNominal() {
        return nominal;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(walletId, that.walletId) && Objects.equals(merchantId, that.merchantId) && Objects.equals(wallet, that.wallet) && Objects.equals(merchant, that.merchant) && Objects.equals(type, that.type) && Objects.equals(nominal, that.nominal) && Objects.equals(txDate, that.txDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, walletId, merchantId, wallet, merchant, type, nominal, txDate);
    }
}
