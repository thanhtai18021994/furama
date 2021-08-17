package com.c0220g1.furama.repository;



import com.c0220g1.furama.model.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByName(String name);
}
