package com.mujeres2000.system.Repository;

import com.mujeres2000.system.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    @Query("SELECT p FROM producto p WHERE p.producto_nombre = ?1 AND p.usuario.usuario_id = ?2")
    Producto findByNameAndUsuarioId(String producto_nombre, Integer usuarioId);

    @Query("SELECT p FROM producto p WHERE p.producto_id = ?1 AND p.usuario.usuario_id = ?2")
    Producto findByProductIdAndUsuarioId(Integer id, Integer usuarioId);

    @Query("SELECT p FROM producto p WHERE p.usuario.usuario_id = ?1")
    List<Producto> findAllProductsByUsuarioId(Integer usuarioId);

    @Transactional
    @Modifying
    @Query("DELETE FROM producto p WHERE p.producto_id = ?1")
    void deleteByProductId(Integer id);

}
