package com.utc.proyecto1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario_epp")
public class InventarioEpp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_invepp")  // nombre correcto en la tabla
    private Long id;

    @Column(name = "codigo_peep")
    private String codigoPeep;

    @Column(name = "talla_invepp")
    private String talla;

    @Column(name = "stock_invepp")
    private Integer stock;

    @Column(name = "valor_unitario_invepp")
    private Double valorUnitario;

    @Column(name = "iva_invepp")
    private Double iva;

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigoPeep() { return codigoPeep; }
    public void setCodigoPeep(String codigoPeep) { this.codigoPeep = codigoPeep; }

    public String getTalla() { return talla; }
    public void setTalla(String talla) { this.talla = talla; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Double getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(Double valorUnitario) { this.valorUnitario = valorUnitario; }

    public Double getIva() { return iva; }
    public void setIva(Double iva) { this.iva = iva; }
}
