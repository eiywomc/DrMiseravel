package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.dto.LancamentoUsuarioDTO;
import model.dto.SaldoUsuarioDTO;



public class RelatorioDAO {
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuarioDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = new ArrayList<LancamentoUsuarioDTO>();
		String query = "SELECT u.idusuario as ID, u.nome as USUARIO, sum(r.valor) as RECEITAS " 
				+ " FROM usuario u, receita r " 
				+ " WHERE u.idusuario = r.idusuario " 
				+ " GROUP BY u.idusuario ";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				LancamentoUsuarioDTO lancamentoUsuario = new LancamentoUsuarioDTO();
				lancamentoUsuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				lancamentoUsuario.setNome(resultado.getString(2));
				lancamentoUsuario.setValor(Double.parseDouble(resultado.getString(3)));
				listaLancamentoUsuarioDTO.add(lancamentoUsuario);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query do Relatório Total de Receitas dos Usuários.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaLancamentoUsuarioDTO;
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuarioDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = new ArrayList<LancamentoUsuarioDTO>();
		String query = "SELECT u.idusuario as ID, u.nome as USUARIO, sum(d.valor) as DESPESAS " 
				+ " FROM usuario u, despesa d " 
				+ " WHERE u.idusuario = d.idusuario " 
				+ " GROUP BY u.idusuario ";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				LancamentoUsuarioDTO lancamentoUsuario = new LancamentoUsuarioDTO();
				lancamentoUsuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				lancamentoUsuario.setNome(resultado.getString(2));
				lancamentoUsuario.setValor(Double.parseDouble(resultado.getString(3)));
				listaLancamentoUsuarioDTO.add(lancamentoUsuario);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query do Relatório Total de Despesas dos Usuários.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaLancamentoUsuarioDTO;
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuariosPorPeriodoDAO(LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = new ArrayList<LancamentoUsuarioDTO>();
		String query = "SELECT u.idusuario as ID, u.nome as USUARIO, sum(r.valor) as RECEITAS " 
				+ " FROM usuario u, receita r " 
				+ " WHERE u.idusuario = r.idusuario " 
				+ " and r.datareceita >= '" + lancamentoUsuarioDTO.getDataInicioPesquisa() + "' "
				+ " and r.datareceita <= '" + lancamentoUsuarioDTO.getDataFimPesquisa() + "' "
				+ " GROUP BY u.idusuario ";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				LancamentoUsuarioDTO lancamentoUsuario = new LancamentoUsuarioDTO();
				lancamentoUsuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				lancamentoUsuario.setNome(resultado.getString(2));
				lancamentoUsuario.setValor(Double.parseDouble(resultado.getString(3)));
				listaLancamentoUsuarioDTO.add(lancamentoUsuario);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query do Relatório Total de Receitas dos Usuários por Período.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaLancamentoUsuarioDTO;
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuariosPorPeriodoDAO(LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = new ArrayList<LancamentoUsuarioDTO>();
		String query = "SELECT u.idusuario as ID, u.nome as USUARIO, sum(d.valor) as DESPESAS " 
				+ " FROM usuario u, despesa d " 
				+ " WHERE u.idusuario = d.idusuario " 
				+ " and d.datavencimento >= '" + lancamentoUsuarioDTO.getDataInicioPesquisa().format(formataDate) + "' "
				+ " and d.datavencimento <= '" + lancamentoUsuarioDTO.getDataFimPesquisa().format(formataDate) + "' "
				+ " GROUP BY u.idusuario ";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				LancamentoUsuarioDTO lancamentoUsuario = new LancamentoUsuarioDTO();
				lancamentoUsuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				lancamentoUsuario.setNome(resultado.getString(2));
				lancamentoUsuario.setValor(Double.parseDouble(resultado.getString(3)));
				listaLancamentoUsuarioDTO.add(lancamentoUsuario);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query do Relatório Total de Despesas dos Usuários.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaLancamentoUsuarioDTO;
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuariosAbertasPorPeriodoDAO(LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = new ArrayList<LancamentoUsuarioDTO>();
		String query = "SELECT u.idusuario as ID, u.nome as USUARIO, sum(d.valor) as DESPESAS " 
				+ " FROM usuario u, despesa d " 
				+ " WHERE u.idusuario = d.idusuario " 
				+ " and d.datavencimento >= '" + lancamentoUsuarioDTO.getDataInicioPesquisa() + "' "
				+ " and d.datavencimento <= '" + lancamentoUsuarioDTO.getDataFimPesquisa() + "' "
				+ " GROUP BY u.idusuario ";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				LancamentoUsuarioDTO lancamentoUsuario = new LancamentoUsuarioDTO();
				lancamentoUsuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				lancamentoUsuario.setNome(resultado.getString(2));
				lancamentoUsuario.setValor(Double.parseDouble(resultado.getString(3)));
				listaLancamentoUsuarioDTO.add(lancamentoUsuario);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query do Relatório Total de Despesas dos Usuários.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaLancamentoUsuarioDTO;
	}

	public ArrayList<SaldoUsuarioDTO> gerarRelatorioSaldoDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<SaldoUsuarioDTO> listaSaldoDTO = new ArrayList<SaldoUsuarioDTO>();
		String query = "SELECT A.IDUSUARIO, A.NOME, A.RECEITA, B.DESPESA, (A.RECEITA-B.DESPESA) AS SALDO " + 
				"FROM A " + 
				"INNER JOIN B ON " + 
				"A.IDUSUARIO = B.IDUSUARIO ";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				SaldoUsuarioDTO saldoUsuario = new SaldoUsuarioDTO();
				saldoUsuario.setId(Integer.parseInt(resultado.getString(1)));
				saldoUsuario.setNome(resultado.getString(2));
				saldoUsuario.setTotalDespesa(Double.parseDouble(resultado.getString(3)));
				saldoUsuario.setTotalReceita(Double.parseDouble(resultado.getString(4)));
				saldoUsuario.setTotalSaldo(Double.parseDouble(resultado.getString(5)));
				listaSaldoDTO.add(saldoUsuario);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query do Relatório Total de Despesas dos Usuários.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaSaldoDTO;
	}

}
