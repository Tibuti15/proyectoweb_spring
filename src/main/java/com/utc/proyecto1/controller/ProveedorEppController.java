package com.utc.proyecto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.utc.proyecto1.entity.ProveedorEpp;
import com.utc.proyecto1.service.ProveedorEppService;
import com.utc.proyecto1.service.ProductoEppService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorEppController {
    private final ProveedorEppService service;
    private final ProductoEppService productoServicio;
    
    public ProveedorEppController(ProveedorEppService service, ProductoEppService productoServicio) {
        this.service = service;
        this.productoServicio = productoServicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return "views/listarProveedor";
    }

    @PostMapping("/guardar")
    public String guardar(ProveedorEpp proveedor, RedirectAttributes redirectAttributes) {
        service.guardar(proveedor);
        redirectAttributes.addFlashAttribute("guardado", true);
        return "redirect:/proveedores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        service.eliminar(id);
        redirectAttributes.addFlashAttribute("eliminado", true);
        return "redirect:/proveedores";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("proveedor", new ProveedorEpp());
        model.addAttribute("productos", productoServicio.listar());
        return "views/formProveedor";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("proveedor", service.buscar(id));
        model.addAttribute("productos", productoServicio.listar());
        return "views/formProveedor";
    }
}