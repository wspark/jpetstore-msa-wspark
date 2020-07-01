package com.rock.jpetstore.service;

import com.rock.jpetstore.domain.Account;
import com.rock.jpetstore.domain.Accounts;
import com.rock.jpetstore.repository.AccountRepository;
import com.rock.jpetstore.repository.AccountsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private AccountsRepository accountsRepository;

    // Account
    public List<Account> getAccountList(){
        return accountRepository.findAll();
    }
    public Account getAccountById(String userid){
        return accountRepository.findByUserid(userid);
    }
    public void updateAccount(Account account) {
    	accountRepository.save(account);
    }
    
    // Accounts
    public List<Accounts> getAll(){
        return accountsRepository.findAll();
    }
    public void insertAccount(Accounts accounts) {
    	accountsRepository.save(accounts);
    }
    public void deleteAccount(String userid){
        accountsRepository.deleteById(userid);
    }
}