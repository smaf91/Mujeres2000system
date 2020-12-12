package com.mujeres2000.system.Repository;

import com.mujeres2000.system.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    @Query("SELECT u FROM producto u WHERE u.producto_nombre =?1")
    Producto findByName(String producto_nombre);

    @Query("SELECT u FROM producto u WHERE u.producto_id =?1")
    Producto findByProductId(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM producto u WHERE u.producto_id =?1")
    void deleteByProductId(Integer id);

}
