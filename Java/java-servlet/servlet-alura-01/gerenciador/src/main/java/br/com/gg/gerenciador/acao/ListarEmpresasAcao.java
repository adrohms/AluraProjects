package br.com.gg.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gg.gerenciador.modelo.Acao;
import br.com.gg.gerenciador.modelo.Database;
import br.com.gg.gerenciador.modelo.Empresa;

public class ListarEmpresasAcao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Database database = new Database();
		
		List<Empresa> lista = database.getEmpresas();
		
		request.setAttribute("empresas", lista);
		return "foward:listarEmpresas.jsp";
				
	}


}
