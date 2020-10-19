package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "transactions")
public class Transactions {

    private long id;
    private long userId;
    private long accountId;
    private long amount;
    private String transactionType;
    private Date createdAt;
    private String bank;

    public Transactions() {

    }

    public Transactions(long userId, long accountId, long amount, String transactionType, Date createdAt, String bank) {
        this.bank=bank;
        this.userId=userId;
        this.accountId=accountId;
        this.amount=amount;
        this.transactionType=transactionType;
        this.createdAt=createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "account_id", nullable = false)
    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    @Column(name = "amount", nullable = false)
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    @Column(name = "transaction_type", nullable = false)
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    @Column(name = "created_at", nullable = false)
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    @Column(name = "bank", nullable = false)
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", createdAt=" + createdAt +
                ", bank='" + bank + '\'' +
                '}';
    }
}