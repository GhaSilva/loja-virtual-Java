import java.sql.Connection;
import br.com.ghabriel.factory.ConnectionFactory;
import java.sql.SQLException;
import java.util.List;

import br.com.ghabriel.dao.CategoriaDAO;
import br.com.ghabriel.dao.ProdutoDAO;
import br.com.ghabriel.jdbc.modelo.Categoria;
import br.com.ghabriel.jdbc.modelo.Produto;

public class TestaListagemDeCategorias {
	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategoria = categoriaDAO.listarComProdutos();
			listaDeCategoria.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}

			});
		}

	}
}
