package com.mujeres2000.system.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "CATALOGO_DE_PROCDUTOS")
@Table(name = "catalogoDeProductos")

public class CatalogoDeProductos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catalogo_producto_ID;
    @Column(name = "stock")
    private int stock;
    @ManyToOne
    @JoinColumn(name = "usuario_ID", referencedColumnName = "usuario_ID")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "producto_ID", referencedColumnName = "producto_ID")
    private Producto producto;

    // CONSTRUCTOR

    public CatalogoDeProductos(int catalogo_producto_ID, int stock, Usuario usuario, Producto producto) {
        this.catalogo_producto_ID = catalogo_producto_ID;
        this.stock = stock;
        this.usuario = usuario;
        this.producto = producto;
    }

    public CatalogoDeProductos() {
    }
//GETTERS Y SETTERS


    public int getCatalogo_producto_ID() {
        return catalogo_producto_ID;
    }

    public void setCatalogo_producto_ID(int catalogo_producto_ID) {
        this.catalogo_producto_ID = catalogo_producto_ID;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
