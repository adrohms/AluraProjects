package br.com.alura.java.io.teste;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraCSV {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("contas.csv"));
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			//System.out.println(line);
			
			Scanner lineScan = new Scanner(line);
			lineScan.useLocale(Locale.US);
			lineScan.useDelimiter(",");
			
			String tipo = lineScan.next();
			int agencia = lineScan.nextInt();
			int numero = lineScan.nextInt();
			String titular = lineScan.next();
			double saldo = lineScan.nextDouble();
			
		
			System.out.format(Locale.US ,"%s - %03d - %04d - %s - %.2f %n", tipo, agencia, numero, titular, saldo);
			
			//String[] values =  line.split(",");
			//System.out.println(Arrays.toString(values));
			//System.out.println(values[3]);
			
			lineScan.close();
		}

		
		scanner.close();
	}	

}
