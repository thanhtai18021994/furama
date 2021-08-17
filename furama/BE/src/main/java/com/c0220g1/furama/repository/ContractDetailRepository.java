package com.c0220g1.furama.repository;

import com.c0220g1.furama.model.entity.Contract;
import com.c0220g1.furama.model.entity.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
