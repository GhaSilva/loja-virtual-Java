package br.com.ghabriel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ghabriel.jdbc.modelo.Categoria;
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
	
	public List<Produto> listar() throws SQLException{
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "select * from produto";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getNString(2), rst.getString(3));
					
					produtos.add(produto);
				}
			}
			
		}
		return produtos;
	}
	public List<Produto>  buscar(Categoria ct) throws SQLException {
		System.out.println("Executando a query de buscar produto por categoria");
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "select * from produto where categoria_id = ?";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setInt(1, ct.getId());
			pstm.execute();
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getNString(2), rst.getString(3));
					
					produtos.add(produto);
				}
			}
			
		}
		return produtos;
	}
}
