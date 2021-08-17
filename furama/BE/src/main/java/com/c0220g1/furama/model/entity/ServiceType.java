package com.c0220g1.furama.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;
    private String serviceTypeName;
    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.ALL)
    private List<EntityService> services;
}
