package com.mujeres2000.system.model;

import javax.persistence.*;

@Entity(name = "CATALOGO_DE_PROCDUTOS")
@Table(name = "catalogoDeProductos")

public class CatalogoDeProductos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer catalogo_producto_ID;
    @Column(name = "stock")
    private int stock;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    private Producto producto;

    // CONSTRUCTOR

    public CatalogoDeProductos(Integer catalogo_producto_ID, int stock, Usuario usuario, Producto producto) {
        this.catalogo_producto_ID = catalogo_producto_ID;
        this.stock = stock;
        this.usuario = usuario;
        this.producto = producto;
    }

    public CatalogoDeProductos() {
    }

    //GETTERS Y SETTERS

    public Integer getCatalogo_producto_ID() {
        return catalogo_producto_ID;
    }

    public void setCatalogo_producto_ID(Integer catalogo_producto_ID) {
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
