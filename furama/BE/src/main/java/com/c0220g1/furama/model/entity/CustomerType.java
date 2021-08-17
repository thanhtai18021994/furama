package com.c0220g1.furama.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Integer customerTypeId;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
            @JsonBackReference
    List<Customer> customers;
    
}
