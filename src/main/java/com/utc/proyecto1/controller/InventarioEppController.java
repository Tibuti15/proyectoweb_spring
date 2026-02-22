package com.utc.proyecto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.utc.proyecto1.entity.InventarioEpp;
import com.utc.proyecto1.service.InventarioEppService;

@Controller
@RequestMapping("/inventario")
public class InventarioEppController {

    private final InventarioEppService service;

    public InventarioEppController(InventarioEppService service) {
        this.service = service;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return "views/listarInventario";  // ✅ templates/views/listarInventario.html
    }

    // NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("inventario", new InventarioEpp());
        return "views/formInventario";  // ✅ templates/views/formInventario.html
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(InventarioEpp inventario) {
        service.guardar(inventario);
        return "redirect:/inventario";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("inventario", service.buscar(id));
        return "views/formInventario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/inventario";
    }
}