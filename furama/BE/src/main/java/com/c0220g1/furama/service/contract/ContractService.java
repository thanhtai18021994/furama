package com.c0220g1.furama.service.contract;

import com.c0220g1.furama.model.entity.Contract;
import com.c0220g1.furama.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return null;
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Contract save(Contract contract) {
        return null;
    }

    @Override
    public void delete(Contract id) {
        contractRepository.delete(id);
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Contract> searchName(String name) {
        return null;
    }
}
