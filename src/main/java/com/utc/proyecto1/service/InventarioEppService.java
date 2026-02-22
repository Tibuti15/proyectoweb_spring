package com.utc.proyecto1.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.utc.proyecto1.entity.InventarioEpp;
import com.utc.proyecto1.repository.InventarioEppRepository;

@Service
public class InventarioEppService {

    private final InventarioEppRepository repo;

    public InventarioEppService(InventarioEppRepository repo) {
        this.repo = repo;
    }

    public List<InventarioEpp> listar() {
        return repo.findAll();
    }

    public InventarioEpp guardar(InventarioEpp i) {
        return repo.save(i);
    }

    public InventarioEpp buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}