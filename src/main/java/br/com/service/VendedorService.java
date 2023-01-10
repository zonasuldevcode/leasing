package br.com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.modelo.Vendedor;
import br.com.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository repository;

	public Vendedor salvar(Vendedor vendedor) {

		vendedor.setId(null);
		return repository.save(vendedor);
	}

	public List<Vendedor> buscarTodos(){

		return repository.findAll();
	}



	public Vendedor buscarPorId(Long id) {
		Optional<Vendedor> vendedores = repository.findById(id);
		return vendedores.orElse(null);
	}



	public Vendedor update(Long id, Vendedor vendedor) {

		Vendedor dados = buscarPorId(id);
		dados.setEmail(vendedor.getEmail());
		dados.setTelefone(vendedor.getTelefone());
		dados.setNome(vendedor.getNome());
		dados.setMatricula(vendedor.getMatricula());
		return repository.save(dados);
	}




	public void delete(Long id) {

		repository.deleteById(id);

	}

}


