package com.mujeres2000.system.model;
import java.util.List;

import javax.persistence.*;

@Entity(name = "usuario")
@Table(name = "usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_ID;

    //   @Email(message = "Ingrese su dirección de correo electrónico") //valida que sea un mail
    @Column (name = "email", length = 255 )
    private String email;

    //   @NotNull (message = "Inserte su contraseña")
    @Column (name = "password", length = 255 )
    private String password;

    @OneToMany (mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Producto> producto;

    //CONSTRUCTOR

    public Usuario(int usuario_ID, String email, String password) {
        this.usuario_ID = usuario_ID;
        this.email = email;
        this.password = password;
    }

    public Usuario() {
    }

    public int getUsuario_ID() {
        return usuario_ID;
    }

    public void setUsuario_ID(int usuario_ID) {
        this.usuario_ID = usuario_ID;
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

