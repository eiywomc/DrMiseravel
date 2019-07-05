package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


import controller.ControladoraReceita;

import model.vo.ReceitaVO;
import model.vo.UsuarioVO;


public class MenuReceita {
	
	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_MENU_CADASTRAR_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RECEITA = 3;
	private static final int OPCAO_MENU_EXCLUIR_RECEITA = 4;
	private static final int OPCAO_MENU_SAIR_RECEITA= 5;
	
	private static final int OPCAO_MENU_CONSULTAR_UMA_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_USUARIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA_SAIR = 3;
	
	public void apresentarMenuReceita() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_SAIR_RECEITA) {
			switch(opcao) {
				case OPCAO_MENU_CADASTRAR_RECEITA: {
					this.cadastrarReceita();
					break;
				}
				case OPCAO_MENU_CONSULTAR_RECEITA:{
					this.consultarReceita();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_RECEITA:{
					this.atualizarReceita();
					break;
				}
				case OPCAO_MENU_EXCLUIR_RECEITA:{
					this.excluirReceita();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida.");
				}
			}
			opcao = this.apresentarOpcoesMenu();
			
		}
		
	}
	
	private int apresentarOpcoesMenu() {
		System.out.println("\nDr. Muquirana - Controle de Gastos --------- Menu Cadastro de Receitas --------");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_CADASTRAR_RECEITA + " - Cadastrar Receita");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA + " - Consultar Receita");
		System.out.println(OPCAO_MENU_ATUALIZAR_RECEITA + " - Atualizar Receita");
		System.out.println(OPCAO_MENU_EXCLUIR_RECEITA + " - Excluir Receita");
		System.out.println(OPCAO_MENU_SAIR_RECEITA + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
		
	}

	private void excluirReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.println("\nDigite o código da Receita");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));

		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.excluirDespesaController(receitaVO);

	}

	private void atualizarReceita() {

		ReceitaVO receitaVO = new ReceitaVO();
		System.out.println("\nDigite o código da Receita a atualizar:");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nDigite o código do Usuário");
		receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nDigite a descrição da Receita");
		receitaVO.setDescricao(teclado.nextLine());
		System.out.println("\nDigite o valor da Receita");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nDigite a data da Receita");
		receitaVO.setDateReceita(LocalDate.parse(teclado.nextLine(), formataDate));

		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.atualizarReceitaController(receitaVO);
		
	}

	private void consultarReceita() {
		int opcao = this.apresentarOpcoesConsulta();
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		while(opcao != OPCAO_MENU_CONSULTAR_RECEITA_SAIR) {
			switch(opcao) {
				case OPCAO_MENU_CONSULTAR_UM_USUARIO: {
					opcao = OPCAO_MENU_CONSULTAR_RECEITA_SAIR;
					UsuarioVO usuarioVO = new UsuarioVO();
					System.out.println("\nDigite o código do Usuário");
					usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
					ArrayList<ReceitaVO> listaReceitasVO = controladoraReceita.consultarUmUsuarioController(usuarioVO);
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n %2s  %-2s  %-35s   %-8s   %-15s  \n", "D", "U", "DESCRICAO", "VALOR", "DT_RECEITA" );
					for(int i = 0; i < listaReceitasVO.size(); i++) {
						listaReceitasVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UMA_RECEITA: {
					opcao = OPCAO_MENU_CONSULTAR_RECEITA_SAIR;
/* */				ReceitaVO receitaVO = new ReceitaVO();
					System.out.println("\nDigite o código da Receita:");
					receitaVO.setId(Integer.parseInt(teclado.nextLine()));
					ReceitaVO receita = controladoraReceita.consultarReceitaController(receitaVO);
					System.out.printf("\n %2s  %-2s  %-35s   %-8s   %-15s  \n", "D", "U", "DESCRICAO", "VALOR", "DT_RECEITA");
					receita.imprimir();
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
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_RECEITA + " - Consultar Uma Receita");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_USUARIO + " - Consultar Receitas de um Usuário");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA_SAIR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.println("\nDigite o código do Usuário");
		receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nDigite a descrição da Receita");
		receitaVO.setDescricao(teclado.nextLine());
		System.out.println("\nDigite o valor da Receita");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nDigite a data da Receita");
		receitaVO.setDateReceita(LocalDate.parse(teclado.nextLine(), formataDate));

		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.cadastrarReceitaController(receitaVO);
		
	}



}
