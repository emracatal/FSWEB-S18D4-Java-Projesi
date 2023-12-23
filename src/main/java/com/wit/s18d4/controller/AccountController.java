package com.wit.s18d4.controller;

import com.wit.s18d4.dto.AccountResponse;
import com.wit.s18d4.entity.Account;
import com.wit.s18d4.entity.Customer;
import com.wit.s18d4.service.AccountService;
import com.wit.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    private CustomerService customerService;//POST customerId için

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }


    @GetMapping("/")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account find(@PathVariable Long id) {
        return accountService.findById(id);
    }

    //EN ZOR KISMI!!
    @PostMapping("/{customerId}")
    public AccountResponse save(@RequestBody Account account, @PathVariable long customerId) {
        Customer customer = customerService.findById(customerId);
        if (customer != null) {
            customer.getAccounts().add(account);
            account.setCustomer(customer);
            accountService.save(account);
        } else {
            throw new RuntimeException("No Customer Found");
        }
        return new AccountResponse(account.getId(), account.getAccountName());
    }

    @PutMapping("/{customerId}")//TODO customer al
    public AccountResponse update(@RequestBody Account account, @PathVariable Long customerId) {
        Customer customer = customerService.findById(customerId);
        Account found = null;
        for (Account account1 : customer.getAccounts()) {
            if (account.getId() == account1.getId()) {
                found = account1;
            }
        }
        if (found == null) {
            throw new RuntimeException("Account with given id is not exist" + account.getId());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public AccountResponse remove(@PathVariable Long id) {
        Account account=accountService.findById(id);
        if(account!=null){
            accountService.remove(id);
            return new AccountResponse(account.getId(), account.getAccountName());
        }else{
            throw new RuntimeException("No account found");
        }
    }
}
