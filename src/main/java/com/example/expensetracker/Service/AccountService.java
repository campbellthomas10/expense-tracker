package com.example.expensetracker.Service;

import com.example.expensetracker.Models.Account;
import com.example.expensetracker.Repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public Optional<Account> get(Long id) {
        return accountRepository.findById(id);
    }

    public Account addAccount(Account account){
        return accountRepository.save(account);
    }
    public Optional<Account> update(Account account) {
        if(accountRepository.existsById(account.getId())){
            accountRepository.save(account);
            return Optional.of(account);
        }
        return Optional.empty();
    }
    public boolean delete(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}