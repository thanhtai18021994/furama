package com.c0220g1.furama.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityService {

    private Integer serviceId;
    @Pattern(regexp = "^DV-\\d{4}$",message = "DV-xxxx x là số 0-9")
    private String codeService;
    @NotBlank
    private String serviceName;
    @Min(1)
    private Double serviceArea;
    @Min(1)
    private Double serviceCost;
    @Min(1)
    private Integer serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(1)
    private Double poolArea;
    @Min(1)
    private Integer numberOfFloor;
    private ServiceType serviceType;
    private Set<ContractDto> contractDtos;
}

