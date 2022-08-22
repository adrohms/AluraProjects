package br.com.geekground.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try(Connection connection = connectionFactory.criaConexao()){
			connection.setAutoCommit(false); // False para assumir o controle das transações!
			
			// Try with with resources, all classes that implements AutoCloseable can be used here!
			// QUais extendem AutoCloseable: ResultSet, Connection, PreparedStatement
			try ( // Try look for the close() method of AutoCloseable: PreparedStatement -> Statement -> Wrapper, AutoCloseable
					PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)
				){
	
				adicionarVariavel("Processador", "Ryzen 5 5600X", preparedStatement);
				adicionarVariavel("Mouse", "Mouse Reddrago 10000 dpi", preparedStatement);
				adicionarVariavel("Mouse", "Mouse Logtech 16000 dpi", preparedStatement);
				adicionarVariavel("Processador", "Processador Intel i10", preparedStatement);
	
				connection.commit(); // Agora estamos validando que pode prosseguir com a inserção depois de todos terem passado!
	
			} catch (SQLException | IOException e) {
				e.printStackTrace();
				System.out.println("Rollback executado!");
				connection.rollback(); // Outro controle de transação, se algum item não passar, todas as transações são desfeitas!
			}
		}

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement preparedStatement)
			throws SQLException, IOException {
		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, descricao);

		
		if(nome.equals("Monitor")) { throw new IOException("Produto já inserido!"); }
		 

		preparedStatement.execute();

		try(ResultSet rst = preparedStatement.getGeneratedKeys()){

			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("Id: " + id);
			}
		}
		
	}

}
