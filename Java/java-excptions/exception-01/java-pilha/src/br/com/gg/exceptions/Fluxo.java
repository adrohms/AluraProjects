package br.com.gg.exceptions;

public class Fluxo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ini main");
		try {
			metodo1();
		} catch (ArithmeticException | NullPointerException ex) {
			String msg = ex.getMessage();
			ex.printStackTrace();
			System.out.println("exception " + msg);
		}
		System.out.println("Fim main");
	}

	private static void metodo1() {
		System.out.println("Ini met1");
		metodo2();
		System.out.println("Fim met1");
	}

	private static void metodo2() {
		System.out.println("Ini met2");
		for(int i =1; i<=3; i++) {
			System.out.println(i);
			int a = i/0; // Só o metodo main sabe ldiar com a exceção
			Conta teste = null;
			teste.nullMetodo();
		}
		System.out.println("Fim met2");

	}

}
