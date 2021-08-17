package com.example.demo.repository;


import com.example.demo.model.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
