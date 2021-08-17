package com.c0220g1.furama.repository;

import com.c0220g1.furama.model.entity.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<EducationDegree,Integer> {
}
