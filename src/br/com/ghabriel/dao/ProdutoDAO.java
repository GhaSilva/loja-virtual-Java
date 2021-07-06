package br.com.ghabriel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ghabriel.jdbc.modelo.Produto;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
		
	}
	public void salvar(Produto produto) throws SQLException {
		String sql = "insert into produto(nome, descricao) values(?,?)";
		
		try(PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			psmt.setString(1, produto.getNome());
			psmt.setString(2, produto.getDescricao());
			
			psmt.execute();
			
			try(ResultSet rst = psmt.getGeneratedKeys()){
				while(rst.next()) {
					produto.setId(rst.getInt(1));
	
				}			
			}		
		}
		
	}
}
