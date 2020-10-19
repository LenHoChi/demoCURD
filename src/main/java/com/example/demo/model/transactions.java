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
public class transactions {

    private long id;
    private long user_id;
    private long account_id;
    private long amount;
    private String transaction_type;
    private Date created_at;
      private String bank;

    public transactions() {

    }

    public transactions(long user_id,long account_id,long amount,String transaction_type,Date created_at,String bank) {
        this.bank=bank;
        this.user_id=user_id;
        this.account_id=account_id;
        this.amount=amount;
        this.transaction_type=transaction_type;
        this.created_at=created_at;
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
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    @Column(name = "account_id", nullable = false)
    public long getAccount_id() {
        return account_id;
    }
    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }
    @Column(name = "amount", nullable = false)
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    @Column(name = "transaction_type", nullable = false)
    public String getTransaction_type() {
        return transaction_type;
    }
    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }
    @Column(name = "created_at", nullable = false)
    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
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
//        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
//                + "]";
        return "Employee: "+bank;
    }

}