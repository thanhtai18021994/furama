package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;
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
    @ManyToOne()
    @JoinColumn(name = "service_type_id",nullable = false)
    private ServiceType serviceType;
    @OneToMany(mappedBy = "services")
    private Set<Contract> contracts;
    private Boolean status;
}

