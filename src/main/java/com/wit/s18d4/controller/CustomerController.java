package com.wit.s18d4.controller;

import com.wit.s18d4.dto.CustomerResponse;
import com.wit.s18d4.entity.Customer;
import com.wit.s18d4.service.CustomerService;
import com.wit.s18d4.util.EntityConverter;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }
    @GetMapping("/") //EntityConverter.findResults
    public List<CustomerResponse> findAll(){
        return EntityConverter.findResults(customerService.findAll());
    }


    @GetMapping("/{id}") //EntityConverter.find
    public CustomerResponse find(@PathVariable Long id){
        return EntityConverter.find(customerService.findById(id));
    }

    @PostMapping("/") //EntityConverter.find
    public CustomerResponse save(@RequestBody Customer customer){
        return EntityConverter.find(customerService.save(customer));
    }

    @PutMapping("/{id}") //EntityConverter.find
    public CustomerResponse update(@RequestBody Customer customer,@PathVariable Long id){
        Customer found=customerService.findById(id);
        if(found!=null){
            customer.setId(id);
            return EntityConverter.find(customerService.save(customer));
        }
        return null;
        //TODO THROW EXC.
    }

    @DeleteMapping("/{id}") //EntityConverter.find
    public CustomerResponse remove(@PathVariable Long id){
        return EntityConverter.find(customerService.remove(id));
    }
}
