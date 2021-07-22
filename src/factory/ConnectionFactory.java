package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	//Nome do usuario do mysql
	private static final String USERNAME = "root";
	
	//Senha do mysql
	private static final String PASSWORD = "";
	
	//Caminho do banco de dados: padrao : banco : porta : nome do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/trabalho";
	
	/*
	 * Conex�o com o banco de dados
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		//Faz com que a classe seja carregada pela JVM ( Comentado pois esta obsoleto)
		//Class.forName("com.mysql.jdbc.Driver");
		
		//Cria a conex�o com banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}


	public static void main(String[] args) throws Exception {
		//Recuperar uma conex�o com banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se a conex�o � nula
		if(con!=null) {
			System.out.println("Conex�o realizada com sucesso!");
		}
	}
}
