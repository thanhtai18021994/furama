package com.c0220g1.furama.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {

    private Integer employeeId;
    @Pattern(regexp = "^NV-\\d{4}$",message = "NV-xxxx x là số 0-9")
    private String codeEmployee;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Viet hoa chu cai dau tien !!!")
    private String employeeName;
    private String employeeGender;
    private String employeeBirthday;
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$",message = "(xxxxxxxxx)|(xxxxxxxxxxxx) x là số 0-9")
    private String employeeIdCard;
    private String employeeSalary;
    private String employeePhone;
    @Email(message = "email không đúng định dạng")
    private String employeeEmail;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Viet hoa chu cai dau tien !!!")
    private String employeeAddress;
    private Position position;
    private EducationDegree educationDegree;
    private Set<ContractDto> contractDtos;

}
