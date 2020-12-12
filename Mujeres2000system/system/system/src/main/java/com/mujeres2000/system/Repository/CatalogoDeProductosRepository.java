package com.mujeres2000.system.Repository;

import com.mujeres2000.system.model.CatalogoDeProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoDeProductosRepository extends JpaRepository<CatalogoDeProductos, Integer> {
}
