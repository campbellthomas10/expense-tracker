package com.example.expensetracker.Controllers;


import com.example.expensetracker.Models.Expense;
import com.example.expensetracker.Service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/expenses")
public class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Expense> getAll() {
        return expenseService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public Expense addNew(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/{id}")
    ResponseEntity<Expense> get(@PathVariable Long id) {
        Optional<Expense> expense = expenseService.get(id);

        if (expense.isPresent()) {
            return ResponseEntity.ok().body(expense.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    ResponseEntity<Expense> update(@RequestBody Expense newExpense) {
        Optional<Expense> expense = expenseService.update(newExpense);
        if (expense.isPresent()) {
            return ResponseEntity.ok().body(expense.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        if (expenseService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}