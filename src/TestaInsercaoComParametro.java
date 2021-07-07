import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {

		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.recuperarConexao()){
				
			
			
			//removendo responsabilidade do jdbc para que haja um processo mais seletivo
			connection.setAutoCommit(false);
				//Colocando PreparedStatement nos parametros do try, para que não seja necessario o uso do close
			try(PreparedStatement stm = connection.prepareStatement("insert into produto(nome, descricao) values(?, ?)", Statement.RETURN_GENERATED_KEYS)) {
		
			
//			adicionarVariavel("Mouse", "Mouse sem fio", stm);
//			adicionarVariavel("SmartTV", "45 polegadas", stm);
			adicionarVariavel("Rádio", "Rádio de bateria", stm);
			//adicionarVariavel("Playstation", "Playstation 4", stm);
			
			//Caso não haja nenhum erro na adição dos produtos, eles serão adicionados graças aos produtos
			connection.commit();
			
			
			//Caso o try não funcione, a transação irá retornar graças ao rollback
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm)
			throws SQLException {
		
		//parametros que vão substituir os "?"
		stm.setString(1, nome);
		stm.setString(2, descricao);

		
		stm.execute();
		
		
		try(ResultSet rst = stm.getGeneratedKeys()){
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O ID criado foi: " + id);
			}
		}
	}
}

