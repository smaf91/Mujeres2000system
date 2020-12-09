package com.mujeres2000.system.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "producto")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int producto_ID;
    private String producto_nombre;
    private String producto_descripcion;
    private int costo_materia_prima;
    private int envio;
    private int rentabilidad;
    private int pdvs;
    private Date fecha_producto;
    private int indicendia_de_cg;
    // cg se refiere a la variable costo_generales
    // como idea podria definirse un porcentaje sobre esa incidencia en los productos
    // ya que por lo general se define como costos / cantidad de productos a producir
    // en este caso lo desconocemos.
    private int costo_general_total;
    @ManyToOne
    @JoinColumn(name = "usuario_ID", referencedColumnName = "usuario_ID")
    private Usuario usuario;

    //CONSTRUCTOR

    public Producto(int producto_ID, String producto_nombre, String producto_descripcion, int costo_materia_prima, int envio, int rentabilidad, int pdvs, Date fecha_producto, int indicendia_de_cg ) {
        this.producto_ID = producto_ID;
        this.producto_nombre = producto_nombre;
        this.producto_descripcion = producto_descripcion;
        this.costo_materia_prima = costo_materia_prima;
        this.envio = envio;
        this.rentabilidad = rentabilidad;
        this.pdvs = pdvs;
        this.fecha_producto = fecha_producto;
        this.indicendia_de_cg = indicendia_de_cg;
        this.costo_general_total = costo_materia_prima;
    }

    public int getProducto_ID() {
        return producto_ID;
    }

    public void setProducto_ID(int producto_ID) {
        this.producto_ID = producto_ID;
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

    public int getCosto_materia_prima() {
        return costo_materia_prima;
    }

    public void setCosto_materia_prima(int costo_materia_prima) {
        this.costo_materia_prima = costo_materia_prima;
    }

    public int getEnvio() {
        return envio;
    }

    public void setEnvio(int envio) {
        this.envio = envio;
    }

    public int getRentabilidad() {
        return rentabilidad;
    }

    public void setRentabilidad(int rentabilidad) {
        this.rentabilidad = rentabilidad;
    }

    public int getPdvs() {
        return pdvs;
    }

    public void setPdvs(int pdvs) {
        this.pdvs = pdvs;
    }

    public Date getFecha_producto() {
        return fecha_producto;
    }

    public void setFecha_producto(Date fecha_producto) {
        this.fecha_producto = fecha_producto;
    }

    public int getIndicendia_de_cg() {
        return indicendia_de_cg;
    }

    public void setIndicendia_de_cg(int indicendia_de_cg) {
        this.indicendia_de_cg = indicendia_de_cg;
    }

    public int getCosto_general_total() {
        return costo_general_total;
    }

    public void setCosto_general_total(int costo_general_total) {
        this.costo_general_total = costo_general_total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
