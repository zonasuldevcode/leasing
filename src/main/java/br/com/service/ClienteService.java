package br.com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.modelo.Cliente;
import br.com.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	

	public Cliente salvar(Cliente cliente) {

		cliente.setId(null);
		return repository.save(cliente);

	}
	
	public List<Cliente> buscarTodos(){
		
		return repository.findAll();
	}
	
	

	public Cliente buscarPorID(Long id) {
		Optional<Cliente> clientes = repository.findById(id);
		return clientes.orElse(null);
	}
	
	

	public Cliente update(Long id, Cliente cliente) {
         
		Cliente dados = buscarPorID(id);
		dados.setEmail(cliente.getEmail());
		dados.setTelefone(cliente.getTelefone());
		return repository.save(dados);
	}
	
	
	

	public void delete(Long id) {

		repository.deleteById(id);

	}

}
