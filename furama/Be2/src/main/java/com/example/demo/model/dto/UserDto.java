package com.example.demo.model.dto;


import com.example.demo.model.entity.Employee;
import com.example.demo.model.entity.Role;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;


public class UserDto implements Serializable {

    private Integer id;


    private String fullName;

    private String email;

    private String address;

    private String numberPhone;

    private String imageAvatarOfUser = "avatar-default.png";

    private String password;

    private String rememberToken;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Employee employee;

    private Set<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getImageAvatarOfUser() {
        return imageAvatarOfUser;
    }

    public void setImageAvatarOfUser(String imageAvatarOfUser) {
        this.imageAvatarOfUser = imageAvatarOfUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}