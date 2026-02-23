package com.utc.proyecto1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto_epp")
public class ProductoEpp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_peep")
    private Long codigoPeep;

    @Column(name = "nombre_pepp")
    private String nombrePepp;

    @Column(name = "marca_pepp")
    private String marcaPepp;

    @Column(name = "unidad_pepp")
    private String unidadPepp;

    @Column(name = "tipo_proteccion_pepp")
    private String tipoProteccionPepp;

    public Long getCodigoPeep() { return codigoPeep; }
    public void setCodigoPeep(Long codigoPeep) { this.codigoPeep = codigoPeep; }

    public String getNombrePepp() { return nombrePepp; }
    public void setNombrePepp(String nombrePepp) { this.nombrePepp = nombrePepp; }

    public String getMarcaPepp() { return marcaPepp; }
    public void setMarcaPepp(String marcaPepp) { this.marcaPepp = marcaPepp; }

    public String getUnidadPepp() { return unidadPepp; }
    public void setUnidadPepp(String unidadPepp) { this.unidadPepp = unidadPepp; }

    public String getTipoProteccionPepp() { return tipoProteccionPepp; }
    public void setTipoProteccionPepp(String tipoProteccionPepp) { this.tipoProteccionPepp = tipoProteccionPepp; }
}