package com.example.demo.service;

import com.example.demo.model.Transactions;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface TransactionsService {
    Transactions saveTransactions(Transactions transactions);
    List<Transactions> getAllTransactions();
    ResponseEntity<Transactions> getTransactionById(long id);
    ResponseEntity<Transactions> updateTransactions(long id,Transactions trans);
    Map<String,Boolean> deleteTransactions(long id);
}
