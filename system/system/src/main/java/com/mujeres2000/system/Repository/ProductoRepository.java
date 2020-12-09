package com.mujeres2000.system.Repository;

import com.mujeres2000.system.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
