package com.example.demo.service.customer;

import com.c0220g1.furama.model.entity.Customer;
import com.c0220g1.furama.repository.CustomerResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerResponsitory customerResponsitory;

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }
}
