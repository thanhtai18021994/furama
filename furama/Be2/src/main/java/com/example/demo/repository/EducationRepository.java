package com.example.demo.repository;


import com.example.demo.model.entity.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<EducationDegree,Integer> {
}
