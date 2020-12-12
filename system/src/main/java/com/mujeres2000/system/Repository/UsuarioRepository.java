package com.mujeres2000.system.Repository;
import com.mujeres2000.system.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query ("SELECT u FROM usuario u WHERE u.email =?1")
    Usuario findByEmail(String email);

}