import java.sql.Connection;
import br.com.ghabriel.factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			try (PreparedStatement stm = connection.prepareStatement("delete from produto where id = ?")) {
				stm.setInt(1, 1);
				stm.execute();

				int linhasModificadas = stm.getUpdateCount();

				System.out.println(linhasModificadas + " linhas foram modificadas");

			}
		}
	}
}
