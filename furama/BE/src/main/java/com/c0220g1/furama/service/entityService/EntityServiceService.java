package com.c0220g1.furama.service.entityService;

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
        return serviceRepository.findAll();
    }

    @Override
    public Page<EntityService> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public EntityService save(EntityService entityService) {
        return serviceRepository.save(entityService);
    }

    @Override
    public void delete(EntityService entityService) {
        serviceRepository.delete(entityService);
    }

    @Override
    public Optional<EntityService> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<EntityService> searchName(String name) {
        return serviceRepository.findByServiceName(name);
    }
}
