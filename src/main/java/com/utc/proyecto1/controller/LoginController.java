package com.utc.proyecto1.controller;

import com.utc.proyecto1.entity.Usuario;
import com.utc.proyecto1.service.UsuarioService;
import com.utc.proyecto1.service.EmailService; // Asegúrate de haber creado este servicio

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailService emailService; // Inyección del servicio de correo

    // =========================
    // LOGIN
    // =========================
    @GetMapping("login")
    public String mostrarLogin(Model model) {
        if (!model.containsAttribute("usuario")) {
            model.addAttribute("usuario", new Usuario());
        }
        return "views/login";
    }

    @PostMapping("procesar-login")
    public String procesarLogin(@RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Optional<Usuario> usuarioOpt = usuarioService.login(email, password);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            session.setAttribute("usuarioId", usuario.getId());
            session.setAttribute("usuarioNombre", usuario.getNombre());
            session.setAttribute("usuarioEmail", usuario.getEmail());

            // Redirige al listado principal tras éxito
            return "redirect:/productos"; // Ajusta esta ruta según tu controlador de productos
        }

        redirectAttributes.addFlashAttribute("error", "Email o contraseña incorrectos");
        return "redirect:/login";
    }

    // =========================
    // REGISTRO
    // =========================
    @GetMapping("registro")
    public String mostrarRegistro(Model model) {
        if (!model.containsAttribute("usuario")) {
            model.addAttribute("usuario", new Usuario());
        }
        return "views/registro";
    }

    @PostMapping("procesar-registro")
    public String procesarRegistro(@ModelAttribute Usuario usuario,
            RedirectAttributes redirectAttributes) {
        try {
            // 1. Guardar en la base de datos
            usuarioService.guardarUsuario(usuario);

            // 2. Intentar enviar correo de bienvenida
            try {
                emailService.enviarCorreoBienvenida(usuario.getEmail(), usuario.getNombre());
            } catch (Exception mailError) {
                // Si el correo falla, imprimimos el error pero no bloqueamos al usuario
                System.err.println("Error al enviar email: " + mailError.getMessage());
            }

            redirectAttributes.addFlashAttribute("success",
                    "¡Registro exitoso! Se ha enviado un correo de bienvenida.");
            return "redirect:/login";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar: " + e.getMessage());
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