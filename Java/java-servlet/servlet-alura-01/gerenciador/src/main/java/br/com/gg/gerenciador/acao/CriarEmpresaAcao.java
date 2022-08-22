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


public class CriarEmpresaAcao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataCadastro = request.getParameter("dataCadastro");
	
		
		
		Date dataCadastroData = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			dataCadastroData = sdf.parse(dataCadastro);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataCadastro(dataCadastroData);
		
		Database database = new Database();
		database.adiciona(empresa);

		return "redirect:theOneServlet?acao=ListarEmpresasAcao";
	}

}
