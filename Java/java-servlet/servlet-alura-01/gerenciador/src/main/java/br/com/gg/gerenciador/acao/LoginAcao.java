package br.com.gg.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gg.gerenciador.modelo.Acao;
import br.com.gg.gerenciador.modelo.Database;
import br.com.gg.gerenciador.modelo.Usuario;

public class LoginAcao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		System.out.println("Usuario " + login + " logando!");
		
		Database database = new Database();
	
		Usuario usuarioLogado = database.findOneUser(login, senha);
		if(usuarioLogado != null) {
			System.out.println("Usuario " + login + " logado!");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuarioLogado);
			return "redirect:theOneServlet?acao=ListarEmpresasAcao";
		} else {
			System.out.println("Usuario " + login + " recusado!");
			return "redirect:theOneServlet?acao=ChamarLoginAcao";
		}
		
	}

}
