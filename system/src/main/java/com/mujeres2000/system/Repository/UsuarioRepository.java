package com.mujeres2000.system.Repository;

import com.mujeres2000.system.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByEmail(String email);
}


//cablear en el servicio con el mismo nombre de esta clase