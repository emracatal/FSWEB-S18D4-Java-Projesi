package com.wit.s18d4.service;

import com.wit.s18d4.entity.Account;
import com.wit.s18d4.entity.Customer;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    Account findById(long id);
    List<Account> findAll();
    Account remove(long id);
}
