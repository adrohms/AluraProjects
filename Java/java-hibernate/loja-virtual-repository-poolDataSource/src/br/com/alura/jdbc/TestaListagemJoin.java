package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;


public class TestaListagemJoin {

	/*
	 * CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL,
	 * descricao VARCHAR(255), PRIMARY KEY (id)) Engine = InnoDB;
	 * Engine = InnoDB para aceitar a transação!
	 */

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//mysql -u root -p 'loja_virtual'
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.criaConexao()){

			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			Produto produto = new Produto("Geladeira", "Eletrolux", 2);
			produtoDAO.salvar(produto);
			List<Produto> listaProduto = produtoDAO.listarProdutoCategoria();
			listaProduto.stream().forEach(item -> System.out.println(item));
			
			float x = 10;
			float y = (float) 20.4;
			System.out.println("Vai dar " + (x+y));
			/*
			 * CategoriaDAO categoriaDAO = new CategoriaDAO(connection); List<Categoria>
			 * listaCategoria = categoriaDAO.listar(); listaCategoria.stream().forEach(item
			 * -> System.out.println(item));
			 */
		}
		
	}

}
