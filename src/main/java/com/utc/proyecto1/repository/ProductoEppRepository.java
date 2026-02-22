package com.utc.proyecto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utc.proyecto1.entity.ProductoEpp;

public interface ProductoEppRepository extends JpaRepository<ProductoEpp, Long> {
}