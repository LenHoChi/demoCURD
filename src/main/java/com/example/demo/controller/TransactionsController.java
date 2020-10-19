package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.demo.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.repository.TransactionsRepository;

@RestController
@RequestMapping("/api/v1")
public class TransactionsController {
    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    private TransactionsService transactionsService;
    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions() {
//        return transactionsRepository.findAll();
        return transactionsService.getAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transactions> getTransactionsById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
//        Transactions transactions = transactionsRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id :: " + id));
//        return ResponseEntity.ok().body(transactions);
        return transactionsService.getTransactionById(id);
    }

    @PostMapping("/transactions")
    public Transactions createTransactions(@Valid @RequestBody Transactions transactions) {
//        return transactionsRepository.save(transactions);
        return transactionsService.saveTransactions(transactions);
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<Transactions> updateTransactions(@PathVariable(value = "id") Long id,
                                                       @Valid @RequestBody Transactions trans) throws ResourceNotFoundException {
//        Transactions transactions = transactionsRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id :: " + id));
//
//        transactions.setBank(trans.getBank());
//        final Transactions updatedTransaction = transactionsRepository.save(transactions);
//        return ResponseEntity.ok(updatedTransaction);
        return transactionsService.updateTransactions(id,trans);
    }

    @DeleteMapping("/transactions/{id}")
    public Map<String, Boolean> deleteTransactions(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
//        Transactions transactions = transactionsRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id :: " + id));
//
//        transactionsRepository.delete(transactions);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
        return transactionsService.deleteTransactions(id);
    }
}