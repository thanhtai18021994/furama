package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer attachServiceId;
    private String attachServiceName;
    private String attachServiceCost;
    private Integer attachServiceUnit;
    private String attachServiceStatus;
    @OneToMany
    private Set<ContractDetail> contractDetailSet;
}
