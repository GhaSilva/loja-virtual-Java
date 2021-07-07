import java.sql.Connection;
import java.sql.SQLException;
import br.com.ghabriel.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// M�todo que testa a conex�o
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			System.out.println("Fechando conex�o!");
		}
	}
}
