package com.mujeres2000.system.Service;

import com.mujeres2000.system.Exception.BadRequestException;
import com.mujeres2000.system.Exception.NotFoundException;
import com.mujeres2000.system.Exception.UnauthorizedException;
import com.mujeres2000.system.Repository.UsuarioRepository;
import com.mujeres2000.system.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    //Implementación de los métodos del repositorio

    //Creación del método crearUsuario
    public Usuario crearUsuario(Usuario usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new BadRequestException("Usuario debe indicar el email");
        }

        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            throw new BadRequestException("Usuario debe indicar el password");
        }
        //comprobación de que el usuario no tengo ya un mail registrado en el sistema
        Usuario usuarioGuardado = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioGuardado != null) {
            throw new BadRequestException("Registro inválido, usuario ya registrado"); // manejo de excepcion hecha en la clase de exception config
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    public Usuario ingresoUsuario(Usuario usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new BadRequestException("Usuario debe indicar el email");
        }

        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            throw new BadRequestException("Usuario debe indicar el password");
        }
        //comprobación de que el usuario no tengo ya un mail registrado en el sistema
        Usuario usuarioGuardado = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioGuardado != null && usuarioGuardado.getEmail().equals(usuario.getEmail()) && usuarioGuardado.getPassword().equals(usuario.getPassword())) {
            return usuarioGuardado;
        } else {
            throw new UnauthorizedException("Usuario no registrado"); // manejo de excepcion hecha en la clase de exception config
        }
    }

    public Usuario obtenerUsuario(Integer usuarioId) {
        Usuario usuarioGuardado = usuarioRepository.findByUsuarioId(usuarioId);
        if (usuarioGuardado == null) {
            throw new BadRequestException("Usuario no existe"); // manejo de excepcion hecha en la clase de exception config
        }
        return usuarioGuardado;
    }
}
