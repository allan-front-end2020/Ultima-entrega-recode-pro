package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.example.demo.models.Destino;
import com.example.demo.models.DestinoDTO;
import com.example.demo.services.DestinoService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

	@Autowired
	private DestinoService cs;

	@PostMapping("/savedestino")
	public Destino createDestino(@RequestBody Destino destino) {

		return cs.saveDestino(destino);
	}

	@GetMapping("/alldestino")
	public List<Destino> getAllDestino() {

		return cs.getAllDestino();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Destino> getDestinoById(@PathVariable Long id) {
		Destino destino = cs.getDestinoById(id);

		return ResponseEntity.ok(destino);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody DestinoDTO destinoUpdatedDTO) {
		Destino destino = cs.getDestinoById(id);

		destino.setNome(destinoUpdatedDTO.getNome());

		cs.upDateDestino(id, destino);

		return ResponseEntity.ok(destino);

	}

	@DeleteMapping("/{id}")
	public void deleteDestino(@PathVariable Long id) {
		cs.deleteById(id);
	}
	
	@ControllerAdvice
	public class GlobalExceptionHandler {

	    @ExceptionHandler(value = { NoResourceFoundException.class })
	    public String handleNotFoundException(Exception ex, Model model) {
	  
	        return "error";
	    }
	}

}
