import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		
		//Criando pool de conexões para evitar sobrecarga do banco de dados
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("200305Gh.");
		
		this.dataSource = comboPooledDataSource;
	}
	
	
	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
	}
	
}
