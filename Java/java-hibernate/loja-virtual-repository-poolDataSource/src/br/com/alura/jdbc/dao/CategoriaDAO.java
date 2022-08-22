package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;

//Data Acess Object
//Está ligada com a capacidade de isolar, em um único lugar, todo o código que acessa o seu repositório de dados
public class CategoriaDAO {
	
	private Connection connection;
	
	//Construtor recebe objeto de conexão:
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insertInto(Categoria categoria) throws SQLException {
		String sql = "INSERT INTO CATEGORIA (nome) VALUES (?)";
		
		try(PreparedStatement prepared = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			prepared.setString(1, categoria.getNome());
			prepared.execute();
			
			try(ResultSet rst = prepared.getGeneratedKeys()){
				while(rst.next()) {
					categoria.setId(rst.getInt(1));
				}
			}
			
		}
		

	}
	
	public List<Categoria> listar() throws SQLException{
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		String sql = "SELECT ID, NOME FROM CATEGORIA";
		
		try(PreparedStatement prepared = connection.prepareStatement(sql)){
			prepared.execute();
			
			try(ResultSet rst = prepared.getResultSet()){
				while(rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					categorias.add(categoria);
				}
			}
			
		}
		
		return categorias;
	}
	
	
	
}
