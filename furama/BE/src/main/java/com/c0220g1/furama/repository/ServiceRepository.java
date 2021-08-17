package com.c0220g1.furama.repository;

import com.c0220g1.furama.model.entity.EntityService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<EntityService,Long> {
    List<EntityService> findByServiceName(String name);
}
