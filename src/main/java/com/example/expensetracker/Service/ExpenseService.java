package com.example.expensetracker.Service;

import com.example.expensetracker.Models.Expense;
import com.example.expensetracker.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
    public List<Expense> getAll(){
        return expenseRepository.findAll();
    }

    public Optional<Expense> get(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense addExpense(Expense expense){
        return expenseRepository.save(expense);
    }
    public Optional<Expense> update(Expense expense) {
        if(expenseRepository.existsById(expense.getId())){
            expenseRepository.save(expense);
            return Optional.of(expense);
        }
        return Optional.empty();
    }
    public boolean delete(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}