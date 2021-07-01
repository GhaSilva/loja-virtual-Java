import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		//Método que testa a conexão
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "200305Gh.");
		
		System.out.println("Fechando conexão!");
		connection.close();
	}

}
