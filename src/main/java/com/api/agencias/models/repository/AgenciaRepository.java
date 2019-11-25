package com.api.agencias.models.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.api.agencias.models.entity.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
	
	@Query("SELECT a FROM Agencia a WHERE a.nombre LIKE %:nombre%")
	List<Agencia> findByName(@Param("nombre") String nombre);

}
