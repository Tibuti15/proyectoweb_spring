package com.utc.proyecto1.entity;

import javax.persistence.*;

@Entity
@Table(name = "proveedor_xp")
public class ProveedorEpp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_prov_epp")
    private Long codigoProvEpp;

    @Column(name = "nombre_prov_epp")
    private String nombreProvEpp;

    @Column(name = "contacto_prov_epp")
    private String contactoProvEpp;

    @Column(name = "telefono_prov_epp")
    private String telefonoProvEpp;

    @Column(name = "email_prov_epp")
    private String emailProvEpp;

    @ManyToOne
    @JoinColumn(name = "producto_codigo", referencedColumnName = "codigo_peep")
    private ProductoEpp producto;

    // Getters y Setters
    public Long getCodigoProvEpp() { return codigoProvEpp; }
    public void setCodigoProvEpp(Long codigoProvEpp) { this.codigoProvEpp = codigoProvEpp; }

    public String getNombreProvEpp() { return nombreProvEpp; }
    public void setNombreProvEpp(String nombreProvEpp) { this.nombreProvEpp = nombreProvEpp; }

    public String getContactoProvEpp() { return contactoProvEpp; }
    public void setContactoProvEpp(String contactoProvEpp) { this.contactoProvEpp = contactoProvEpp; }

    public String getTelefonoProvEpp() { return telefonoProvEpp; }
    public void setTelefonoProvEpp(String telefonoProvEpp) { this.telefonoProvEpp = telefonoProvEpp; }

    public String getEmailProvEpp() { return emailProvEpp; }
    public void setEmailProvEpp(String emailProvEpp) { this.emailProvEpp = emailProvEpp; }

    public ProductoEpp getProducto() { return producto; }
    public void setProducto(ProductoEpp producto) { this.producto = producto; }
}