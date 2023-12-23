package com.wit.s18d4.service;

import com.wit.s18d4.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    Customer findById(long id);
    List<Customer> findAll();
    Customer remove(long id);
}
