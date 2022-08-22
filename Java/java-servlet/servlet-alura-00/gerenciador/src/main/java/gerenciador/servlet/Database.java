package gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Database {
	

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static Integer idAuto = 1;
	static {
		Date hojeDate = new Date();
		Empresa alura = new Empresa();
		alura.setNome("Alura");
		alura.setId(idAuto++);
		
		Empresa geekground = new Empresa();
		geekground.setNome("GG77");
		geekground.setId(idAuto++);
		
		lista.add(geekground);
		lista.add(alura);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(idAuto++);
		Database.lista.add(empresa);
	}
	
	
	public List<Empresa> getEmpresas() {
		return Database.lista;
	}


	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}

	}
	
	public Empresa findOne(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
			return emp;
			}
		}
		return null;

	}

}
