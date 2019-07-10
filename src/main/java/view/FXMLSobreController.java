package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class FXMLSobreController {
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
	private Text txtIntegrantes;

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
}
