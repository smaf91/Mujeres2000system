package com.mujeres2000.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "costo_general")
@Table(name = "costo_general")

public class Costo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costos_generales_ID;

    @Column (name = "categoria", length = 255 )
    private String categoria;

    @Column (name = "costo", length = 10 )
    private Double costo;

    @Column (name = "fecha", length = 10 )
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    //CONSTRUCTOR

    public Costo() {

    }

    public Costo(Integer costos_generales_ID, String categoria, Double costo) {
        this.costos_generales_ID = costos_generales_ID;
        this.categoria = categoria;
        this.costo = costo;
    }

    public Integer getCostos_generales_ID() {
        return costos_generales_ID;
    }

    public void setCostos_generales_ID(Integer costos_generales_ID) {
        this.costos_generales_ID = costos_generales_ID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}


