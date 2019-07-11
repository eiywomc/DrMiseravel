package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.vo.UsuarioVO;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.ControladoraUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class FXMLUsuarioConsultarUmController implements Initializable{
	@FXML
	private Button btnConsultarUsuario;
	@FXML
	private Text lblCPF;
	@FXML
	private Text lblTelefone;
	@FXML
	private Text txtCPF;
	@FXML
	private Text txtNome;
	@FXML
	private Text txtTelefone;
	@FXML
	private Text txtLogin;
	@FXML
	private Label lblAviso;
	@FXML
	private Button btnVoltar;
	@FXML
	private Text lblTitulo;
	@FXML
	private TextField cmbCodigo;
	
//	private List<UsuarioVO> listaUsuariosVO = new ArrayList();
//	private ObservableList<UsuarioVO> observableListUsuarios;
	
	// Event Listener on Button.onAction
	@FXML
	public void loadUsuario(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLUsuario.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		
		//loadConsultarTodos
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


	// Event Listener on ComboBox[#cmbCodigo].onAction
	@FXML
	public void consultarUsuario(ActionEvent event) {
		UsuarioVO usuarioVO = new UsuarioVO();
	
//		usuarioVO.setIdUsuario(cmbCodigo.getValue().getIdUsuario());
		usuarioVO.setIdUsuario(Integer.parseInt(cmbCodigo.getText()));
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		UsuarioVO usuario = controladoraUsuario.consultarUsuarioCOntroller(usuarioVO);
		
		txtTelefone.setText(usuario.getTelefone());
		txtNome.setText(usuario.getNome());
		txtCPF.setText(usuario.getCpf());
		txtLogin.setText(usuario.getLogin());
	}
	// Event Listener on Button[#btnVoltar].onAction
	@FXML
	public void voltarUsuario(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLUsuario.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		
	}
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		carregarComboBoxUsuarios();
	}
	private void carregarComboBoxUsuarios() {
//		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
//		listaUsuariosVO = controladoraUsuario.consultarTodosUsuariosController();
////		
///
//		
//		observableListUsuarios = FXCollections.observableArrayList(listaUsuariosVO);
//		//clnCod.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
//		
//		
//		cmbCodigo.setItems(observableListUsuarios);
//		
//	
	}
}
