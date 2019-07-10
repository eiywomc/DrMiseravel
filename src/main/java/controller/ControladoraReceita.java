package controller;

import java.util.ArrayList;


import model.bo.ReceitaBO;

import model.vo.ReceitaVO;
import model.vo.UsuarioVO;

public class ControladoraReceita {

	public void cadastrarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO(); 
		receitaBO.cadastrarReceitaBO(receitaVO);
		
	}

	public void atualizarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO(); 
		ReceitaBO.atualizarReceitaBO(receitaVO);
		
		
	}

	public void excluirDespesaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO(); 
		receitaBO.excluirReceitaBO(receitaVO);
		
	}

	public ArrayList<ReceitaVO> consultarUmUsuarioController(UsuarioVO usuarioVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.consultarUmUsuario(usuarioVO);
	}

	public ReceitaVO consultarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.consultarUmaDespesa(receitaVO);
	}

}
