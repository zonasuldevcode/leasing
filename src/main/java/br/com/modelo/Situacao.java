package br.com.modelo;

public enum Situacao {
	
	
	ALUGADO("Alugado"), DISPONIVEL("Disponivel"), INDISPONIVEL("Indisponivel");
	
	
	public  String descricao;

	

	public void setDescricao(String descricao) {
		this.descricao = descricao;
		
	}



	private Situacao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
