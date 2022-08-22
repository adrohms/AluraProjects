package br.com.geekground.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestaListagem {

	/*
	 * CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL,
	 * descricao VARCHAR(255), PRIMARY KEY (id)) Engine = InnoDB;
	 * Engine = InnoDB para aceitar a transação!
	 */

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//mysql -u root -p 'loja_virtual'
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criaConexao();

		PreparedStatement stm = connection.prepareStatement("SELECT * FROM PRODUTO");
		stm.execute();  //Retorna uma boolean informando se o resultado é uma lista ou não!
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			System.out.println("Id: " + id + ", nome: " + nome + ", descricao: " +  descricao);
		}
		
		connection.close();
	}

}
