package com.example.demo.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    private String codeCustomer;
    private String customerName;
    @Column(columnDefinition = "date")
    private String customerBirthday;
    private String customerGender;
    private String customerIdCard;
    @NotNull
    private String customerPhone;
    @Email(message = "email không đúng định dạng !!")
    private String customerEmail;
    private String customerAddress;
    @ManyToOne()
    @JoinColumn(name = "customer_type_id")
    CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contract;
    private Boolean status;
}
