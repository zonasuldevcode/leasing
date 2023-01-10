package br.com.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Vendedor implements Serializable {
	
	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}


	private static final long serialVersionUID = -3841162318781938724L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int matricula;
	private String email;
	private String telefone;
	
	
	
	
	


	@Override
	public int hashCode() {
		return Objects.hash(id, matricula);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(id, other.id) && Objects.equals(matricula, other.matricula);
	}


	public Vendedor(Long id, String nome, int matricula, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.telefone = telefone;
	}
	
	
}



