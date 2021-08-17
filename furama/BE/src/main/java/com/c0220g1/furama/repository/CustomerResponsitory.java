package com.c0220g1.furama.repository;

import com.c0220g1.furama.model.entity.Customer;
import com.c0220g1.furama.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerResponsitory extends JpaRepository<Customer,Long> {
    @Query("select u from Customer u where u.customerName like ?1")
    List<Employee> searchName(String name);
    @Query("select u from Customer u where u.customerPhone like ?1")
    List<Employee> searchPhone(String phone);
    @Query("select u from Customer u where u.customerEmail like  ?1")
    List<Employee> searchEmail(String name);
    @Query("select u from Customer u where u.customerGender =?1")
    List<Employee> searchGender(String name);
}
