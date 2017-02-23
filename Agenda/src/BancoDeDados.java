import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	//Realizar conexão com o banco de dados;
	public void conectar(){
		String servidor = "jdbc:mysql://localhost:3306/agenda";
		String usuario = "root";
		String senha = "37738789";
		String driver = "com.mysql.jdbc.Driver";
	// tratamento de exceção;	
	try {
		Class.forName(driver);
		this.connection = DriverManager.getConnection(servidor,usuario,senha);
		this.statement = this.connection.createStatement();
		}catch (Exception e){
			System.out.println("Erro "  + e.getMessage());
		}
	}

	//verificação de conexão bem  sucedida;
	public boolean estaConectado(){
		if(this.connection != null){
			return true;
		}else {
			return false;
		}
	}
	
	//listar contatos no banco de dados;
	public void listarContatos(){
		// tratamento de exceção;
		try{
			String query = "SELECT * FROM  contato ORDER BY nome";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				System.out.println("ID " + this.resultset.getString("id") +" -Nome: " + this.resultset.getString("nome")+ "-Telefone " + this.resultset.getString("telefone"));
			}
		}catch (Exception e){
				System.out.println("Erro " + e.getMessage() );
			}
		}
	
	//editar contatos no bando de dados
	public void editarContatos(String id, String nome, String telefone){
		// tratamento de exceção;
		try { 
			String query = "UPDATE contato SET nome = '" + nome + "' , telefone = '" + telefone + "' WHERE id = " + id +" ; ";
			System.out.println(query);
			this.statement.executeUpdate(query);
			}catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	
	//inserir contatos no banco de dados
	public void inserirContato(String nome ,String telefone){
		// tratamento de exceção;
		try{
			String query = "INSERT INTO contato (nome , telefone) VALUES ('" + nome+ " ' , '" + telefone + "');";
			this.statement.executeUpdate(query);
		}catch (Exception e){
			System.out.println("Erro:" + e.getMessage());
			}
		}
	
	//apagar contatos
	public void apagarContato(String id){
		//tratamento de exceção
		try{
			String query = " DELETE FROM contato WHERE id = " +id+";";
			this.statement.executeUpdate(query);		
		}catch (Exception e){
			System.out.println("Erro:" + e.getMessage());
		}
	}
	
	//desconectar banco de dados
	public void desconectar(){
		//tratamento de exceção
		try{
			this.connection.close();
		}catch (Exception e){
			System.out.println("Erro:" + e.getMessage());
		}
	}
}











