package com.mujeres2000.system.Service;

import com.mujeres2000.system.Exception.BadRequestException;
import com.mujeres2000.system.Repository.UsuarioRepository;
import com.mujeres2000.system.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    //Implementación de los métodos del repositorio

    //Creación del método crearUsuario
    public Usuario crearUsuario(Usuario usuario) {
        //comprobación de que el usuario no tengo ya un mail registrado en el sistema
        if (usuario.getEmail() != null || usuario.getEmail().isEmpty()) {
            throw new BadRequestException("Registro inválido, usuario ya registrado"); // manejo de excepcion hecha en la clase de exception config
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    //Creación del método modificarUsuario
    public Usuario modificarUsuario(Usuario usuario) {
        // comprueba que el usuario ya esta registrado
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new BadRequestException("Usuario no registrado"); // manejo de excepcion hecha en la clase de exception config
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    //Creación del método eliminarUsuario
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    //Creación del método obtenerPorEmail
    public Optional<Usuario> obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    //Creación del método obtenerPorId
    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    // creación del método de BuscarTodosLosUsuarios para obtener una lista
    public List<Usuario> BuscarTodosLosUsuarios(Usuario usuario) {
        List<Usuario> listaDeUsuarios = usuarioRepository.findAll();
        return listaDeUsuarios;
    }
}
