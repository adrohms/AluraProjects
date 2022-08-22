package gerenciador.servlet;

import java.io.IOException;
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
 * Servlet implementation class AtualizarEmpresa
 */
@WebServlet("/atualizarEmpresa")
public class AtualizarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String dataCadastro = request.getParameter("dataCadastro");
		
		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);
		
		Date dataCadastroData = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			dataCadastroData = sdf.parse(dataCadastro);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Database database = new Database();
		Empresa findEmpresa = database.findOne(id);
		
		findEmpresa.setDataCadastro(dataCadastroData);
		findEmpresa.setNome(nomeEmpresa);
		
		System.out.println("Empresa editada com sucesso!");
		
		response.sendRedirect("listarEmpresas");
	}


}
