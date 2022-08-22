package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList lista = new ArrayList();
		
		Conta cc = new ContaCorrente(22,123);
		lista.add(cc);
		
		Conta cc2 = new ContaPoupanca(11,457);
		lista.add(cc2);
		
		Conta cc3 = new ContaPoupanca(11,457);
		lista.add(cc3);
		
		System.out.println("Tamanho: " + lista.size());
		
		Conta ref = (Conta) lista.get(0);
		System.out.println(ref.getNumero());
		
		System.out.println("\n--------------------------------------");
		for(int i = 0; i < lista.size(); i++) {
			Object oRef = lista.get(i);
			System.out.println(oRef);
		}
		System.out.println("\n--------------------------------------");
		
		for(Object oRef: lista) {
			System.out.println(oRef);
		}
		
		System.out.println("\n---------Usando-Generics--------------");
		
		ArrayList<Conta> listaConta = new ArrayList<Conta>();
		ArrayList<String> listaString = new ArrayList<String>();
		
		Conta cc4 = new ContaPoupanca(13,257);
		Conta cc5 = new ContaPoupanca(14,779);
		String str1 = "String 01";
		
		listaConta.add(cc4);
		listaConta.add(cc5);
		listaString.add(str1);
		
		System.out.println(listaConta.get(0).getNumero());
		for(Conta oRef: listaConta) {
			System.out.println(oRef);
		}
		
		
		
	}

}
