package view;

import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.vo.CategoriaVO;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.ControladoraCategoria;
import controller.ControladoraDespesa;
import controller.ControladoraReceita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;

import javafx.scene.text.Text;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

public class FXMLDespesaCadastroController implements Initializable {
	
	private List<CategoriaVO> listaCategoriaVO = new ArrayList();
	private List<String> listaCategoriaVOString = new ArrayList();
	private ObservableList<String> observableListCategorias;
	
	
	
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
	private TextField txtCodigo;
	@FXML
	private TextField txtDescricao;
	@FXML
	private Text lblID;
	@FXML
	private Text lblDescricao;
	@FXML
	private Text lblDataVencimento;
	@FXML
	private Text lblValor;
	@FXML
	private Button btnCadastrarDespesa;
	@FXML
	private Button btnVoltar;
	@FXML
	private DatePicker txtDataVencimento;
	@FXML
	private TextField txtValor;
	@FXML
	private Text lblID1;
	@FXML
	private ComboBox cmbCategoria;
	@FXML
	private Button btnCategoria;
	@FXML
	private Text lblDataPagamento;
	@FXML
	private DatePicker txtDataPagamento;

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
	// Event Listener on Button[#btnCadastrarDespesa].onAction
	@FXML
	public void cadastrarDespesa(ActionEvent event) {
		
		DespesaVO despesaVO =  new DespesaVO();
		
		if (txtCodigo.getText().equals("") || cmbCategoria.getValue().equals("") || txtDescricao.getText().equals("") || txtDataVencimento.getValue().equals(null) ||txtDataPagamento.getValue().equals(null) || txtValor.getText().equals("") ){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erro - Dr. Muquirana");
			alert.setHeaderText("Erro ao cadastrar despesa.");
			alert.setContentText("Todos os campos devem ser preenchidos.");

			alert.showAndWait();
			return;
		}
		
		despesaVO.setIdUsuario(Integer.parseInt(txtCodigo.getText()));
		despesaVO.setDescricao(txtDescricao.getText());
		despesaVO.setDataVencimento(txtDataVencimento.getValue());
		despesaVO.setDataPagamento(txtDataPagamento.getValue());
		despesaVO.setCategoria(cmbCategoria.getValue().toString());
		despesaVO.setValor(Double.parseDouble(txtValor.getText()));
		
		
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.cadastrarDespesaController(despesaVO);
		// "limpa" os campos após a inserção dos dados
		txtCodigo.setText("");
		txtDescricao.setText("");
		txtDataVencimento.setValue(null);
		txtDataPagamento.setValue(null);
		txtValor.setText("");
		
	}
	// Event Listener on Button[#btnVoltar].onAction
	@FXML
	public void voltarReceita(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLDespesa.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnCategoria].onAction
	@FXML
	public void loadCategoria(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLCategoria.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		carregarComboBoxCategorias();
	}
	private void carregarComboBoxCategorias() {
	ControladoraCategoria controladoraCategoria = new ControladoraCategoria();
		
		listaCategoriaVO = controladoraCategoria.consultarTodosCategoriasController();
		for (int i = 0; i<listaCategoriaVO.size(); i++) {
			listaCategoriaVOString.add(listaCategoriaVO.get(i).getDescricao());
		}
		 
		observableListCategorias = FXCollections.observableArrayList(listaCategoriaVOString);
		//clnCod.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		
		
		cmbCategoria.setItems(observableListCategorias);
}
}
