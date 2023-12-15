package com.example.demo.servicesImpl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.services.ClienteService;


@Service
public class ClienteServiceImplement  implements ClienteService{
	
	
	

	@Autowired
	private ClienteRepository sr;
	
	
	@Override
	public List<Cliente> getAllCliente() {
		
		return sr.findAll();
	}

	@Override
	public Cliente getClienteById(Long id) {
	
		return sr.findById(id).orElseThrow(()-> new RuntimeErrorException(null, "EEEEEEEEEEEEEEEEE"));
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
	
		return sr.save(cliente);
	}

	@Override
	public Cliente upDateCliente(Long id, Cliente clienteUpdated) {
		
		Cliente clienteExiste = sr.findById(id).orElseThrow(()-> new RuntimeErrorException(null, "EEEEEEEEEEEEEEEEE"));
	    clienteExiste.setNome(clienteUpdated);

		
		return sr.save(clienteExiste);
	}

	@Override
	public void deleteById(Long id) {
		sr.deleteById(id);
		
	}
	
	}