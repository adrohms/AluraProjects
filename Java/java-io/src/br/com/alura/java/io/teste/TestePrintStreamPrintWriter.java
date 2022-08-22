package br.com.alura.java.io.teste;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@SuppressWarnings("unused")
public class TestePrintStreamPrintWriter {

	public static void main(String[] args) throws IOException {
		// FileWriter, PrintWriter e PrintSteam

		//PrintStream ps = new PrintStream(new File("lorem2.txt")); Para caso queira informar o caminho para o arquivo...
		PrintStream ps = new PrintStream("lorem2.txt");
		//PrintWriter pw = new PrintWriter("lorem2.txt"); Funciona igual!
		
		
		ps.println("Teste com o PrintStream...");
		//pw.println("Teste com o PrintWriter...")
		
		//pw.close();
		ps.close();
	}

}
