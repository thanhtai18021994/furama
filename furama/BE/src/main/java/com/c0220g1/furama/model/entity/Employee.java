package com.c0220g1.furama.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
    private String codeEmployee;

    private String employeeName;
    private String employeeGender;
    private String employeeBirthday;

    private String employeeIdCard;
    private String employeeSalary;
    private String employeePhone;
    @Email(message = "email không đúng định dạng")
    private String employeeEmail;
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_id")
    private EducationDegree educationDegree;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<Contract> contracts;
    private Boolean status;

}
