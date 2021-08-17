package com.c0220g1.furama.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttachService {

    private Integer attachServiceId;
    private String attachServiceName;
    private String attachServiceCost;
    private Integer attachServiceUnit;
    private String attachServiceStatus;
    private Set<ContractDetail> contractDetailSet;
}
