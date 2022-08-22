package br.com.geekground.controller;
import java.sql.Connection;
import java.sql.SQLException;


public class TestaConexao {

	/*
	 * CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL,
	 * descricao VARCHAR(255), PRIMARY KEY (id)) Engine = InnoDB;
	 * Engine = InnoDB para aceitar a transação!
	 */

	public static void main(String[] args) throws SQLException {
		//mysql -u root -p 'loja_virtual'
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criaConexao();


		System.out.println("Fechando conexão!");
		connection.close();
	}

}
