package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    private Integer contractId;
    private String contractStartDate;
    private String contractEndDate;
    private Double contractDeposit;
    private Double contractTotalMoney;
    private EmployeeDto employeeDto;

    private Customer customer;
    private EntityService services;
    private Set<ContractDetail> contractDetails;


}
