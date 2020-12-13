package com.mujeres2000.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import javax.persistence.*;

@Entity(name = "usuario")
@Table(name = "usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "usuario_id")
    private Integer usuario_id;

    //   @Email(message = "Ingrese su dirección de correo electrónico") //valida que sea un mail
    @Column (name = "email", length = 255 )
    private String email;

    //   @NotNull (message = "Inserte su contraseña")
    @Column (name = "password", length = 255 )
    private String password;

    @OneToMany (mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JsonIgnore
    private List<Producto> producto;

    @OneToMany (mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JsonIgnore
    private List<Costo> costo;
    @JsonIgnore
    @OneToMany (mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<DetalleDeVentas> ventas;

    //CONSTRUCTOR

    public Usuario(Integer usuario_id, String email, String password) {
        this.usuario_id = usuario_id;
        this.email = email;
        this.password = password;
    }

    public Usuario() {
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

}

