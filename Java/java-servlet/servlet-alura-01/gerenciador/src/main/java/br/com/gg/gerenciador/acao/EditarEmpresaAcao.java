package br.com.gg.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gg.gerenciador.modelo.Acao;
import br.com.gg.gerenciador.modelo.Database;
import br.com.gg.gerenciador.modelo.Empresa;

public class EditarEmpresaAcao implements Acao {

       
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);
		
		Database database = new Database();
		Empresa findEmpresa = database.findOne(id);
		
		System.out.println("Empresa editada com sucesso!");

		
		request.setAttribute("empresa", findEmpresa);
		return "foward:formEditarEmpresa.jsp";
	}


}
