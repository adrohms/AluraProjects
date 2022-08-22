package br.com.gg.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gg.gerenciador.modelo.Acao;
import br.com.gg.gerenciador.modelo.Database;
import br.com.gg.gerenciador.modelo.Empresa;


public class AtualizarEmpresaAcao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		return "redirect:theOneServlet?acao=ListarEmpresasAcao";
	}


}
