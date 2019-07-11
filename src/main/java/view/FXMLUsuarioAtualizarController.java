package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.vo.UsuarioVO;
import javafx.scene.control.TextField;

import java.io.IOException;

import controller.ControladoraUsuario;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class FXMLUsuarioAtualizarController {
	@FXML
	private Button btnCadastrarUsuario;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtCPF;
	@FXML
	private TextField txtTelefone;
	@FXML
	private TextField txtLogin;
	@FXML
	private TextField txtSenha;
	@FXML
	private Text lblCPF;
	@FXML
	private Text lblTelefone;
	@FXML
	private Text lblLogin;
	@FXML
	private Text lblSenha;
	@FXML
	private TextField txtCodigo;
	@FXML
	private Label lblAviso;
	@FXML
	private Button btnVoltar;
	@FXML
	private Text lblTitulo;

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
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnDespesa].onAction
	@FXML
	public void loadDespesa(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLDespesa.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		// TODO Autogenerated
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
	// Event Listener on Button[#btnCadastrarUsuario].onAction
	@FXML
	public void atualizarUsuario(ActionEvent event) {
		UsuarioVO usuarioVO = new UsuarioVO();
		
		usuarioVO.setIdUsuario(Integer.parseInt(txtCodigo.getText()));
		usuarioVO.setNome(txtNome.getText());
		usuarioVO.setCpf(txtCPF.getText());
		usuarioVO.setTelefone(txtTelefone.getText());
		usuarioVO.setLogin(txtLogin.getText());
		usuarioVO.setSenha(txtSenha.getText());
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.atualizarUsuarioController(usuarioVO);

		txtCodigo.setText("");
		txtNome.setText("");
		txtCPF.setText("");
		txtTelefone.setText("");
		txtLogin.setText("");
		txtSenha.setText("");
		
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
}
