package br.com.gg.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gg.gerenciador.modelo.Acao;

public class ChamarCriacaoEmpresaAcao implements Acao {
	

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		return "foward:formCriarEmpresa.jsp";
	}


}
