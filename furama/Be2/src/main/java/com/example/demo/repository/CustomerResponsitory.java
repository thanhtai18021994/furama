package com.example.demo.repository;


import com.example.demo.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerResponsitory extends JpaRepository<Customer,Long> {
}
