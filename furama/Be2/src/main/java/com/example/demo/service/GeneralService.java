package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    T save(T t);
    void delete(Long id);
    Optional<T> findById(Long id);
}
