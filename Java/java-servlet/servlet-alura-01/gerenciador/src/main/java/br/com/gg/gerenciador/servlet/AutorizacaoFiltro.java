package br.com.gg.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFiltro
 */
@WebFilter("/theOneServlet")
public class AutorizacaoFiltro extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession session = request.getSession();
		Boolean acaoNaoRequerLogin = paramAcao.equals("ChamarLoginAcao") || paramAcao.equals("LoginAcao");
		Boolean usuarioNaoLogado = (session.getAttribute("usuarioLogado") == null);
		if(!acaoNaoRequerLogin && usuarioNaoLogado) {
			response.sendRedirect("theOneServlet?acao=ChamarLoginAcao");
			return;
		} 
		
		chain.doFilter(request, response);
	}

}
