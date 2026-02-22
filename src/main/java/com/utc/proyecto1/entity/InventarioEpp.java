package com.utc.proyecto1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario_epp")
public class InventarioEpp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_invepp")
    private Long id;

    @Column(name = "stock_invepp")
    private Integer stock;

    @Column(name = "ubicacion_invepp")
    private String ubicacion;

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}