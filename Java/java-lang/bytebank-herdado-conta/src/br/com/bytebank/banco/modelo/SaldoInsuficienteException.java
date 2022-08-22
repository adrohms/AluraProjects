package br.com.bytebank.banco.modelo;

public class SaldoInsuficienteException extends Exception{ //checked
	/**
	 * Comentario
	 * @author Adriel de Oliveira
	 * @param msg
	 */
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
}
