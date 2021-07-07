import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.ghabriel.factory.ConnectionFactory;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		// Puxando a conexão via encapsulamento
		try (Connection connection = connectionFactory.recuperarConexao()) {

			// criando um PreparedStatement
			try (PreparedStatement stm = connection.prepareStatement("select * from produto")) {

				stm.execute();

				// Com esse método é possivel pegar o conteudo do SQL
				try (ResultSet rst = stm.getResultSet()) {

					// Laço usado pra imprimir o conteudo da lista no banco de dados
					while (rst.next()) {
						Integer id = rst.getInt(1);
						System.out.println(id);
						String nome = rst.getString(2);
						System.out.println(nome);
						String descricao = rst.getString(3);
						System.out.println(descricao);
					}
				}
			}
		}
	}
}
