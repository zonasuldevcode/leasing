package br.com.controle;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.dto.VeiculoDtoForm;
import br.com.modelo.Veiculo;
import br.com.service.VeiculoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin("*")
@RestController
@RequestMapping("veiculo")
public class ControleVeiculo {

	@Autowired
	private VeiculoService service;

	@ApiOperation(value = "Cadastro de Veículos")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Veículo Cadastrado Com Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	
	@PostMapping(value = "cadastrar", produces ="application/json")
	public ResponseEntity<Veiculo> create(@RequestBody  Veiculo veiculo, UriComponentsBuilder uriBuilder) {
		
        service.salvar(veiculo);
		URI uri = uriBuilder.path("salvar{id}").buildAndExpand(veiculo.getId()).toUri();
		
        return ResponseEntity.created(uri).body(veiculo);
	}
	

	@ApiOperation(value = "Pesquisa de Veículos")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Veículo Encontrado com Id Informado"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(value = "{id}",  produces ="application/json")
	public ResponseEntity<VeiculoDtoForm> readById(@PathVariable Long id) {

		VeiculoDtoForm dto = new VeiculoDtoForm(service.buscarPorID(id));
		return ResponseEntity.ok().body(dto);

	}
	@ApiOperation(value = "Pesquisa de Veículos")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Relação de Veículos Encontrados"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(value= "listar", produces ="application/json")
	public List<VeiculoDtoForm> readyAll() {
		List<Veiculo> veiculos = service.buscarTodos();
		return VeiculoDtoForm.converter(veiculos);
	}
	
	
	@ApiOperation(value = "EXclusão de Veículos")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Veículo Excluído com Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@DeleteMapping(value = "{id}", produces ="application/json")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	@ApiOperation(value = "Alterar Informações de Veículos")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Informações Alteradas com Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PutMapping(value = "{id}", produces ="application/json")
	public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody Veiculo veiculo) {
		Veiculo dados = service.alterar(id, veiculo);
		return ResponseEntity.ok().body(dados);
	}
	
	//@ApiOperation(value = "Pesquisa Descrição do Veículo com Base na Categoria")
	//@ApiResponses(value = {
	///    @ApiResponse(code = 200, message = "Descrição Retornada com Sucesso"),
	///    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	//    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	//})
	//@GetMapping(value = "descricao", produces ="application/json")
	///public List<VeiculoDtoForm> findByCategoria(String descricao) {
	////	List<Veiculo> veiculos = service.buscaCategoria(descricao);
		///return VeiculoDtoForm.converter(veiculos);
///		 
	//}

	
	
	//@ApiOperation(value = "Pesquisa Nacionalidade do Veículo com Base na Categoria")
	//@ApiResponses(value = {
	//    @ApiResponse(code = 200, message = "Nacionalidade Retornada com Sucesso"),
	  //  @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	//    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	//})
//	@GetMapping(value = "nacionalidade", produces ="application/json")
	///public List<VeiculoDtoForm> findByNacionalidade(String nacionalidade){
	//	
	///	List<Veiculo> veiculo =service.buscaNacionalidade(nacionalidade);
	///	return VeiculoDtoForm.converter(veiculo);
///	}
	
	
	//@GetMapping("placa")
	//public List<VeiculoDto> searchPlaca(String placa) {
		//List<Veiculo> veiculo = service.buscaPlaca(placa);
		//return VeiculoDto.converter(veiculo);
	//
}
