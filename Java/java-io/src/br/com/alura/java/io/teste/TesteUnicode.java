package br.com.alura.java.io.teste;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicode {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String c = "CÃ";
		System.out.println(c.codePointAt(1));
		
		Charset charset = Charset.defaultCharset();
		System.out.println(charset.displayName());
		
		byte[] bytes = c.getBytes(StandardCharsets.UTF_8);
		
		String nC = new String(bytes, "UTF-8");
		System.out.println(bytes.length + " , US_ASCII");
		System.out.println(nC);
	}

}
