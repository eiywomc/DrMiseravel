package model.bo;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.dao.DespesaDAO;
import model.vo.DespesaVO;
import model.vo.UsuarioVO;

public class DespesaBO {

	public void cadastrarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();

		int resultado = despesaDAO.cadastrarDespesaDAO(despesaVO);
		if (resultado == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Dr. Muquirana");
			alert.setHeaderText("Sucesso ao cadastrar despesa.");
			alert.setContentText("Operação bem sucedida.");		
			alert.showAndWait();
		} else {
			System.out.println("\nNão foi possível cadastrar a despesa.");
		}
	}

	public void atualizarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		if (despesaDAO.verificarRegistroPorIdDespesa(despesaVO.getId())) {
			int resultado = despesaDAO.atualizarDespesaDAO(despesaVO);
			if (resultado == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sucesso. Dr. Muquirana");
				alert.setHeaderText("Despesa atualizada.");
				alert.setContentText("Atualização bem sucedida.");

				alert.showAndWait();
			} else {
				System.out.println("\nNão foi possível atualizar a Despesa.");
			}
		} else {
			System.out.println("\nDespesa ainda não foi cadastrada.");
		}

	}

	public void excluirDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		if (despesaDAO.verificarRegistroPorIdDespesa(despesaVO.getId())) {
			int resultado = despesaDAO.excluirDespesaDAO(despesaVO);
			if (resultado == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sucesso. Dr. Muquirana");
				alert.setHeaderText("Despesa Excluída.");
				alert.setContentText("Exclusão bem sucedida.");

				alert.showAndWait();
			} else {
				System.out.println("\nNão foi possível excluir a Despesa.");
			}
		} else {
			System.out.println("\nDespesa não existe na base de dados.");
		}

		
	}

	public ArrayList<DespesaVO> consultarUmUsuario(UsuarioVO usuarioVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		ArrayList<DespesaVO> despesasVO = despesaDAO.consultarPorUsuario(usuarioVO);
		if (despesasVO.isEmpty()) {
			System.out.println("\nLista de Despesas está vazia.");
		} 
		return despesasVO;
	}

	public DespesaVO consultarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		DespesaVO despesa = despesaDAO.consultarDespesaDAO(despesaVO);
		if (despesaVO == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erro. Dr. Muquirana");
			alert.setHeaderText("Despesa não existe.");
			alert.setContentText("Insira um código de despesa existente.");

			alert.showAndWait();
		} 
		return despesa;
	}
	

}
