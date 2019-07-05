package model.bo;


import java.util.ArrayList;

import model.dao.ReceitaDAO;

import model.vo.ReceitaVO;
import model.vo.UsuarioVO;

public class ReceitaBO {

	public static void cadastrarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		int resultado = receitaDAO.cadastrarReceitaDAO(receitaVO);
		if (resultado == 1) {
			System.out.println("\nReceita cadastrada com sucesso.");
		} else {
			System.out.println("\nNão foi possível cadastrar a Receita.");
		}
		
	}

	public static void atualizarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		if (receitaDAO.verificarRegistroPorIdReceita(receitaVO.getId())) {
			int resultado = receitaDAO.atualizarReceitaDAO(receitaVO);
			if (resultado == 1) {
				System.out.println("\nReceita atualizada com sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar a Receita.");
			}
		} else {
			System.out.println("\nReceita ainda não foi cadastrada.");
		}

		
	}

	public void excluirReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		if (receitaDAO.verificarRegistroPorIdReceita(receitaVO.getId())) {
			int resultado = receitaDAO.excluirReceitaDAO(receitaVO);
			if (resultado == 1) {
				System.out.println("\nReceita excluída com sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir a Receita.");
			}
		} else {
			System.out.println("\nReceita não existe na base de dados.");
		}

	}

	public ArrayList<ReceitaVO> consultarUmUsuario(UsuarioVO usuarioVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ArrayList<ReceitaVO> receitasVO = receitaDAO.consultarPorUsuario(usuarioVO);
		if (receitasVO.isEmpty()) {
			System.out.println("\nLista de Receitas está vazia.");
		} 
		return receitasVO;
	}

	public ReceitaVO consultarUmaDespesa(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ReceitaVO receita = receitaDAO.consultarPorDespesa(receitaVO);
		if (receita == null) {
			System.out.println("\nReceita não localizada.");
		} 
		return receita;
	}

}
