import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {

		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("insert into produto(nome, descricao) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		adicionarVariavel("Mouse", "Mouse sem fio", stm);
		adicionarVariavel("SmartTV", "45 polegadas", stm);
		adicionarVariavel("R�dio", "R�dio de bateria", stm);
		
		
		connection.close();
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm)
			throws SQLException {
		//parametros que v�o substituir os "?"
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();
		
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
		
	}

}

