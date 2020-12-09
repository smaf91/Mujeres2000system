package com.mujeres2000.system.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
//Creacion de tabla de usuarios.

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int usuario_ID;

    //   @Email(message = "Ingrese su dirección de correo electrónico") //valida que sea un mail
    private String email;

    //   @NotNull (message = "Inserte su contraseña")
    private String password;

    @OneToMany (mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<producto> productos = new ArrayList<>();

//    private List<producto> ListaProducto;

    //CONSTRUCTOR

    public Usuario(int usuario_ID, String email, String password) {
        this.usuario_ID = usuario_ID;
        this.email = email;
        this.password = password;
    }

    //GETTERS AND SETTERS

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

    public List<producto> getProductos() {
        return productos;
    }

    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }
}

