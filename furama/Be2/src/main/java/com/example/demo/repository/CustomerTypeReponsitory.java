package com.example.demo.repository;


import com.example.demo.model.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeReponsitory extends JpaRepository<CustomerType,Integer> {
}
