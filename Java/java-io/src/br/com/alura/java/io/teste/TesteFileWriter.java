package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteFileWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		FileWriter fw = new FileWriter("lorem2.txt");
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Testando escrita do baulho!");
		bw.write(System.lineSeparator());
		bw.write(System.lineSeparator());
		bw.newLine();
		bw.write("Prestou? Claro que sim!");
		
		
		
		bw.close();
	}

}
