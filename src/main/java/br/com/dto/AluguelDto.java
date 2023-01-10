package br.com.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import br.com.modelo.Aluguel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AluguelDto {
	
	private String nomeCliente;
	private String nomeVendedor;
	private String  modeloVeiculo;
	private String fabricanteVeiculo;
	private String  placaVeiculo;
	private String  corVeiculo;
	private BigDecimal total;
	
	
	public AluguelDto(Aluguel aluguel) {
		
		this.nomeCliente = aluguel.getCliente().getNome();
		this.nomeVendedor = aluguel.getVendedor().getNome();
		this.modeloVeiculo = aluguel.getVeiculo().getModelo();
		this.fabricanteVeiculo = aluguel.getVeiculo().getFabricante();
		this.placaVeiculo = aluguel.getVeiculo().getPlaca();
		this.corVeiculo = aluguel.getVeiculo().getCor();
		this.total = aluguel.getTotal();
	}
	
	
	public static List<AluguelDto> converter(List<Aluguel> alugueis) {
		return alugueis.stream().map(AluguelDto::new).collect(Collectors.toList());
	}
}
