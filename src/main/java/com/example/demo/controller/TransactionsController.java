package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.example.demo.model.transactions;
import com.example.demo.repository.TransactionsRepository;

@RestController
@RequestMapping("/api/v1")
public class TransactionsController {
    @Autowired
    private TransactionsRepository transactionsRepository;

    @GetMapping("/transactions")
    public List<transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<transactions> getTransactionsById(@PathVariable(value = "id") Long Id)
            throws ResourceNotFoundException {
        transactions ee = transactionsRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));
        return ResponseEntity.ok().body(ee);
    }

    @PostMapping("/transactions")
    public transactions createEmployee(@Valid @RequestBody transactions ee) {
        return transactionsRepository.save(ee);
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<transactions> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody transactions trans) throws ResourceNotFoundException {
        transactions tran = transactionsRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        tran.setBank(trans.getBank());
        final transactions updatedEmployee = transactionsRepository.save(tran);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/transactions/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long Id)
            throws ResourceNotFoundException {
        transactions tran = transactionsRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));

        transactionsRepository.delete(tran);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}