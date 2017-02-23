
public class Agenda {
	
	public static void main(String[] args){
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()){
		bancoDeDados.listarContatos();
		//bancoDeDados.inserirContato("Pablo", "1234-4567");
		//bancoDeDados.editarContatos("2", "Maria", "1234-1234");
		//bancoDeDados.apagarContato("2");
		bancoDeDados.desconectar();
		//System.out.println("Conexão Realizada com Sucesso!!");	
		}else {
			System.out.println("não foi realizada a conexão");
		}
	}
}
