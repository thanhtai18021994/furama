package com.c0220g1.furama.repository;

import com.c0220g1.furama.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Integer> {
}
