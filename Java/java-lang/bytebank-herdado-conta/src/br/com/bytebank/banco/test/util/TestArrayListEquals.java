package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TestArrayListEquals {

	public static void main(String[] args) {
		
		ArrayList<Conta> listaConta = new ArrayList<Conta>();
		ArrayList<String> listaString = new ArrayList<String>();

		Conta cc1 = new ContaPoupanca(13,257);
		Conta cc2 = new ContaPoupanca(14,779);
		String str1 = "String 01";
		
		listaConta.add(cc1);
		listaConta.add(cc2);
		listaString.add(str1);
		
		Conta cc3 = new ContaPoupanca(14,779);
		
		boolean existe = listaConta.contains(cc3);
		System.out.println("Existe? " + existe);
		
		System.out.println(cc2.equals(cc1));
		System.out.println(listaConta.get(0).getNumero());
		for(Conta oRef: listaConta) {
			System.out.println(oRef);
		}
		
		
		
	}

}
