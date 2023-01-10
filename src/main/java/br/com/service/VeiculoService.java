package br.com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.modelo.Veiculo;
import br.com.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	public Veiculo salvar(Veiculo veiculo) {

		return repository.save(veiculo);

	}

	public Veiculo alterar(Long id, Veiculo veiculo) {

		Veiculo dados = buscarPorID(id);
		dados.setCor(veiculo.getCor());
		dados.setNacionalidade(veiculo.getNacionalidade());
		dados.setModelo(veiculo.getModelo());
		dados.setCategoria(veiculo.getCategoria());
		dados.setAno(veiculo.getAno());
		dados.setChassi(veiculo.getChassi());
		dados.setCombustivel(veiculo.getCombustivel());
		dados.setPlaca(veiculo.getPlaca());
		dados.setDiaria(veiculo.getDiaria());
		return repository.save(dados);

	}

	public void excluir(Long id) {
		repository.deleteById(id);
	}

	public Veiculo buscarPorID(Long id) {

		Optional<Veiculo> veiculos = repository.findById(id);

		return veiculos.orElse(null);

	}

	public List<Veiculo> buscarTodos() {

		return repository.findAll();
	}

	//public List<Veiculo> buscaCategoria(String descricao) {

	//	return repository.findByCategoriaDescricao(descricao);
	//}

	//public List<Veiculo> buscaNacionalidade(String nacionalidade) {
	//	return repository.findByCategoriaNacionalidade(nacionalidade);
	//}

}
