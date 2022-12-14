package gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveEmpresa
 */
@WebServlet("/removeEmpresa")
public class RemoveEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);
		
		Database database = new Database();
		database.removeEmpresa(id);
		System.out.println("Empresa removida com sucesso!");
		
		response.sendRedirect("listarEmpresas");
	}

}
