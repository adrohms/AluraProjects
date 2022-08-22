package br.com.gg.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gg.gerenciador.modelo.Acao;

/**
 * Servlet implementation class TheOneServlet
 */
@WebServlet("/theOneServlet")
public class TheOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.gg.gerenciador.acao." + paramAcao.substring(0, 1).toUpperCase() + paramAcao.substring(1); 
		
		String path;
		
		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse); // Carrega a classe com o nome
			@SuppressWarnings("deprecation")
			Acao acao = (Acao) classe.newInstance(); // Instancia a classe
			path = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		

	
		/*
		 * if(paramAcao.equals("AtualizarEmpresaAcao")) { AtualizarEmpresaAcao
		 * atualizarEmpresaAcao = new AtualizarEmpresaAcao(); path =
		 * atualizarEmpresaAcao.executa(request, response);
		 * 
		 * } else if(paramAcao.equals("EditarEmpresaAcao")) { EditarEmpresaAcao
		 * editarEmpresaAcao = new EditarEmpresaAcao(); path =
		 * editarEmpresaAcao.executa(request, response);
		 * 
		 * } else if(paramAcao.equals("ListarEmpresasAcao")) { ListarEmpresasAcao
		 * listarEmpresasAcao = new ListarEmpresasAcao(); path =
		 * listarEmpresasAcao.executa(request, response);
		 * 
		 * } else if(paramAcao.equals("ChamarCriacaoEmpresaAcao")) {
		 * ChamarCriacaoEmpresaAcao chamarCriacaoEmpresaAcao = new
		 * ChamarCriacaoEmpresaAcao(); path = chamarCriacaoEmpresaAcao.executa(request,
		 * response);
		 * 
		 * } else if(paramAcao.equals("CriarEmpresaAcao")) { CriarEmpresaAcao
		 * criarEmpresaAcao = new CriarEmpresaAcao(); path =
		 * criarEmpresaAcao.executa(request, response);
		 * 
		 * } else if(paramAcao.equals("RemoverEmpresaAcao")) { RemoverEmpresaAcao
		 * removerEmpresaAcao = new RemoverEmpresaAcao(); path =
		 * removerEmpresaAcao.executa(request, response);
		 * 
		 * }
		 */
		
		String[] typePath = path.split(":");

		if(typePath[0].equals("foward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + typePath[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typePath[1]);
		}
		
	}


}
