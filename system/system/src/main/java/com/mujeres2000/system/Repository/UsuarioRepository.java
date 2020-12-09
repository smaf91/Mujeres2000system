package com.mujeres2000.system.Repository;

import com.mujeres2000.system.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
