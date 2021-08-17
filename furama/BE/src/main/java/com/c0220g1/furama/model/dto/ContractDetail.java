package com.c0220g1.furama.model.dto;

import com.c0220g1.furama.model.entity.AttachService;
import com.c0220g1.furama.model.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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
