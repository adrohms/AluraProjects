
public class Conexao implements AutoCloseable{
	public Conexao() {
		System.out.println("Abrindo conexao...");
		throw new IllegalStateException();
	}
	
	public void leDados() {
		System.out.println("Recebendo dados");
		throw new IllegalStateException();
	}
	
	public void fecha() {
		System.out.println("Conexao fechada");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Conexao fechada");
	}
}
