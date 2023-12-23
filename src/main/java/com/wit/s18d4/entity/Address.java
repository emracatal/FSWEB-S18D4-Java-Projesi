package com.wit.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="address",schema="s18d4")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="street")
    private String street;
    @Column(name="no")
    private int no;
    @Column(name="city")
    private String city;
    @Column(name="country")
    private String country;
    @Column(name="description")
    private String description;
    //bir customer bir adrese sahip olabilir
    //address silinince customer silinMEsin
    @OneToOne(mappedBy = "address",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="address_id")//foreign key
    private Customer customer;

/*    {
        "street":"apple street",
            "no":3,
            "city":"apple",
            "country":"USA",
            "description":"near by mosque"
    }*/
}
