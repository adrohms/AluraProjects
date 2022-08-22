package br.com.alura.jdbc.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	private String nomeCategoria;
	private Integer categoriaId;
	
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(Integer id, String nome, String descricao, String nomeCategoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.nomeCategoria = nomeCategoria;
	}
	
	public Produto(String nome, String descricao, Integer categoriaId) {
		this.nome = nome;
		this.descricao = descricao;
		this.categoriaId = categoriaId;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		this.id = id;
		
	}
	
	@Override
	public String toString() {
		return String.format("Id: %d | Nome: %s | Descricao: %s | Categoria: %s |", this.id, this.nome, this.descricao, this.nomeCategoria);
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Integer getCategoriaId() {
		return this.categoriaId;
	}




}
