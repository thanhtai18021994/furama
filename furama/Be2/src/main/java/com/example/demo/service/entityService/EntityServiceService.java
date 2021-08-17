package com.example.demo.service.entityService;

import com.c0220g1.furama.model.entity.EntityService;
import com.c0220g1.furama.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityServiceService implements IEntityServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<EntityService> findAll() {
        return null;
    }

    @Override
    public Page<EntityService> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public EntityService save(EntityService entityService) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<EntityService> findById(Long id) {
        return Optional.empty();
    }
}
