package com.mujeres2000.system.Repository;


import com.mujeres2000.system.model.Costo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostoRepository extends JpaRepository<Costo,Integer> {

    @Query("SELECT c FROM costo_general c WHERE c.usuario.usuario_id = ?1")
    List<Costo> findAllByUsuarioId(Integer usuarioId);
}
