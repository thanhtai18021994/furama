package com.example.demo.repository;

import com.example.demo.model.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByName(String name);
}
