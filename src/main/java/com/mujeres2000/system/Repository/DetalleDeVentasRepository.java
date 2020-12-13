package com.mujeres2000.system.Repository;

import com.mujeres2000.system.model.DetalleDeVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DetalleDeVentasRepository extends JpaRepository <DetalleDeVentas, Integer> {

    @Query("SELECT c FROM detalle_de_ventas c WHERE c.usuario.usuario_id = ?1")
    List<DetalleDeVentas> findAllByUsuarioId(Integer usuarioId);

    @Query("SELECT u FROM detalle_de_ventas u WHERE u.venta_id =?1 AND u.usuario.usuario_id = ?2")
    DetalleDeVentas findByVentaIdAndUsuarioId(Integer id, Integer usuario_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM detalle_de_ventas u WHERE u.venta_id =?1")
    void deleteByVentaId(Integer id);
}
