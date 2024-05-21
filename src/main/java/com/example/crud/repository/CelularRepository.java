package com.example.crud.repository;

import com.example.crud.entity.Celular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CelularRepository extends JpaRepository<Celular,Integer> {
    Celular findByMarca(String marca);
}
