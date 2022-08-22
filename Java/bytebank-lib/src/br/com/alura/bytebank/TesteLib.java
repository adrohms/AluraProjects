package br.com.alura.bytebank;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteLib {
	Conta c = new ContaCorrente(123, 555);
	c.deposita(10000);
	
}
