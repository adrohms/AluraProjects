package br.com.gg.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {
	

	private static List<Empresa> listaEmpresa = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuario = new ArrayList<Usuario>();
	private static Integer idAuto = 1;
	private static Integer idAutoUser = 1;
	static {

		Empresa alura = new Empresa();
		alura.setNome("Alura");
		alura.setId(idAuto++);
		
		Empresa geekground = new Empresa();
		geekground.setNome("GG77");
		geekground.setId(idAuto++);
		
		listaEmpresa.add(geekground);
		listaEmpresa.add(alura);
		
		Usuario adriel = new Usuario();
		adriel.setLogin("Adriel");
		adriel.setSenha("123");
		adriel.setId(idAutoUser++);
		listaUsuario.add(adriel);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(idAuto++);
		Database.listaEmpresa.add(empresa);
	}
	
	
	public List<Empresa> getEmpresas() {
		return Database.listaEmpresa;
	}


	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = listaEmpresa.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}

	}
	
	public Empresa findOne(Integer id) {
		Iterator<Empresa> it = listaEmpresa.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
			return emp;
			}
		}
		return null;
	}
	
	public void adicionaUsuario(Usuario user) {
		user.setId(idAuto++);
		Database.listaUsuario.add(user);
	}
	
	
	public List<Usuario> getUsuarios() {
		return Database.listaUsuario;
	}


	public void removeUsuario(Integer id) {
		Iterator<Usuario> it = listaUsuario.iterator();
		
		while(it.hasNext()) {
			Usuario user = it.next();
			if(user.getId() == id) {
				it.remove();
			}
		}
	}
	
	public Usuario findOneUser(String login, String senha) {
		Iterator<Usuario> it = listaUsuario.iterator();
		
		while(it.hasNext()) {
			Usuario user = it.next();
			if(user.getLogin().equals(login) && user.getSenha().equals(senha)) {
			return user;
			}
		}
		return null;
	}
	
	

}
