package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.vo.UsuarioVO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import controller.ControladoraReceita;
import controller.ControladoraUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import model.vo.ReceitaVO;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class FXMLReceitaConsultarIdUsuarioController {
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
	private Button btnConsultarReceitaPorIdUsuario;
	@FXML
	private TextField txtIdUsuario;
	@FXML
	private Text lblIdUsuario;
	@FXML
	private TableView<ReceitaVO> tblTabela;
	@FXML
	private TableColumn<ReceitaVO, String> clnIdReceita;
	@FXML
	private TableColumn<ReceitaVO, String> clnDescricao;
	@FXML
	private TableColumn<ReceitaVO, String> clnData;
	@FXML
	private TableColumn<ReceitaVO, String> clnValor;
	
	private List<ReceitaVO> listaReceitasVO = new ArrayList();
	
	

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
	// Event Listener on Button[#btnConsultarReceitaPorIdUsuario].onAction
	@FXML
	
	public void consultarReceitaPorIdUsuario(ActionEvent event) {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
		
		carregarTableViewReceitas(usuarioVO);
	}
	
	private ObservableList<ReceitaVO> observableListReceitas;
	
	public void carregarTableViewReceitas(UsuarioVO usuarioVO) {
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		listaReceitasVO = controladoraReceita.consultarUmUsuarioController(usuarioVO);
		
		observableListReceitas = FXCollections.observableArrayList(listaReceitasVO);
		clnIdReceita.setCellValueFactory(new PropertyValueFactory<>("id"));
		clnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		clnData.setCellValueFactory(new PropertyValueFactory<>("dateReceita"));
		clnValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		
		tblTabela.setItems(observableListReceitas);
	}
		
}
