import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		
		//M�todo que testa a conex�o
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "200305Gh.");
		
		//criando um Statement
		Statement stm = connection.createStatement();
		
		//Quando o comando SQL retornar uma lista o boleano ser� true, do contrario false
		boolean execute = stm.execute("select * from produto");
		
		//Com esse m�todo � possivel pegar o conteudo do SQL
		ResultSet rst = stm.getResultSet();
		
		//La�o usado pra imprimir o conteudo da lista no banco de dados
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println(id);
			String nome = rst.getString(2);
			System.out.println(nome);
			String descricao = rst.getString(3);
			System.out.println(descricao);
		}
		
		
		connection.close();
	}
}
