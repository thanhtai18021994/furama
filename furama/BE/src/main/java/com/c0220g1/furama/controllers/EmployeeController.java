package com.c0220g1.furama.controllers;

import com.c0220g1.furama.model.dto.EmployeeDto;
import com.c0220g1.furama.model.dto.UserDto;
import com.c0220g1.furama.model.entity.Employee;

import com.c0220g1.furama.model.entity.User;
import com.c0220g1.furama.service.contract.IContractService;
import com.c0220g1.furama.service.customer.ICustomerService;
import com.c0220g1.furama.service.employee.IEmployeeService;
import com.c0220g1.furama.service.entityService.IEntityServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/employee")
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

    @PostMapping("")
    public ResponseEntity<List<FieldError>> create(@Valid @RequestBody EmployeeDto employeeDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        Employee user=new Employee();
        BeanUtils.copyProperties(employeeDto,user);
        Employee employee=employeeService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<List<FieldError>> update(@PathVariable Long id,
                                                   @RequestBody EmployeeDto employeeDto,
                                                   BindingResult bindingResult){
        Optional<Employee> employee=employeeService.findById(id);
        if (!employee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Employee employee1=new Employee();
        BeanUtils.copyProperties(employee1,employeeDto);
        employee1.setEmployeeId(id);
        employeeService.save(employee1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity<Employee> delete(
            @PathVariable Long id
    ){
        Optional<Employee> employee=employeeService.findById(id);
        if (!employee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.delete(employee.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Employee>> searchName(@PathVariable String name){
        if (name.equals(null)){
            return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
        }
        return new ResponseEntity<>(employeeService.searchName(name),HttpStatus.OK);
    }
}
