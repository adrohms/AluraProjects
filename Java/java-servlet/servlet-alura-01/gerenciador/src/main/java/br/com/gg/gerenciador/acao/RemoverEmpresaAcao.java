package br.com.gg.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gg.gerenciador.modelo.Acao;
import br.com.gg.gerenciador.modelo.Database;


public class RemoverEmpresaAcao implements Acao {
       

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);
		
		Database database = new Database();
		database.removeEmpresa(id);
		System.out.println("Empresa removida com sucesso!");
		
		return "redirect:theOneServlet?acao=ListarEmpresasAcao";
	}

}
