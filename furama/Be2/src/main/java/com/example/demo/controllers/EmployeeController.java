package com.example.demo.controllers;


import com.example.demo.model.entity.Employee;
import com.example.demo.service.contract.IContractService;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.employee.IEmployeeService;
import com.example.demo.service.entityService.IEntityServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IContractService contractService;
    @Autowired
    IEntityServiceService entityServiceService;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok().body(employeeService.findAll());
    }
    
}
