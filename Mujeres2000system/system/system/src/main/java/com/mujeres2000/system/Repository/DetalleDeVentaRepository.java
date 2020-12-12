package com.mujeres2000.system.Repository;

import com.mujeres2000.system.model.DetalleDeVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleDeVentaRepository extends JpaRepository< DetalleDeVenta,Integer> {
}
