package com.utc.proyecto1.controller;

import com.utc.proyecto1.entity.Usuario;
import com.utc.proyecto1.service.UsuarioService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/")   // Centraliza las rutas
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    // =========================
    // LOGIN
    // =========================
    @GetMapping("login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "views/login";   // templates/views/login.html
    }

    @PostMapping("procesar-login")
    public String procesarLogin(@RequestParam String email,
                                @RequestParam String password,
                                HttpSession session,
                                RedirectAttributes redirectAttributes) {

        Optional<Usuario> usuarioOpt = usuarioService.login(email, password);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // Guardamos info del usuario en sesión
            session.setAttribute("usuarioId", usuario.getId());
            session.setAttribute("usuarioNombre", usuario.getNombre());
            session.setAttribute("usuarioEmail", usuario.getEmail());

            // Redirige directamente a listar.html
            return "views/listar";  // templates/views/listar.html
        }

        redirectAttributes.addFlashAttribute("error", "Email o contraseña incorrectos");
        return "redirect:/login";
    }

    // =========================
    // REGISTRO
    // =========================
    @GetMapping("registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "views/registro";   // templates/views/registro.html
    }

    @PostMapping("procesar-registro")
    public String procesarRegistro(@ModelAttribute Usuario usuario,
                                   RedirectAttributes redirectAttributes) {

        try {
        	usuarioService.guardarUsuario(usuario);
            redirectAttributes.addFlashAttribute("success", "Usuario registrado correctamente");
            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/registro";
        }
    }

    // =========================
    // LOGOUT
    // =========================
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}