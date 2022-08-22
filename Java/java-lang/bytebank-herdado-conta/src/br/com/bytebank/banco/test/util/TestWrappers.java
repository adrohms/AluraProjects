package br.com.bytebank.banco.test.util;

public class TestWrappers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] idades = new int[5];
		String[] nomes = new String[5];
		
		String idade = "29";
		Integer idadeValueOf = Integer.valueOf(idade); //autoboxing: primitive -> object
		Integer idadeParseInt = Integer.parseInt(idade);
		
		System.out.println("parseInt = valueOf? " + (idadeValueOf == idadeParseInt));
		System.out.println(idadeValueOf);
		int valor = idadeValueOf.intValue(); //unboxing: object -> primitive
		
		int numero = Integer.parseInt(args[0]);
		System.out.println(numero);
		
		System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE + " " + Integer.BYTES);
		
	}

}
