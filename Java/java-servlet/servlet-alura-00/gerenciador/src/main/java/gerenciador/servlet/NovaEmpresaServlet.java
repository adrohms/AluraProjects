package gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataCadastro = request.getParameter("dataCadastro");
	
		
		
		Date dataCadastroData = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			dataCadastroData = sdf.parse(dataCadastro);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataCadastro(dataCadastroData);
		
		Database database = new Database();
		database.adiciona(empresa);
		
	
		//request.setAttribute("novaEmpresa", empresa.getNome());
		//Devolver uma nova resposta para o navegador informando o novo redirecionamento
		response.sendRedirect("listarEmpresas");
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listarEmpresas");

//		rd.forward(request, response);
	}

}
