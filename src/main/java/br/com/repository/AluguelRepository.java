package br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.modelo.Aluguel;
import br.com.modelo.Cliente;
import br.com.modelo.Veiculo;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
	
	//List<Aluguel>findAllVeiculo(Veiculo veiculo);
	//List<Aluguel>findAllCliente(Cliente cliente);

}
