package br.com.ghabriel.jdbc.modelo;

public class Categoria {
	private Integer id;
	private String nome;
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	
}
