package com.wit.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer",schema="s18d4")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="salary")
    private double salary;
    //bir customerin bir adresi olabilir
    //customer silinirse address de silinsin
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
    //bir customerin birçok accountu olabilir
    //customer silinirse account da silinsin
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Account> accounts;
    public void addAccount(Account account){
        if(accounts == null){
            accounts=new ArrayList<>();
        }
        accounts.add(account);
    }
}
