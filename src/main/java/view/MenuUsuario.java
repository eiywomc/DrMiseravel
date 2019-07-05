package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraUsuario;
import model.vo.UsuarioVO;

public class MenuUsuario {
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CADASTRAR_USUARIO = 1;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO = 2;
	private static final int OPCAO_MENU_ATUALIZAR_USUARIO = 3;
	private static final int OPCAO_MENU_EXCLUIR_USUARIO = 4;
	private static final int OPCAO_MENU_SAIR_USUARIO = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_USUARIOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_USUARIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO_SAIR = 3;
/**/private static final int OPCAO_MENU_CONSULTAR_USARIO_POR_NOME = 4;
	
	public void apresentarMenuUsuario() {
		int opcao = this.apresentarOpcoesMenu();
		while(opcao != OPCAO_MENU_SAIR_USUARIO ) {
			switch(opcao) {
				case OPCAO_MENU_CADASTRAR_USUARIO: {
					this.cadastrarUsuario();
					break;
				}
				case OPCAO_MENU_CONSULTAR_USUARIO: {
					this.consultarUsuario();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_USUARIO: {
					this.atualizarUsuario();
					break;
				}
				case OPCAO_MENU_EXCLUIR_USUARIO: {
					this.excluirUsuario();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			
			opcao = this.apresentarOpcoesMenu();
		}
		
	}


	private int apresentarOpcoesMenu() {
			System.out.println("\nDr. Muquirana - Controle de Gastos \n --------- Menu Cadastro de Usuarios --------");
			System.out.println("\nOpções: ");
			System.out.println(OPCAO_MENU_CADASTRAR_USUARIO + " - Cadastrar Usuário");
			System.out.println(OPCAO_MENU_CONSULTAR_USUARIO + " - Consultar Usuário");
			System.out.println(OPCAO_MENU_ATUALIZAR_USUARIO + " - Atualizar Usuário");
			System.out.println(OPCAO_MENU_EXCLUIR_USUARIO + " - Excluir Usuário");
			System.out.println(OPCAO_MENU_SAIR_USUARIO + " - Voltar");
			System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
	

	private void excluirUsuario() {
		
		UsuarioVO usuarioVO = new UsuarioVO();
		System.out.println("\nDigite o código do Usuário");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.excluirUsuarioController(usuarioVO);
		
		
	}

	private void atualizarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		System.out.println("\nDigite o código do Usuário");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nDigite o nome do Usuário");
		usuarioVO.setNome(teclado.nextLine());
		System.out.println("\nDigite o CPF do Usuário");
		usuarioVO.setCpf(teclado.nextLine());
		System.out.println("\nDigite o Telefone do Usuário");
		usuarioVO.setTelefone(teclado.nextLine());
		System.out.println("\nDigite o login do Usuário");
		usuarioVO.setLogin(teclado.nextLine());
		System.out.println("\nDigite a senha do Usuário");
		usuarioVO.setSenha(teclado.nextLine());
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.atualizarUsuarioController(usuarioVO);
		
	}

	private void consultarUsuario() {
		int opcao = this.apresentarOpcoesConsulta();
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		while(opcao != OPCAO_MENU_CONSULTAR_USUARIO_SAIR) {
			switch(opcao) {
				case OPCAO_MENU_CONSULTAR_TODOS_USUARIOS: {
					opcao = OPCAO_MENU_CONSULTAR_USUARIO_SAIR;
					ArrayList<UsuarioVO> listaUsuariosVO = controladoraUsuario.consultarTodosUsuariosController();
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n %3s  %-40s  %-15s  %-15s \n", "ID", "NOME", "CPF", "TELEFONE");
					for(int i = 0; i < listaUsuariosVO.size(); i++) {
						listaUsuariosVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UM_USUARIO: {
					opcao = OPCAO_MENU_CONSULTAR_USUARIO_SAIR;
					UsuarioVO usuarioVO = new UsuarioVO();
					System.out.println("\nDigite o código do Usuário");
					usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
					UsuarioVO usuario = controladoraUsuario.consultarUsuarioCOntroller(usuarioVO);
					System.out.printf("\n %3s  %-40s  %-15s  %-15s \n", "ID", "NOME", "CPF", "TELEFONE");
					usuario.imprimir();
					break;
				}
				case OPCAO_MENU_CONSULTAR_USARIO_POR_NOME: {
					opcao = OPCAO_MENU_CONSULTAR_USUARIO_SAIR;
					UsuarioVO usuarioVO = new UsuarioVO();
					System.out.println("\nDigite o nome ou parcial do Usuário:");
					usuarioVO.setNome(teclado.nextLine());
					ArrayList<UsuarioVO> listaUsuariosVO = controladoraUsuario.consultarNomeUsuariosController(usuarioVO);
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n %3s  %-40s  %-15s  %-15s \n", "ID", "NOME", "CPF", "TELEFONE");
					for(int i = 0; i < listaUsuariosVO.size(); i++) {
						listaUsuariosVO.get(i).imprimir();
					}
					break;
				}
				default : {
					System.out.println("\nOpção Inválida.");
					opcao = this.apresentarOpcoesConsulta();
				}
			}
		}
	}

	private int apresentarOpcoesConsulta() {

		System.out.println("\nInforme o tipo de consulta a ser realizada: ");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_USUARIOS + " - Consultar Todos os Usuários");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_USUARIO + " - Consultar um Usuário");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO_SAIR + " - Voltar");
/* */	System.out.println(OPCAO_MENU_CONSULTAR_USARIO_POR_NOME + " - Consultar Usuários por nome parcial");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());

	}


	private void cadastrarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		System.out.println("\nDigite o nome do Usuário");
		usuarioVO.setNome(teclado.nextLine());
		System.out.println("\nDigite o CPF do Usuário");
		usuarioVO.setCpf(teclado.nextLine());
		System.out.println("\nDigite o Telefone do Usuário");
		usuarioVO.setTelefone(teclado.nextLine());
		System.out.println("\nDigite o login do Usuário");
		usuarioVO.setLogin(teclado.nextLine());
		System.out.println("\nDigite a senha do Usuário");
		usuarioVO.setSenha(teclado.nextLine());
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.cadastrarUsuarioController(usuarioVO);
		
		
		
	}
}
