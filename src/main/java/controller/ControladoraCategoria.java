package controller;

import java.util.ArrayList;

import model.bo.CategoriaBO;
import model.vo.CategoriaVO;

public class ControladoraCategoria {

	public void cadastrarCategoriaController(CategoriaVO categoriaVO) {
		CategoriaBO categoriaBO = new CategoriaBO(); 
		categoriaBO.cadastrarCategoriaBO(categoriaVO);
		
		
		
	}

	public void excluirCategoriaController(CategoriaVO categoriaVO) {
		CategoriaBO categoriaBO = new CategoriaBO(); 
		categoriaBO.excluirCategoriaBO(categoriaVO);
		
		
	}

	public void atualizarCategoriaController(CategoriaVO categoriaVO) {
		CategoriaBO categoriaBO = new CategoriaBO();
		categoriaBO.atualizarCategoriaBO(categoriaVO);
		
	}

	public ArrayList<CategoriaVO> consultarTodosCategoriasController() {
		CategoriaBO categoriaBO = new CategoriaBO();
		return categoriaBO.consultarTodosCategoriasBO();
		
	}


	
}
