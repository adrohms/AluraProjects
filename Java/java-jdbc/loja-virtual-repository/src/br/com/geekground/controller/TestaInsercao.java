package br.com.geekground.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TestaInsercao {

	public static void main(String[] args) {

		ConnectionFactory connectionFactory = new ConnectionFactory();
	
		Connection connection;
		
		try {
			connection = connectionFactory.criaConexao();
			Statement stm = connection.createStatement();
			boolean resultado = 
					stm.execute("INSERT INTO PRODUTO (nome, descricao)"
							+ "VALUES ('Mouse', 'Mouse sem fio Logtech')",
							Statement.RETURN_GENERATED_KEYS);
			System.out.println(resultado);
			
			ResultSet rst = stm.getGeneratedKeys();
	
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("Id: " + id);
			}
			
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	
		
	}

}
