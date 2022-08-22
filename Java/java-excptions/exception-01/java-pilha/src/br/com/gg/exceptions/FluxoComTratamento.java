package br.com.gg.exceptions;

public class FluxoComTratamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ini main");
		try {
			metodo1();
		} catch (ArithmeticException | NullPointerException | MinhaExcecao ex) {
			String msg = ex.getMessage();
			ex.printStackTrace();
			System.out.println("exception " + msg);
		}
		System.out.println("Fim main");
	}

	private static void metodo1() throws MinhaExcecao{
		System.out.println("Ini met1");
		metodo2();
		System.out.println("Fim met1");
	}

	private static void metodo2() throws MinhaExcecao {
		System.out.println("Ini met2");
		throw new MinhaExcecao("fudeu");  //throw só funciona com exceções
		//System.out.println("Fim met2");

	}
	

}
