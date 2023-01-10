package br.com.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.modelo.Veiculo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDtoForm {
	private Long id;
	private String placa;
	private String combustivel;
	private String cor;
	private String fabricante;
	private String modelo;
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao Paulo")
	private LocalDate ano;
	private Float diaria;
	private String categoria;
	private String nacionalidade;
	private String chassi;
	
	
	





public VeiculoDtoForm(Veiculo veiculo) {
	
	this.id = veiculo.getId();
	this.placa = veiculo.getPlaca();
	this.combustivel = veiculo.getCombustivel();
	this.cor = veiculo.getCor();
	this.fabricante = veiculo.getFabricante();
	this.modelo = veiculo.getModelo();
	this.chassi = veiculo.getChassi();
	this.ano = veiculo.getAno();
	this.diaria =veiculo.getDiaria();
	this.nacionalidade = veiculo.getNacionalidade();
	this.categoria = veiculo.getCategoria();
}

public static List<VeiculoDtoForm> converter(List<Veiculo> veiculos) {
	return veiculos.stream().map(VeiculoDtoForm::new).collect(Collectors.toList());
}





}
