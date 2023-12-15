package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ReservaDTO;
import com.example.demo.services.DestinoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
	
	
	
	@Autowired
	private DestinoService cs;
	
	
	@PostMapping("/addrelation")
	public ResponseEntity<String> addRelantionship(@RequestBody ReservaDTO csDTO){
		cs.addRelantionship(csDTO.getDestinoId(), csDTO. getClienteId());
		
		
		return new ResponseEntity<String>("xxxxxx", HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping("/findallrels")
	public List<Object> findAllRels(){
		
		
		
		return cs.findAllRels();
		
	}
	
	

}
