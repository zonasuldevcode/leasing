package br.com.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Veiculo implements Serializable {
	private static final long serialVersionUID = -2743621358627386156L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cor;
	private String placa;
	private String fabricante;
	private String combustivel;
	private String modelo;
	private String nacionalidade;
	private String categoria;
	
	//@Enumerated(EnumType.STRING)
	//private Situacao status = Situacao.DISPONIVEL;
	
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao Paulo")
	private LocalDate ano;
	
	private Float diaria;
	private String chassi;
	
	

	

	public Veiculo(Long id, String placa, String combustivel, String cor, String modelo, String fabricante,
			String chassi, LocalDate ano, Float diaria, String categoria, String nacionalidade) {
		super();
		this.id = id;
		this.placa = placa;
		this.combustivel = combustivel;
		this.cor = cor;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.chassi = chassi;
		this.ano = ano;
	
		this.diaria = diaria;
		this.categoria = categoria;
		this.nacionalidade = nacionalidade;
	}

	public Veiculo() {
		super();

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}

}