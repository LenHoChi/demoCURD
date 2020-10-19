package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Transactions;
import com.example.demo.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TransactionsService {
    @Autowired
    private TransactionsRepository transactionsRepository;
    public Transactions saveTransactions(Transactions transactions){
        return transactionsRepository.save(transactions);
    }
    public List<Transactions> getAllTransactions(){
        return (List<Transactions>)transactionsRepository.findAll();
    }
    public ResponseEntity<Transactions> getTransactionById(long id){
        Transactions transactions = transactionsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Transaction not found for this id :: " + id));
        return ResponseEntity.ok().body(transactions);
    }
    public ResponseEntity<Transactions> updateTransactions(long id, Transactions trans){
        Transactions transactions = transactionsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Transaction not found for this id :: " + id));
        transactions.setBank(trans.getBank());
        final Transactions updateTransaction=transactionsRepository.save(transactions);
        return ResponseEntity.ok().body(updateTransaction);
    }
    public Map<String, Boolean> deleteTransactions(long id){
        Transactions transactions = transactionsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Transaction not found for this id :: " + id));
        transactionsRepository.delete(transactions);
        Map<String, Boolean> response=new HashMap<>();
        response.put("delete ok",Boolean.TRUE);
        return response;
    }
}
