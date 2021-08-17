package com.c0220g1.furama.repository;

import com.c0220g1.furama.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Long> {
}
