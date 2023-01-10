package br.com.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.modelo.Aluguel;
import br.com.modelo.Cliente;
import br.com.modelo.Veiculo;
import br.com.modelo.Vendedor;
import br.com.repository.ClienteRepository;
import br.com.repository.VeiculoRepository;
import br.com.repository.VendedorRepository;
import br.com.service.AluguelService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin("*")
@RestController
@RequestMapping("aluguel")
public class ControleAluguel {
	
	@Autowired
	private AluguelService service;
	
	
	
	

	@ApiOperation(value = "Cadastra um Aluguel")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Aluguel Cadastrado Com Sucesso"),
	@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping(value = "salvar", produces ="application/json")
	
	public ResponseEntity<Aluguel> create(Aluguel aluguel,Long idCliente, Long idVendedor, Long idVeiculo) {
		
		
		this.service.cadastrar(idVeiculo,idCliente,idVendedor);
		
		return ResponseEntity.ok().body(aluguel);
		
	}
	

}