package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TestArrayReferencias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContaCorrente[] contas = new ContaCorrente[5];
	 
		ContaCorrente cc2 = new ContaCorrente(12,666);
		ContaCorrente cc3 = new ContaCorrente(12,666);
		ContaCorrente cc4 = new ContaCorrente(12,666);
		ContaCorrente cc5 = new ContaCorrente(12,666);
		
		contas[0] = new ContaCorrente(12,666);
		contas[1] = cc2;
		contas[2] = cc3;
		contas[3] = cc4;
		contas[4] = cc5;
		
		double valor = 3.56;
		int numero = (int) valor; //cast explicito é exigido pelo compilador
		
		Conta conta = (Conta) contas[0]; //cast implicito
	
		System.out.println(conta.getNumero());
	}

}
