package br.com.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.modelo.Cliente;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteDto {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;

	

	public ClienteDto(Cliente cliente) {

		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.cpf = cliente.getCpf();
	}

	public ClienteDto() {
		super();
		
	}
	
	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

	
}
