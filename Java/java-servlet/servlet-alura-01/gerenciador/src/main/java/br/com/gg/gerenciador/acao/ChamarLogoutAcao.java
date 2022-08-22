package br.com.gg.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gg.gerenciador.modelo.Acao;

public class ChamarLogoutAcao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		//session.removeAttribute("usuarioLogado");
		session.invalidate();
		
		return "redirect:theOneServlet?acao=ChamarLoginAcao";
	}

}
