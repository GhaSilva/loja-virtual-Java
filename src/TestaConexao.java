import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		//M�todo que testa a conex�o
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "200305Gh.");
		
		System.out.println("Fechando conex�o!");
		connection.close();
	}

}
