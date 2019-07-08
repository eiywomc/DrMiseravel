package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.CategoriaVO;

public class CategoriaDAO {

	public boolean verificarRegistroPorDescricao(String descricao) {
		
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT descricao FROM categoria WHERE descricao = '" + descricao + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a existência de categoria por descricao");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return false;
	}

	public int cadastrarCategoriaDAO(CategoriaVO categoriaVO) {

		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO categoria (descricao) VALUES ('" 
		+ categoriaVO.getDescricao() + "')";
		
		try {
			resultado = stmt.executeUpdate(query); // se deu certo vai retornar 1 (vai para o CategoriaBO)
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de cadastro do categoria.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		
		return resultado;
	}

	public boolean verificarRegistroPorIdCategoria(int idCategoria) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idCategoria FROM categoria WHERE idCategoria = " + idCategoria;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a existência de categoria por id");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return false;
	}

	public int excluirCategoriaDAO(CategoriaVO categoriaVO) {

		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM categoria WHERE descricao = '" + categoriaVO.getDescricao()+ "'"; 
		
		
		try {
			resultado = stmt.executeUpdate(query); // se deu certo vai retornar 1 (vai para o CategoriaBO)
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de exclusao do categoria.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		
		return resultado;
	}

	public int atualizarCategoriaDAO(CategoriaVO categoriaVO) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE categoria SET "
				+ "descricao = '" + categoriaVO.getDescricao() + "'";
		
		try {
			resultado = stmt.executeUpdate(query); // se deu certo vai retornar 1 (vai para o CategoriaBO)
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de atualização do categoria.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		
		return resultado;
	}

	public ArrayList<CategoriaVO> consultarTodosCategoriasDAO() {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<CategoriaVO> categoriasVO = new ArrayList<CategoriaVO>();
		String query = "SELECT idcategoria, descricao  FROM categoria";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				CategoriaVO categoriaVO = new CategoriaVO();
				categoriaVO.setIdCategoria(resultado.getInt(1));
				categoriaVO.setDescricao(resultado.getString(2));
				categoriasVO.add(categoriaVO);
			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de categorias.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return categoriasVO;
	}

	public CategoriaVO consultarCategoriaDAO(CategoriaVO categoriaVO) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		CategoriaVO categoria = new CategoriaVO();
		String query = "SELECT idcategoria, descricao  FROM categoria "
						+ "WHERE idcategoria = " + categoriaVO.getIdCategoria();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				categoria.setIdCategoria(resultado.getInt(1));
				categoria.setDescricao(resultado.getString(2));

			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de categoria.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return categoria;
	}

}
