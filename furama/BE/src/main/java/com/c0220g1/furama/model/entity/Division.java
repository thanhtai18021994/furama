package com.c0220g1.furama.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Integer divisionId;
    private String divisionName;
    @OneToMany(mappedBy ="division",cascade = CascadeType.ALL)
    private List<Employee> employees;

}
