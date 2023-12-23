package com.wit.s18d4.controller;

import com.wit.s18d4.entity.Address;
import com.wit.s18d4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address find(@PathVariable Long id){
        return addressService.findById(id);
    }

    @PostMapping("/")
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address update(@RequestBody Address address,@PathVariable Long id){
        Address found=addressService.findById(id);
        if(found!=null){
            address.setId(id);
            return addressService.save(address);
        }
        return null;
        //TODO THROW EXC.
    }

    @DeleteMapping("/{id}")
    public Address remove(@PathVariable Long id){
        return addressService.remove(id);
    }

}
