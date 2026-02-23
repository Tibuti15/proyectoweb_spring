package com.utc.proyecto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.utc.proyecto1.entity.ProductoEpp;
import com.utc.proyecto1.service.ProductoEppService;

@Controller
@RequestMapping("/productos")
public class ProductoEppController {

    private final ProductoEppService service;

    public ProductoEppController(ProductoEppService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return "views/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new ProductoEpp());
        return "views/form";
    }

    @PostMapping("/guardar")
    public String guardar(ProductoEpp producto) {
        service.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", service.buscar(id));
        return "views/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/productos";
    }
}