package br.com.gg.cliente;

import java.io.IOException;

import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String content = Request.Post("http://localhost:8080/gerenciador/empresas")
				.addHeader("Accept", "application/json")
				.execute()
				.returnContent().asString();
		
		System.out.println(content);

	}

}
