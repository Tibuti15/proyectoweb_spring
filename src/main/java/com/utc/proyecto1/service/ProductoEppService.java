package com.utc.proyecto1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utc.proyecto1.entity.ProductoEpp;
import com.utc.proyecto1.repository.ProductoEppRepository;

@Service
public class ProductoEppService {

    private final ProductoEppRepository repo;

    public ProductoEppService(ProductoEppRepository repo) {
        this.repo = repo;
    }

    public List<ProductoEpp> listar() {
        return repo.findAll();
    }

    public ProductoEpp guardar(ProductoEpp p) {
        return repo.save(p);
    }

    public ProductoEpp buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}