package com.mujeres2000.system.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "costo_general")

public class CostoGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int costos_generales_ID;
    @Column (name = "categoria", length = 100 )
    private String categoria;
    @Column (name = "costo_general_total", length = 10 )
    private int costo_general_total;
    @Column (name = "fecha_costo_general" )
    private Date fecha_costo_general;

    @ManyToOne
    @JoinColumn(name = "usuario_ID", referencedColumnName = "usuario_ID")
    private Usuario usuario;

    //CONSTRUCTOR

    public CostoGeneral(int costos_generales_ID, String categoria, int costo_general_total, Date fecha_costo_general, Usuario usuario) {
        this.costos_generales_ID = costos_generales_ID;
        this.categoria = categoria;
        this.costo_general_total = costo_general_total;
        this.fecha_costo_general = fecha_costo_general;
        this.usuario = usuario;
    }

    public CostoGeneral() {
    }
// GETTERS Y SETTERS

    public int getCostos_generales_ID() {
        return costos_generales_ID;
    }

    public void setCostos_generales_ID(int costos_generales_ID) {
        this.costos_generales_ID = costos_generales_ID;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCosto_general_total() {
        return costo_general_total;
    }

    public void setCosto_general_total(int costo_general_total) {
        this.costo_general_total = costo_general_total;
    }

    public Date getFecha_costo_general() {
        return fecha_costo_general;
    }

    public void setFecha_costo_general(Date fecha_costo_general) {
        this.fecha_costo_general = fecha_costo_general;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}


