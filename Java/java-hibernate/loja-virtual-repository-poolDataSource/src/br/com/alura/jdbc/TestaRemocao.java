package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criaConexao();
		
		PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
		statement.setInt(1, 4);
		statement.execute();
		
		Integer modify = statement.getUpdateCount();
		System.out.println("Linhas modificadas: " + modify);
		
		connection.close();
	}

}
