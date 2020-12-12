package com.mujeres2000.system.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity (name = "DETALLE_DE_VENTA")
@Table(name = "detalleDeVenta")

public class DetalleDeVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int venta_ID;
    @Column(name = "fecha_de_venta")
    private Date fecha_de_venta;
    @NotBlank(message = "Ingrese precio de venta")
    private int precio_de_venta;
    @NotBlank(message = "Ingrese cantidad de unidades vendidas")
    private int cantidad;
    @Column(name = "canal_de_venta")
    private String canal_de_venta;
    @ManyToOne
    @JoinColumn(name = "usuario_ID", referencedColumnName = "usuario_ID")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "producto_ID", referencedColumnName = "producto_ID")
    private Producto producto;

    //CONSTRUCTOR

    public DetalleDeVenta(int venta_ID, Date fecha_de_venta, @NotBlank(message = "Ingrese precio de venta") int precio_de_venta, @NotBlank(message = "Ingrese cantidad de unidades vendidas") int cantidad, String canal_de_venta, Usuario usuario, Producto producto) {
        this.venta_ID = venta_ID;
        this.fecha_de_venta = fecha_de_venta;
        this.precio_de_venta = precio_de_venta;
        this.cantidad = cantidad;
        this.canal_de_venta = canal_de_venta;
        this.usuario = usuario;
        this.producto = producto;
    }

    public DetalleDeVenta() {
    }

// GETTERS Y SETTERS

    public int getVenta_ID() {
        return venta_ID;
    }

    public void setVenta_ID(int venta_ID) {
        this.venta_ID = venta_ID;
    }

    public Date getFecha_de_venta() {
        return fecha_de_venta;
    }

    public void setFecha_de_venta(Date fecha_de_venta) {
        this.fecha_de_venta = fecha_de_venta;
    }

    public int getPrecio_de_venta() {
        return precio_de_venta;
    }

    public void setPrecio_de_venta(int precio_de_venta) {
        this.precio_de_venta = precio_de_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCanal_de_venta() {
        return canal_de_venta;
    }

    public void setCanal_de_venta(String canal_de_venta) {
        this.canal_de_venta = canal_de_venta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}