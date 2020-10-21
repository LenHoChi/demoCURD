package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import com.example.demo.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Transactions;

@RestController
@RequestMapping("/api/v1")
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsService;
    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions() {
        return transactionsService.getAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transactions> getTransactionsById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return transactionsService.getTransactionById(id);
    }

    @PostMapping("/transactions")
    public Transactions createTransactions(@Valid @RequestBody Transactions transactions) {
        return transactionsService.saveTransactions(transactions);
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<Transactions> updateTransactions(@PathVariable(value = "id") Long id,
                                                       @Valid @RequestBody Transactions trans) throws ResourceNotFoundException {
        return transactionsService.updateTransactions(id,trans);
    }

    @DeleteMapping("/transactions/{id}")
    public Map<String, Boolean> deleteTransactions(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return transactionsService.deleteTransactions(id);
    }
}