import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("delete from produto where id > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		int linhasModificadas = stm.getUpdateCount();
		
		System.out.println(linhasModificadas + " linhas foram modificadas");
		
		connection.close();
	}
}
