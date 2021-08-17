package com.example.demo.repository;


import com.example.demo.model.entity.EntityService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<EntityService,Long> {
}
