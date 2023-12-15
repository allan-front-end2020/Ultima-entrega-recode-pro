package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Destino;

import jakarta.transaction.Transactional;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {
   
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true, value="INSERT INTO reserva (destino_id, cliente_id) VALUES (:destinoId, :clienteId)")
	void addRelationship(@Param("destinoId") Long destinoId, @Param("clienteId") Long clienteId);
	
	
	
	
	@Query(nativeQuery=true, value="SELECT c.destino_nome, s.cliente_nome"		
	+ "FROM reserva as cs"
	+ "INNER JOIN destino as c" 
	+ "ON c.id = cs.destino_id "
	+ "INNER JOIN cliente as s" 
	+ "ON s.id = cs.cliente_id "
	)
	
	List<Object> findAllRels();
	
	
	
//	@Query(nativeQuery=true, value="")		

}