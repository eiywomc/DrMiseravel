package model.bo;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public void cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		if (usuarioDAO.verificarRegistroPorCPF(usuarioVO.getCpf())) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erro - Dr. Muquirana");
			alert.setHeaderText("Erro ao cadastrar usuário.");
			alert.setContentText("Usuário já cadastrado no sistema.");

			alert.showAndWait();
		} else {
			int resultado = usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Dr. Muquirana");
				alert.setHeaderText("Sucesso ao cadastrar usuário.");
				alert.setContentText("Operação bem sucedida.");		
				alert.showAndWait();
			} else {
				System.out.println("\nNão foi possível cadastrar o usuário.");
			}
		}

	}

	public void excluirUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = usuarioDAO.excluirUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Dr. Muquirana");
				alert.setHeaderText("Sucesso ao excluir usuário.");
				alert.setContentText("Operação bem sucedida.");		
				alert.showAndWait();
			} else {
				System.out.println("\nNão foi possível excluir o usuário.");
			}
		} else {
			System.out.println("\nUsuário não existe na base de dados.");
		}

	}

	public void atualizarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = usuarioDAO.atualizarUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Dr. Muquirana");
				alert.setHeaderText("Sucesso ao atualizar usuário.");
				alert.setContentText("Operação bem sucedida.");		
				alert.showAndWait();
			} else {
				System.out.println("\nNão foi possível atualizar o usuário.");
			}
		} else {
			System.out.println("\nUsuário ainda não foi cadastrado.");
		}

	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosBO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> usuariosVO = usuarioDAO.consultarTodosUsuariosDAO();
		if (usuariosVO.isEmpty()) {
			System.out.println("\nLista de Usuários está vazia.");
		} 
		return usuariosVO;
	}

	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarUsuarioDAO(usuarioVO);
		if (usuarioVO == null) {
			System.out.println("\nUsuário não localizado.");
		} 
		return usuario;
	}

	public ArrayList<UsuarioVO> consultarNomesUsuariosBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> usuariosVO = usuarioDAO.consultarNomeUsuariosDAO(usuarioVO);
		if (usuariosVO.isEmpty()) {
			System.out.println("\nLista de Usuários com esse nome está vazia.");
		} 
		return usuariosVO;
	}


	
}
