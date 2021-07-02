import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		
		stm.execute("delete from produto where id > 2");
		
		int linhasModificadas = stm.getUpdateCount();
		
		System.out.println(linhasModificadas + " linhas foram modificadas");
		
		
		connection.close();
	}
}
