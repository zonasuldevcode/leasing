package br.com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.modelo.Veiculo;

@Repository
public interface VeiculoRepository  extends JpaRepository<Veiculo, Long>{


	//List<Veiculo> findByCategoriaDescricao(String descricao);

	//List<Veiculo> findByCategoriaNacionalidade(String nacionalidade);
	
    @Query( "SELECT v FROM Veiculo v WHERE v.placa =:placa")
	Veiculo findByPlaca(@Param("placa")String placa);	

}
