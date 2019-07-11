package view;

import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;
import model.vo.UsuarioVO;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import controller.ControladoraDespesa;
import controller.ControladoraReceita;
import controller.ControladoraUsuario;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import javafx.scene.text.Text;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class FXMLDespesaExcluirController {
	@FXML
	private Button btnUsuario;
	@FXML
	private Button btnReceita;
	@FXML
	private Button btnDespesa;
	@FXML
	private Button btnRelatorio;
	@FXML
	private Button brnSobre;
	@FXML
	private Button btnVoltar;
	@FXML
	private Button btnConsultarDespesa;
	@FXML
	private TextField txtCodigoDespesa;
	@FXML
	private Text lblCodDespesa;
	@FXML
	private Text lblNomeUsuario;
	@FXML
	private Text lblCodUsuario;
	@FXML
	private Text lblDescricao;
	@FXML
	private Text txtIdUsuario;
	@FXML
	private Text txtDescricao;
	@FXML
	private Text txtNomeUsuario;
	@FXML
	private Text lblDataVencimento;
	@FXML
	private Text txtDataVencimento;
	@FXML
	private Text lblValor;
	@FXML
	private Text txtValor;
	@FXML
	private Button btnExcluirDespesa;
	@FXML
	private Text lblIdUsuario;
	@FXML
	private Text lblCategoria;
	@FXML
	private Text txtCategoria;
	@FXML
	private Text lblDataPagamento;
	@FXML
	private Text txtDataPagamento;

	// Event Listener on Button[#btnUsuario].onAction
	@FXML
	public void loadUsuario(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLUsuario.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnReceita].onAction
	@FXML
	public void loadReceita(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLReceita.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnDespesa].onAction
	@FXML
	public void loadDespesa(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLDespesa.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnRelatorio].onAction
	@FXML
	public void loadRelatorio(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLRelatorio.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#brnSobre].onAction
	@FXML
	public void loadSobre(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLSobre.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnVoltar].onAction
	@FXML
	public void voltarReceita(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLReceita.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnConsultarDespesa].onAction
	@FXML
	public void consultarDespesaPorCodigo(ActionEvent event) {
		DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale ptBr = new Locale("pt", "BR");
		
		DespesaVO despesaVO = new DespesaVO();
		
		despesaVO.setId(Integer.parseInt(txtCodigoDespesa.getText())); 
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		DespesaVO idDespesa = controladoraDespesa.consultarDespesaCOntroller(despesaVO);
		
		UsuarioVO usuario = new UsuarioVO();
		
		usuario.setIdUsuario(idDespesa.getIdUsuario());
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		usuario = controladoraUsuario.consultarUsuarioCOntroller(usuario);
		
		txtIdUsuario.setText(Integer.toString(idDespesa.getIdUsuario()));
		txtNomeUsuario.setText(usuario.getNome());
		txtDescricao.setText(idDespesa.getDescricao());
		txtDescricao.setText(idDespesa.getCategoria());
		txtDataVencimento.setText(idDespesa.getDataVencimento().format(dataFormatter));
		txtDataPagamento.setText(idDespesa.getDataPagamento().format(dataFormatter));
		txtValor.setText(NumberFormat.getCurrencyInstance(ptBr).format(idDespesa.getValor()));

	}
	// Event Listener on Button[#btnExcluirDespesa].onAction
	@FXML
	public void excluirDespesaPorCodigo(ActionEvent event) {
		DespesaVO despesaVO = new DespesaVO();
		
		despesaVO.setId(Integer.parseInt(txtCodigoDespesa.getText()));
		
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.excluirDespesaController(despesaVO);
	}
}
/*		
		=======
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;
import model.vo.UsuarioVO;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import controller.ControladoraDespesa;
import controller.ControladoraReceita;
import controller.ControladoraUsuario;
import javafx.event.ActionEvent;

public class FXMLDespesaExcluirController {
	@FXML
	private Button btnUsuario;
	@FXML
	private Button btnReceita;
	@FXML
	private Button btnDespesa;
	@FXML
	private Button btnRelatorio;
	@FXML
	private Button brnSobre;
	@FXML
	private Button btnVoltar;
	@FXML
	private Button btnConsultarReceitaPorCod;
	@FXML
	private TextField cmbCodigo;
	@FXML
	private Text lblCodReceita;
	@FXML
	private Text lblNomeUsuario;
	@FXML
	private Text lblCodUsuario;
	@FXML
	private Text lblDescricao;
	@FXML
	private Text txtCodUsuario;
	@FXML
	private Text txtDescricao;
	@FXML
	private Text txtNomeUsuario;
	@FXML
	private Text lblData;
	@FXML
	private Text txtDataPag;
	@FXML
	private Text txtDataVencimento;
	@FXML
	private Text lblValor;
	@FXML
	private Text txtValor;
	@FXML
	private Button btnConsultarReceitaPorCod1;
	@FXML
	private Text lblNomeUsuario1;

	// Event Listener on Button[#btnUsuario].onAction
	@FXML
	public void loadUsuario(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLDespesaExcluirController.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnReceita].onAction
	@FXML
	public void loadReceita(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLExcluirController.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnDespesa].onAction
	@FXML
	public void loadDespesa(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLExcluirController.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnRelatorio].onAction
	@FXML
	public void loadRelatorio(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLExcluirController.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#brnSobre].onAction
	@FXML
	public void loadSobre(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnVoltar].onAction
	@FXML
	public void voltarReceita(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLExcluirController.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnConsultarReceitaPorCod].onAction
	@FXML
	public void consultarReceitaPorCodigo(ActionEvent event) {
		DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale ptBr = new Locale("pt", "BR");
		
		DespesaVO despesaVO = new DespesaVO();
		
		despesaVO.setId(Integer.parseInt(cmbCodigo.getText())); 
		ControladoraDespesa controladoraDespesaVO = new ControladoraDespesa();
		DespesaVO idDespesa = controladoraDespesaVO.consultarDespesaCOntroller(despesaVO);
		
		UsuarioVO usuario = new UsuarioVO();
		
		usuario.setIdUsuario(idDespesa.getIdUsuario());
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		usuario = controladoraUsuario.consultarUsuarioCOntroller(usuario);
		
		txtCodUsuario.setText(Integer.toString(idDespesa.getIdUsuario()));
		txtNomeUsuario.setText(usuario.getNome());
		txtDescricao.setText(idDespesa.getDescricao());
		//txtDataPagamento.setText(idDespesa.getDataPagamento());//format(dataFormatter));
		txtDataPag.setText(idDespesa.getDataPagamento().format(dataFormatter));
		txtDataVencimento.setText(idDespesa.getDataVencimento().toString());
		txtValor.setText(NumberFormat.getCurrencyInstance(ptBr).format(idDespesa.getValor()));
	}
	// Event Listener on Button[#btnConsultarReceitaPorCod1].onAction
	@FXML
	public void excluirDespesaPorCodigo(ActionEvent event) {
		ReceitaVO receitaVO = new ReceitaVO();
		
		receitaVO.setId(Integer.parseInt(cmbCodigo.getText()));
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.excluirDespesaController(receitaVO);	
	
>>>>>>> branch 'master' of https://github.com/eiywomc/DrMiseravel.git
	}  */

