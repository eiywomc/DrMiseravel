package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

import model.vo.DespesaVO;
import model.vo.ReceitaVO;
import model.vo.UsuarioVO;

public class ReceitaDAO {
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	public int cadastrarReceitaDAO(ReceitaVO receitaVO) {

		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0; // 
		String query = "INSERT INTO receita (idusuario, descricao, valor, datareceita)"
				+ " VALUES (" 
		+ receitaVO.getIdUsuario() + ", '" 
		+ receitaVO.getDescricao()+ "', " 
		+ receitaVO.getValor() + ", '" 
		+ receitaVO.getDateReceita() + "')";
		
		try {
			resultado = stmt.executeUpdate(query); // se deu certo vai retornar 1 (vai para o UsuarioBO)
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de cadastro da Receita.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		
		return resultado;
	}

	public boolean verificarRegistroPorIdReceita(int id) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idReceita FROM receita WHERE idReceita = " + id;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a existência de Receita por id");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return false;
	}

	public int atualizarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE receita SET idUsuario = "
						+ receitaVO.getIdUsuario() + ","
						+ "descricao = '"+ receitaVO.getDescricao() + "',"
						+ "valor = " + receitaVO.getValor() + ","
						+ "datareceita = '" + receitaVO.getDateReceita() + "'"
						+ "WHERE idReceita = " + receitaVO.getId();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de atualização da Receita.");
			System.out.println("Erro: "+e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM receita WHERE idReceita = " + receitaVO.getId();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de atualização da Despesa.");
			System.out.println("Erro: "+e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
		
	}

	public ArrayList<ReceitaVO> consultarPorUsuario(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ReceitaVO> receitasVO = new ArrayList<ReceitaVO>();
		String query = "SELECT idreceita, idusuario, descricao, valor, datareceita  FROM receita WHERE idusuario ="+usuarioVO.getIdUsuario() + " ORDER BY idreceita";

		try {
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				ReceitaVO receitaVO = new ReceitaVO();
				receitaVO.setId(resultado.getInt(1));
				receitaVO.setIdUsuario(resultado.getInt(2));
				receitaVO.setDescricao(resultado.getString(3));
				receitaVO.setValor(resultado.getDouble(4));
				receitaVO.setDateReceita(LocalDate.parse(resultado.getString(5), formataDate));

				receitasVO.add(receitaVO);
			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de Receita por usuário.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return receitasVO;
	}

	public ReceitaVO consultarPorDespesa(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();		
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ReceitaVO receita = new ReceitaVO();
		String query = "SELECT idreceita, idusuario, descricao, valor, datareceita  FROM receita WHERE idreceita ="+receitaVO.getId();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next( )) {
				receita.setId(resultado.getInt(1));
				receita.setIdUsuario(resultado.getInt(2));
				receita.setDescricao(resultado.getString(3));
				receita.setValor(resultado.getDouble(4));
				receita.setDateReceita(LocalDate.parse(resultado.getString(5), formataDate));
			}
			
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de Receita.");
			System.out.println("Erro: " + e.getMessage());
			
		}	finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return receita;
	}

}
