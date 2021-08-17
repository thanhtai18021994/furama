package com.c0220g1.furama.service.employee;

import com.c0220g1.furama.model.entity.Employee;
import com.c0220g1.furama.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public void delete(Employee id) {
        employeeRepository.delete(id);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> searchName(String name) {
        return employeeRepository.searchName(name);
    }
}
