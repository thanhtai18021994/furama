package com.c0220g1.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    T save(T t);
    void delete(T t);
    Optional<T> findById(Long id);
    List<T> searchName(String name);
}
