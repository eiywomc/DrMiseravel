package model.bo;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.dao.CategoriaDAO;
import model.vo.CategoriaVO;


public class CategoriaBO {

	public void cadastrarCategoriaBO(CategoriaVO categoriaVO) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		if (categoriaDAO.verificarRegistroPorDescricao(categoriaVO.getDescricao())) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erro - Dr. Miseravel");
			alert.setHeaderText("Erro ao cadastrar categoria.");
			alert.setContentText("Categoria já cadastrado no sistema.");

			alert.showAndWait();
		} else {
			int resultado = categoriaDAO.cadastrarCategoriaDAO(categoriaVO);
			if (resultado == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Dr. Muquirana");
				alert.setHeaderText("Sucesso ao cadastrar categoria.");
				alert.setContentText("Operação bem sucedida.");
				
				alert.showAndWait();
			} else {
				System.out.println("\nNão foi possível cadastrar a categoria.");
			}
		}

	}

	public void excluirCategoriaBO(CategoriaVO categoriaVO) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		if (categoriaDAO.verificarRegistroPorIdCategoria(categoriaVO.getIdCategoria())) {
			int resultado = categoriaDAO.excluirCategoriaDAO(categoriaVO);
			if (resultado == 1) {
				System.out.println("\nCategoria excluído com sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir a categoria.");
			}
		} else {
			System.out.println("\nCategoria não existe na base de dados.");
		}

	}

	public void atualizarCategoriaBO(CategoriaVO categoriaVO) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		if (categoriaDAO.verificarRegistroPorIdCategoria(categoriaVO.getIdCategoria())) {
			int resultado = categoriaDAO.atualizarCategoriaDAO(categoriaVO);
			if (resultado == 1) {
				System.out.println("\nCategoria atualizado com sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o categoria.");
			}
		} else {
			System.out.println("\nCategoria ainda não foi cadastrado.");
		}

	}

	public ArrayList<CategoriaVO> consultarTodosCategoriasBO() {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		ArrayList<CategoriaVO> categoriasVO = categoriaDAO.consultarTodosCategoriasDAO();
		if (categoriasVO.isEmpty()) {
			System.out.println("\nLista de Categorias está vazia.");
		} 
		return categoriasVO;
	}




}
