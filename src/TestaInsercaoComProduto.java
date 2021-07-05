import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.ghabriel.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			String sql = "insert into produto(nome, descricao) values(?,?)";
			
			try(PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				
				psmt.setString(1, comoda.getNome());
				psmt.setString(2, comoda.getDescricao());
				
				psmt.execute();
				
				try(ResultSet rst = psmt.getGeneratedKeys()){
					while(rst.next()) {
						comoda.setId(rst.getInt(1));
					}			
				}		
			}
		}
		System.out.println(comoda);
	}
}