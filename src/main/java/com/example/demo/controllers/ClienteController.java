package com.example.demo.controllers;

import java.util.List;

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

import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private ClienteService ss;

	@PostMapping("/savecliente")
	public Cliente createCliente(@RequestBody Cliente cliente) {

		return ss.saveCliente(cliente);
	}

	@GetMapping("/allcliente")
	public List<Cliente> getAllCliente() {

		return ss.getAllCliente();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		Cliente cliente = ss.getClienteById(id);

		return ResponseEntity.ok(cliente);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteUpdated) {
		Cliente cliente = ss.getClienteById(id);

		cliente.setNome(clienteUpdated.getNome());

		ss.saveCliente(cliente);

		return ResponseEntity.ok(cliente);

	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long id) {
		ss.deleteById(id);
	}

	@ControllerAdvice
	public class GlobalExceptionHandler {

		@ExceptionHandler(value = { NoResourceFoundException.class })
		public String handleNotFoundException(Exception ex, Model model) {

			return "error";
		}
	}

}
