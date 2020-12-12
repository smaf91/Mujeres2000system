package com.mujeres2000.system.Service;

import com.mujeres2000.system.Exception.BadRequestException;
import com.mujeres2000.system.Exception.NotFoundException;
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
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            throw new BadRequestException("Registro inválido, usuario ya registrado"); // manejo de excepcion hecha en la clase de exception config
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    public Usuario ingresoUsuario(Usuario usuario) {
        //comprobación de que el usuario no tengo ya un mail registrado en el sistema
        Usuario usuarioGuardado = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioGuardado != null && usuarioGuardado.getEmail().equals(usuario.getEmail()) && usuarioGuardado.getPassword().equals(usuario.getPassword())) {
            return usuario;
        } else {
            throw new NotFoundException("Usuario no registrado"); // manejo de excepcion hecha en la clase de exception config
        }
    }
}
