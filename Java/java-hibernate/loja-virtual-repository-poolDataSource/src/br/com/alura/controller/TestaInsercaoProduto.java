package br.com.alura.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoProduto {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Produto celular = new Produto("Celular","Xiaomi 10");
		
		try(Connection connection = new ConnectionFactory().criaConexao()) {
			
			try(
					PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)
				) {
				preparedStatement.setString(1, celular.getNome());
				preparedStatement.setString(2, celular.getDescricao());
				preparedStatement.execute();
				
				try(ResultSet rst = preparedStatement.getGeneratedKeys()) {
					while(rst.next()) {
						celular.setId(rst.getInt(1));
					}
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
	
			System.out.println(celular);
		}
		
	}

}
