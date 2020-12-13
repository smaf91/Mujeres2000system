package com.mujeres2000.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "detalle_de_ventas")
@Table(name = "detalle_de_ventas")
public class DetalleDeVentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta_id")
    private Integer venta_id;
    @Column(name = "canal_de_venta", length = 255)
    private String canal_de_venta;
    @Column(name = "cantidad", length = 10)
    private Integer cantidad;
    @Column(name = "precio_de_venta", length = 10)
    private Double precio_de_venta;
    @Column(name = "fecha_de_venta")
    private Date fecha_de_venta;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    private Producto producto;

    //CONSTRUCTOR


    public DetalleDeVentas(Integer venta_id, String canal_de_venta, Integer cantidad, Double precio_de_venta, Date fecha_de_venta, Usuario usuario, Producto producto) {
        this.venta_id = venta_id;
        this.canal_de_venta = canal_de_venta;
        this.cantidad = cantidad;
        this.precio_de_venta = precio_de_venta;
        this.fecha_de_venta = fecha_de_venta;
        this.usuario = usuario;
        this.producto = producto;
    }

    public DetalleDeVentas() {
    }

   // GETTERS Y SETTERS


    public Integer getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(Integer venta_id) {
        this.venta_id = venta_id;
    }

    public String getCanal_de_venta() {
        return canal_de_venta;
    }

    public void setCanal_de_venta(String canal_de_venta) {
        this.canal_de_venta = canal_de_venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_de_venta() {
        return precio_de_venta;
    }

    public void setPrecio_de_venta(Double precio_de_venta) {
        this.precio_de_venta = precio_de_venta;
    }

    public Date getFecha_de_venta() {
        return fecha_de_venta;
    }

    public void setFecha_de_venta(Date fecha_de_venta) {
        this.fecha_de_venta = fecha_de_venta;
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