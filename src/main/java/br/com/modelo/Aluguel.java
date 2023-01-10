package br.com.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Aluguel implements Serializable {

	private static final long serialVersionUID = -4875956426285807918L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "America/Sao Paulo")
	private LocalDate dataRetirada = LocalDate.now();
	
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "America/Sao Paulo")
	private LocalDate dataDevolucao = LocalDate.now();;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne Veiculo veiculo;
	
	@ManyToOne
	private Vendedor vendedor;
	
	private BigDecimal total;

	
	
	public Aluguel(Long id,LocalDate dataRetirada,LocalDate dataDevolucao, Cliente cliente, Veiculo veiculo, Vendedor vendedor, BigDecimal total) {
		super();
		this.id = id;
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.vendedor = vendedor;
		this.total = total;
	}

	public Aluguel() {
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
		Aluguel other = (Aluguel) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	

}
