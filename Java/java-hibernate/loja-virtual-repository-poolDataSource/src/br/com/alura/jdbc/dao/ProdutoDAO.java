package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Produto;

//Data Acess Object
//Está ligada com a capacidade de isolar, em um único lugar, todo o código que acessa o seu repositório de dados
public class ProdutoDAO {

	private Connection connection;
	
	public ProdutoDAO(Connection connection) throws SQLException {
		this.connection = connection;	
	}
	
	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO(NOME, DESCRICAO, CATEGORIA_ID) VALUES (?, ?, ?)";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());
			preparedStatement.setInt(3, produto.getCategoriaId());
			
			preparedStatement.execute();

			try(ResultSet rst = preparedStatement.getGeneratedKeys()){
				while(rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
		
	}
	
	public List<Produto> listar() throws SQLException {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.execute();
			
			try(ResultSet rst = preparedStatement.getResultSet()) {
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(2));
					produtos.add(produto);
				}
				
			}
		}
		
		return produtos;
	}
	
	public List<Produto> listarProdutoCategoria() throws SQLException {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT PR.ID, PR.NOME, PR.DESCRICAO, CAT.NOME FROM PRODUTO PR INNER JOIN CATEGORIA CAT ON PR.CATEGORIA_ID = CAT.ID";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.execute();
			
			try(ResultSet rst = preparedStatement.getResultSet()) {
				System.out.println(rst);
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4));
					produtos.add(produto);
				}
				
			}
		}
		
		return produtos;
	}
}
