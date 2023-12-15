package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Destino;
import com.example.demo.models.DestinoDTO;



public interface DestinoService {
	
	List<Destino> getAllDestino();
	
	Destino getDestinoById(Long id);
	
	Destino saveDestino ( Destino destino);
	
	Destino upDateDestino(Long id, Destino destinoDTOUpdated);
	
	
	void deleteById(Long id);

	void addRelantionship(Long destinoId, Long clienteId);
	
	  List<Object> findAllRels();

	Destino saveDestino(DestinoDTO destinoDTO);
		 
		
	

	
	
	
	
	
	
}
	
	
	