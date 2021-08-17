package com.example.demo.service.security;



import com.example.demo.model.entity.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(long id);
}
