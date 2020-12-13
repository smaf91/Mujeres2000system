package com.mujeres2000.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "producto")
@Table(name = "producto")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Integer producto_id;
    @NotBlank(message = "Ingrese nombre de producto")
    @Column(name = "producto_nombre", length = 255)
    private String producto_nombre;
    @Column(name = "producto_descripcion", length = 255)
    private String producto_descripcion;
    @Column(name = "costo_materia_prima", length = 10)
    private float costo_materia_prima;
    @Column(name = "envio", length = 10)
    private float envio;
    @Column(name = "rentabilidad", length = 10)
    private float rentabilidad;
    @Column(name = "pdvs", length = 10)
    private float pdvs;
    // cg se refiere a la variable costo_generales
    // como idea podria definirse un porcentaje sobre esa incidencia en los productos
    // ya que por lo general se define como costos / cantidad de productos a producir
    // en este caso lo desconocemos.
    private float costo_general_total;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    //CONSTRUCTOR


    public Producto(Integer producto_id, @NotBlank(message = "Ingrese nombre de producto") String producto_nombre, String producto_descripcion, float costo_materia_prima, float envio, float rentabilidad, float pdvs, float costo_general_total, Usuario usuario) {
        this.producto_id = producto_id;
        this.producto_nombre = producto_nombre;
        this.producto_descripcion = producto_descripcion;
        this.costo_materia_prima = costo_materia_prima;
        this.envio = envio;
        this.rentabilidad = rentabilidad;
        this.pdvs = pdvs;
        this.costo_general_total = costo_general_total;
        this.usuario = usuario;
    }

    public Producto() {
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public String getProducto_descripcion() {
        return producto_descripcion;
    }

    public void setProducto_descripcion(String producto_descripcion) {
        this.producto_descripcion = producto_descripcion;
    }

    public float getCosto_materia_prima() {
        return costo_materia_prima;
    }

    public void setCosto_materia_prima(float costo_materia_prima) {
        this.costo_materia_prima = costo_materia_prima;
    }

    public float getEnvio() {
        return envio;
    }

    public void setEnvio(float envio) {
        this.envio = envio;
    }

    public float getRentabilidad() {
        return rentabilidad;
    }

    public void setRentabilidad(float rentabilidad) {
        this.rentabilidad = rentabilidad;
    }

    public float getPdvs() {
        return pdvs;
    }

    public void setPdvs(float pdvs) {
        this.pdvs = pdvs;
    }

    public float getCosto_general_total() {
        return costo_general_total;
    }

    public void setCosto_general_total(float costo_general_total) {
        this.costo_general_total = costo_general_total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

