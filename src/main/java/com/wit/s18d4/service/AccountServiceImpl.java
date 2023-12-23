package com.wit.s18d4.service;

import com.wit.s18d4.entity.Account;
import com.wit.s18d4.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findById(long id) {
        Optional<Account> optionalAccount=accountRepository.findById(id);
        if(optionalAccount.isPresent()){
            return optionalAccount.get();
        }
        return null;
        //TODO THROW EXC.
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account remove(long id) {
        Account account=findById(id);
        if(account!=null){
            accountRepository.delete(account);
        }
        return null;
        //TODO THROW EXC.
    }


}
