package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ContractDetailId;
    private Integer quality;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;
}
