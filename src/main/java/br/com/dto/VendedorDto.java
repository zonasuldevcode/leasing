package br.com.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.modelo.Vendedor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VendedorDto {

	private Long id;
	private String nome;
	private Integer matricula;
	private String email;
	private String telefone;
	
	
	public VendedorDto(Vendedor vendedor) {
		
		this.id = vendedor.getId();
		this.nome = vendedor.getNome();
		this.matricula = vendedor.getMatricula();
		this.email = vendedor.getEmail();
		this.telefone = vendedor.getTelefone();
	}

	public VendedorDto() {
		super();

	}
	
	public static List<VendedorDto> converter(List<Vendedor> vendedores) {
		return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
	}

}
