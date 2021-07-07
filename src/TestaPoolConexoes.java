import java.sql.Connection;
import br.com.ghabriel.factory.ConnectionFactory;
import java.sql.SQLException;

public class TestaPoolConexoes {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		for (int i = 0; i < 20; i++) {
			Connection connection = connectionFactory.recuperarConexao();
			System.out.println("Conexão de numero " + i);
		}
	}
}
