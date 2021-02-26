package com.example.examplemodule4.service.itf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface serviceInterface<T> {
    Page<T> findAll(Pageable pageable);

    Page<T> findAllByName(Pageable pageable, String name);

    Optional<T> findById(Long id);

    void save(T t);

    void delete(T t);

    void deleteById(Long id);

}
