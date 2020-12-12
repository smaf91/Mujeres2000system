package com.mujeres2000.system.Repository;


import com.mujeres2000.system.model.CostoGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoGeneralRepository extends JpaRepository<CostoGeneral,Integer> {
}
