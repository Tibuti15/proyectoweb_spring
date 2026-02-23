package com.utc.proyecto1.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.utc.proyecto1.entity.ProveedorEpp;
import com.utc.proyecto1.repository.ProveedorEppRepository;

@Service
public class ProveedorEppService {
    private final ProveedorEppRepository repo;
    
    public ProveedorEppService(ProveedorEppRepository repo) {
        this.repo = repo;
    }
    
    public List<ProveedorEpp> listar() {
        return repo.findAll();
    }
    
    public ProveedorEpp guardar(ProveedorEpp p) {
        return repo.save(p);
    }
    
    public ProveedorEpp buscar(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}