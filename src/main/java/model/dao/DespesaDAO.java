package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.DespesaVO;
import model.vo.UsuarioVO;
import java.time.LocalDate;
public class DespesaDAO {
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter formataDateFXML = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public int cadastrarDespesaDAO(DespesaVO despesaVO) {

		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0; // 
		String query = "INSERT INTO despesa (idusuario, descricao, valor, datavencimento, datapagamento, categoria)"
				+ " VALUES (" 
		+ despesaVO.getIdUsuario() + ", '" 
		+ despesaVO.getDescricao()+ "', " 
		+ despesaVO.getValor() + ", '" 
		+ despesaVO.getDataVencimento() + "', '"
		+ despesaVO.getDataPagamento() + "', '" 
		+ despesaVO.getCategoria() + "')";
		
		try {
			resultado = stmt.executeUpdate(query); // se deu certo vai retornar 1 (vai para o UsuarioBO)
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de cadastro da Despesa.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		
		return resultado;
	}

	public boolean verificarRegistroPorIdDespesa(int id) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idDespesa FROM despesa WHERE idDespesa = " + id;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a existência de Despesa por id");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return false;
	}

	public int atualizarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE despesa SET idUsuario ="
				+ despesaVO.getIdUsuario() + ", " 
				+ "descricao = '"+ despesaVO.getDescricao()+ "', " 
				+ "valor = "+ despesaVO.getValor() + ", " 
				+ "datavencimento = '" + despesaVO.getDataVencimento() + "', "
				+ "datapagamento = '" + despesaVO.getDataPagamento() + "', " 
				+ "categoria = '" + despesaVO.getCategoria() + "'"
				+ "WHERE idDespesa ="
				+ despesaVO.getId();
				
		
		try {
			resultado = stmt.executeUpdate(query); // se deu certo vai retornar 1 (vai para o UsuarioBO)
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de atualização da despesa.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		
		return resultado;
	}

	public int excluirDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM despesa WHERE idDespesa = " + despesaVO.getId(); 
		
		
		try {
			resultado = stmt.executeUpdate(query); // se deu certo vai retornar 1 (vai para o UsuarioBO)
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de exclusao da despesa.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		
		return resultado;
	}

	public ArrayList<DespesaVO> consultarPorUsuario(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<DespesaVO> despesasVO = new ArrayList<DespesaVO>();
		String query = "SELECT iddespesa, idusuario, descricao, valor, datavencimento, datapagamento, categoria  FROM despesa WHERE idusuario ="+usuarioVO.getIdUsuario() + " ORDER BY iddespesa";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				DespesaVO despesaVO = new DespesaVO();
				despesaVO.setId(resultado.getInt(1));
				despesaVO.setIdUsuario(resultado.getInt(2));
				despesaVO.setDescricao(resultado.getString(3));
				despesaVO.setValor(resultado.getDouble(4));
				despesaVO.setDataVencimento(LocalDate.parse(resultado.getString(5)));
				if (resultado.getString(6) != null) {
					despesaVO.setDataPagamento(LocalDate.parse(resultado.getString(6)));
				} 
				despesaVO.setCategoria(resultado.getString(7));
				despesasVO.add(despesaVO);
			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de Despesa por usuário.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return despesasVO;
	}

	public DespesaVO consultarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		DespesaVO despesa = new DespesaVO();
		String query = "SELECT iddespesa,"
				+ " idusuario,"
				+ " descricao,"
				+ " valor,"
				+ " datavencimento,"
				+ " datapagamento, "
				+ "categoria  FROM despesa WHERE iddespesa ="+despesaVO.getId();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
	
				despesa.setId(resultado.getInt(1));
				despesa.setIdUsuario(resultado.getInt(2));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(resultado.getDouble(4));
				despesa.setDataVencimento(LocalDate.parse(resultado.getString(5), formataDateFXML));
				if (resultado.getString(6) != null) {
					despesa.setDataPagamento(LocalDate.parse(resultado.getString(6), formataDateFXML)); //corrigido.
				} 
				despesaVO.setCategoria(resultado.getString(7));
				despesa.setCategoria(resultado.getString(7));
			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de Despesa por usuário.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return despesa;
	}

}
