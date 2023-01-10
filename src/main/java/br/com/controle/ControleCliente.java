package br.com.controle;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
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
import br.com.dto.ClienteDto;
import br.com.modelo.Cliente;
import br.com.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("cliente")
public class ControleCliente {
	
	
	@Autowired
	private ClienteService service;

	
	@ApiOperation(value = "Cadastra um Cliente")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Cliente Cadastrado Com Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	
	@PostMapping(value= "cadastrar" , produces ="application/json")
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente,UriComponentsBuilder uriBuilder) {
		

        this.service.salvar(cliente);
        URI uri = uriBuilder.path("salvar{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
      
    }
	
	
	
	@ApiOperation(value = "Pesquisa de Clientes")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Cliente Encontrado com Id Informado"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	
	
	@GetMapping(value = "{id}", produces = "application/json")
	public ResponseEntity<ClienteDto> listar(@PathVariable Long id) {

		ClienteDto dto = new ClienteDto(service.buscarPorID(id));
		return ResponseEntity.ok().body(dto);

	}
	
	
	
	@ApiOperation(value = "Pesquisa de Clientes")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Relação de Clientes Encontrados"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(value = "listar", produces = "application/json")
	public List<ClienteDto> listarTodos() {
		List<Cliente> clientes = service.buscarTodos();
		return ClienteDto.converter(clientes);
	}
	
	
	
	
	@ApiOperation(value = "EXclusão de Clientes")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Cliente Excluído com Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})

	@DeleteMapping(value = "{id}", produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	@ApiOperation(value = "Alterar Informações de Clientes")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Informações Alteradas com Sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PutMapping(value= "{id}", produces = "application/json")
	public ResponseEntity<ClienteDto> alterar(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente dados = service.update(id, cliente);
		return ResponseEntity.ok().body(new ClienteDto(dados));
	}
	
	
}
