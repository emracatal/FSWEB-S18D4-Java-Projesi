package com.wit.s18d4.util;

import com.wit.s18d4.controller.CustomerController;
import com.wit.s18d4.dto.CustomerResponse;
import com.wit.s18d4.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class EntityConverter {
    public static List<CustomerResponse> findResults(List<Customer> customers) {
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponses.add(new CustomerResponse(customer.getId(), customer.getEmail()));
        }
        return customerResponses;
    }

    public static CustomerResponse find(Customer customers) {
        return new CustomerResponse(customers.getId(), customers.getEmail());
    }
}
