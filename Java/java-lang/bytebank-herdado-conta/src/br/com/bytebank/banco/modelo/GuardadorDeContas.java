package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {
	
	private int posicao;
	private Object[] referencia;
	
	public GuardadorDeContas() {
		this.posicao = 0;
		this.referencia = new Object[10];
	}
	
	public void setConta(Object ref) {
		this.referencia[this.posicao] = ref;
		this.posicao++;
	}

	public int getNumeroContas() {
		return this.posicao;
	}
	
	public Object getConta(int pos) {
		return this.referencia[pos];
	}
 	
}
