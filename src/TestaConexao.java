import java.sql.Connection;
import java.sql.SQLException;
import br.com.ghabriel.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// Método que testa a conexão
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			System.out.println("Fechando conexão!");
		}
	}
}
