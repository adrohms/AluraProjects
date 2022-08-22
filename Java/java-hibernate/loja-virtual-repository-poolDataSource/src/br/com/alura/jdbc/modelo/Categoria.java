package br.com.alura.jdbc.modelo;

public class Categoria {
	
	private Integer id;
	private String nome;
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return String.format("Id: %d | Nome: %s", this.id, this.nome);
	}
	
	
}