package com.wit.s18d4.service;

import com.wit.s18d4.entity.Customer;
import com.wit.s18d4.repository.AddressRepository;
import com.wit.s18d4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            new RuntimeException("CUSTOMER COULD NOT FOUND");
        }
        return null;
//TODO CHECK??
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer remove(long id) {
        Customer customer = findById(id);
        if (customer != null) {
            customerRepository.delete(customer);
        }
        return null;
        //TODO THROW EXC.
    }


}
