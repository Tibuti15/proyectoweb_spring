package com.utc.proyecto1.service;

import com.utc.proyecto1.entity.Usuario;
import com.utc.proyecto1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // =========================
    // REGISTRO
    // =========================
    public Usuario guardarUsuario(Usuario usuario) {

        // Verificar si el email ya existe
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            throw new RuntimeException("El email ya está registrado");
        }

        // ⚠️ SIN encriptación (modo presentación)
        return usuarioRepository.save(usuario);
    }

    // =========================
    // LOGIN
    // =========================
    public Optional<Usuario> login(String email, String password) {

        Usuario usuario = usuarioRepository.findByEmail(email);

        // Comparación directa (SIN encriptación)
        if (usuario != null && usuario.getPassword().equals(password)) {
            return Optional.of(usuario);
        }

        return Optional.empty();
    }

    // =========================
    // BUSCAR POR EMAIL
    // =========================
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}