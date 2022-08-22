package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		/*
		 * String nome = "Adrieu Oliveira"; ObjectOutputStream oos = new
		 * ObjectOutputStream(new FileOutputStream("obj.bin")); oos.writeObject(nome);
		 * oos.close();
		 */
		
		/*
		 * ObjectInputStream ois = new ObjectInputStream(new
		 * FileInputStream("obj.bin")); String nome = (String) ois.readObject();
		 * ois.close(); System.out.print(nome);
		 */
		
		/*
		 * Cliente cliente = new Cliente(); cliente.setNome("Adíl");
		 * cliente.setCpf("0170829501"); cliente.setProfissao("Pedreiro");
		 * 
		 * ObjectOutputStream oos = new ObjectOutputStream(new
		 * FileOutputStream("cliente.bin")); oos.writeObject(cliente); oos.close();
		 */
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin")); 
		Cliente cliente = (Cliente) ois.readObject();
		ois.close(); 
		System.out.println(cliente.getNome());
		
		
		
		
	}

}
