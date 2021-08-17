package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractDetail {

    private Integer ContractDetailId;
    private Integer quality;

    private Contract contract;

    private AttachService attachService;
}
