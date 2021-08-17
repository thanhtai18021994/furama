package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer customerId;
    @Pattern(regexp = "^KH-\\d{4}$",message = "KH-xxxx x là số 0-9")
    private String codeCustomer;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Viet hoa chu cai dau tien !!!")
    private String customerName;
    @Column(columnDefinition = "date")
    private String customerBirthday;
    private String customerGender;
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$",message = "(xxxxxxxxx)|(xxxxxxxxxxxx) x là số 0-9")
    private String customerIdCard;


    private String customerPhone;
    @Email(message = "email không đúng định dạng !!")
    private String customerEmail;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Viet hoa chu cai dau tien !!!")
    private String customerAddress;

    CustomerType customerType;

    private Set<Contract> contract;
}
