package view;

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
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.ControladoraDespesa;
import controller.ControladoraReceita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class FXMLDespesaConsultarIdUsuarioController {
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
	private Button btnConsultarDespesaPorIdUsuario;
	@FXML
	private TextField txtIdUsuario;
	@FXML
	private Text lblIdUsuario;
	@FXML
	private TableView<DespesaVO> tblTabela;
	@FXML
	private TableColumn<DespesaVO, String> clnIdReceita;
	@FXML
	private TableColumn<DespesaVO, String> clnDescricao;
	@FXML
	private TableColumn<DespesaVO, String> clnDataLancamento;
	@FXML
	private TableColumn<DespesaVO, String> clnDataPagamento;
	@FXML
	private TableColumn<DespesaVO, String> clnValor;
	@FXML
	private TableColumn<DespesaVO, String> clnCategoria;

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
		window.show();// TODO Autogenerated
	}
	// Event Listener on Button[#btnVoltar].onAction
	@FXML
	public void voltarDespesa(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("FXMLDespesa.fxml"));
		Scene scene = new Scene(parent, 800, 600);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	// Event Listener on Button[#btnConsultarDespesaPorIdUsuario].onAction
	@FXML
	public void consultarDespesaPorIdUsuario(ActionEvent event) {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
		
		carregarTableViewDespesas(usuarioVO);
	}
	private List<DespesaVO> listaDespesasVO = new ArrayList();
	private ObservableList<DespesaVO> observableListDespesas;
	
	public void carregarTableViewDespesas(UsuarioVO usuarioVO) {
		
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		listaDespesasVO = controladoraDespesa.consultarUmUsuarioController(usuarioVO);
		
		observableListDespesas = FXCollections.observableArrayList(listaDespesasVO);
		clnIdReceita.setCellValueFactory(new PropertyValueFactory<>("id"));
		clnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		clnDataLancamento.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
		clnDataPagamento.setCellValueFactory(new PropertyValueFactory<>("DataPagamento"));
		clnCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
		clnValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		
		tblTabela.setItems(observableListDespesas);
	}
}
