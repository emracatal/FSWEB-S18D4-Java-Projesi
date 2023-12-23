package com.wit.s18d4.service;

import com.wit.s18d4.entity.Account;
import com.wit.s18d4.entity.Address;

import java.util.List;

public interface AddressService {
    Address save(Address address);
    Address findById(long id);
    List<Address> findAll();
    Address remove(long id);

}
