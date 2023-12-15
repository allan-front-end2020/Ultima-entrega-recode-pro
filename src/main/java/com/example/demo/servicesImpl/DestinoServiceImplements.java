package com.example.demo.servicesImpl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.models.Destino;
import com.example.demo.models.DestinoDTO;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.DestinoRepository;
import com.example.demo.services.DestinoService;

@Service
public class DestinoServiceImplements implements DestinoService {
	
	


	@Autowired
	private DestinoRepository cr;

	@Autowired
	private ClienteRepository sr;

	public List<Destino> getAllDestino() {

		return cr.findAll();
	}

	@Override
	public Destino getDestinoById(Long id) {

		return cr.findById(id).orElseThrow(() -> new RuntimeErrorException(null, "EEEEEEEEEEEEEEEEE"));
	}

	@Override
	public Destino saveDestino(DestinoDTO destinoDTO) {
		
		Destino destino = mp.map(destinoDTO, Destino.class);

		return cr.save(destino);
	}

	@Override
	public Destino upDateDestino(Long id, Destino destinoUpdated) {

		Destino destinoExiste = cr.findById(id).orElseThrow(() -> new RuntimeErrorException(null, "EEEEEEEEEEEEEEEEE"));
		destinoExiste.setNome(destinoUpdated.getNome());

		return cr.save(destinoExiste);
	}

	@Override
	public void deleteById(Long id) {
		cr.deleteById(id);

	}

	public void addRelationship(Long destinoId, Long clienteId) {
		Destino destino = cr.findById(destinoId)
				.orElseThrow(() -> new RuntimeErrorException(null, "id;" + destinoId + "cccccccc"));
		Cliente cliente = sr.findById(clienteId)
				.orElseThrow(() -> new RuntimeErrorException(null, "id;" + destinoId + "cccccccc"));

		if (destino != null && cliente != null) {
			destino.getClientes().add(cliente);
			cliente.getDestino().add(destino);
			
			
			cr.save(destino);
			sr.save(cliente);
		}
	}

	@Override
	public void addRelantionship(Long destinoId, Long clienteId) {
		
	}

	@Override
	public List<Object> findAllRels() {
		return cr.findAllRels();
	}

	@Override
	public Destino saveDestino(Destino destino) {
		// TODO Auto-generated method stub
		return null;
	}

}
