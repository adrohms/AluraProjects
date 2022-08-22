package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.GuardadorDeContas;

public class TestGuardadorReferencias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuardadorDeContas guardadorDeContas = new GuardadorDeContas();
		
		Conta cc = new ContaPoupanca(06, 1586);
		guardadorDeContas.setConta(cc);
		
		ContaCorrente cc2 = new ContaCorrente(07, 3739);
		guardadorDeContas.setConta(cc2);
		
		int tamanho = guardadorDeContas.getNumeroContas();
		System.out.println(tamanho);
		
		Conta ref = (ContaPoupanca) guardadorDeContas.getConta(0);
		Conta ref2 = (ContaCorrente) guardadorDeContas.getConta(1);
		
		System.out.println(ref.getNumero());
		System.out.println(ref2.getNumero());
		
	}

}
