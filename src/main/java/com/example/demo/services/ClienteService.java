package com.example.demo.services;

import java.util.List;



import com.example.demo.models.Cliente;


public interface ClienteService   {

	
	
List<Cliente> getAllCliente();
	
	Cliente getClienteById(Long id);
	
	Cliente saveCliente( Cliente cliente);
	
	Cliente upDateCliente(Long id, Cliente clienteUpdated);
	
	
	void deleteById(Long id);
	
}

	
	
