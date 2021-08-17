package com.c0220g1.furama.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerType {

    private Integer customerTypeId;
    private String customerTypeName;

    Set<CustomerDto> customerDtos;
}
