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
import br.com.dto.VendedorDto;
import br.com.modelo.Vendedor;
import br.com.service.VendedorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("vendedor")
public class ControleVendedor {
	
	@Autowired
	private VendedorService service;
	
	
	
	@ApiOperation(value = "Cadastro de Vendedores")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Vendedor Cadastrado com Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	
	@PostMapping(value= "cadastrar", produces = "application/json")
	public ResponseEntity<VendedorDto> cadastrar(@RequestBody Vendedor vendedor, UriComponentsBuilder uriBuilder) {
		
		
       VendedorDto dto = new VendedorDto(service.salvar(vendedor));
		URI uri = uriBuilder.path("salvar{id}").buildAndExpand(vendedor.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	
	@ApiOperation(value = "Pesquisa de Vendedores")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Vendedor Encontrado com Id Informado"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	
	
	@GetMapping(value = "{id}", produces = "application/json")
	public ResponseEntity<VendedorDto> listar(@PathVariable Long id) {

		VendedorDto dto = new VendedorDto(service.buscarPorId(id));
		return ResponseEntity.ok().body(dto);

	}
	
	
	
	@ApiOperation(value = "Pesquisa de Vendedores")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Relação de Vendedores Encontrados"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(value = "listar", produces = "application/json")
	public ResponseEntity<List<Vendedor>> listarTodos() {
		List<Vendedor> vendedores = service.buscarTodos();
		return ResponseEntity.ok().body(vendedores);
	}
	
	
	
	
	@ApiOperation(value = "EXclusão de Vendedor")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Vendedor Excluído com Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})

	@DeleteMapping(value = "{id}", produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	@ApiOperation(value = "Alterar Informações de Vendedores")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Informações Alteradas com Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PutMapping(value= "{id}", produces = "application/json")
	public ResponseEntity<VendedorDto> alterar(@PathVariable Long id, @RequestBody Vendedor vendedor) {
		Vendedor dados = service.update(id, vendedor);
		return ResponseEntity.ok().body(new VendedorDto(dados));
	}
	
	
	

}
