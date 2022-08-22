
public class TestaConexao {

	public static void main(String[] args) {
		
		try(Conexao conect = new Conexao()) { //Automaticamente cria o finally chamando o close()
			conect.leDados();
		} catch(Exception ex) {
			System.out.println("Erro de conexao");
		}
		
		
		
		
//		Conexao conect = null;
//		try {
//			conect = new Conexao();
//			conect.leDados();
//			
//			
//		} catch(IllegalStateException ex) {
//			System.out.println("Erro de conexao");
//
//		} finally {
//			System.out.println("Fechando conexao...");
//			if(conect != null) { //Se o erro ocorrer no construtor, teremos um nullpointerexception sem essa validação
//				conect.fecha(); //Uma conexao deve sempre ser fechada!
//			}
//			
//		}

	}

}
