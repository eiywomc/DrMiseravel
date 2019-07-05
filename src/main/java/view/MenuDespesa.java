package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraDespesa;
import model.vo.DespesaVO;

import model.vo.UsuarioVO;

public class MenuDespesa {
	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int OPCAO_MENU_CADASTRAR_DESPESA = 1;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_DESPESA = 3;
	private static final int OPCAO_MENU_EXCLUIR_DESPESA = 4;
	private static final int OPCAO_MENU_SAIR_DESPESA = 5;

	private static final int OPCAO_MENU_CONSULTAR_UMA_DESPESA = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_USUARIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA_SAIR = 3;

	public void apresentarMenuDespesa() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_SAIR_DESPESA) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_DESPESA: {
				this.cadastrarDespesa();
				break;
			}
			case OPCAO_MENU_CONSULTAR_DESPESA: {
				this.consultarDespesa();
				break;
			}
			case OPCAO_MENU_ATUALIZAR_DESPESA: {
				this.atualizarDespesa();
				break;
			}
			case OPCAO_MENU_EXCLUIR_DESPESA: {
				this.excluirDespesa();
				break;
			}
			default: {
				System.out.println("\nOpção inválida.");
			}
			}
			opcao = this.apresentarOpcoesMenu();
		}

	}

	private int apresentarOpcoesMenu() {
		System.out.println("\nDr. Muquirana - Controle de Gastos --------- Menu Cadastro de Despesas --------");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_CADASTRAR_DESPESA + " - Cadastrar Despesa");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA + " - Consultar Despesa");
		System.out.println(OPCAO_MENU_ATUALIZAR_DESPESA + " - Atualizar Despesa");
		System.out.println(OPCAO_MENU_EXCLUIR_DESPESA + " - Excluir Despesa");
		System.out.println(OPCAO_MENU_SAIR_DESPESA + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());

	}

	private void excluirDespesa() {

		DespesaVO despesaVO = new DespesaVO();
		System.out.println("\nDigite o código da Despesa");
		despesaVO.setId(Integer.parseInt(teclado.nextLine()));

		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.excluirDespesaController(despesaVO);

	}

	private void atualizarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		System.out.println("\nDigite o código da Despesa");
		despesaVO.setId(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nDigite o código do Usuário");
		despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nDigite a descrição da Despesa:");
		despesaVO.setDescricao(teclado.nextLine());
		System.out.println("\nDigite a categoria da Despesa:");
		despesaVO.setCategoria(teclado.nextLine());
		System.out.println("\nDigite o valor da Despesa:");
		despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nDigite a data de Vencimento Despesa:");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), formataDate));
		System.out.println("\nDigite a data de Pagamento da Despesa:");
		despesaVO.setDataPagamento(LocalDate.parse(teclado.nextLine(), formataDate));

		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.atualizarDespesaController(despesaVO);
	}

	private void consultarDespesa() {
		int opcao = this.apresentarOpcoesConsulta();
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		while(opcao != OPCAO_MENU_CONSULTAR_DESPESA_SAIR) {
			switch(opcao) {
				case OPCAO_MENU_CONSULTAR_UM_USUARIO: {
					opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
					UsuarioVO usuarioVO = new UsuarioVO();
					System.out.println("\nDigite o código do Usuário");
					usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
					ArrayList<DespesaVO> listaDespesasVO = controladoraDespesa.consultarUmUsuarioController(usuarioVO);
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n %2s  %-2s  %-35s   %-8s   %-15s   %-15s   %-15s \n", "D", "U", "DESCRICAO", "VALOR", "DT_VENCIMENTO", "DT_PAGAMENTO", "CATEGORIA" );
					for(int i = 0; i < listaDespesasVO.size(); i++) {
						listaDespesasVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UMA_DESPESA: {
					opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
/* */				DespesaVO despesaVO = new DespesaVO();
					System.out.println("\nDigite o código da Despesa:");
					despesaVO.setId(Integer.parseInt(teclado.nextLine()));
					DespesaVO despesa = controladoraDespesa.consultarDespesaCOntroller(despesaVO);
					System.out.printf("\n %2s  %-2s  %-35s   %-8s   %-15s   %-15s   %-15s \n", "D", "U", "DESCRICAO", "VALOR", "DT_VENCIMENTO", "DT_PAGAMENTO", "CATEGORIA");
					despesa.imprimir();
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
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_DESPESA + " - Consultar Uma Despesa");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_USUARIO + " - Consultar Despesas de um Usuário");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA_SAIR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());

	}

	private void cadastrarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		System.out.println("\nDigite o código do Usuário");
		despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nDigite a descrição da Despesa:");
		despesaVO.setDescricao(teclado.nextLine());
		System.out.println("\nDigite a categoria da Despesa:");
		despesaVO.setCategoria(teclado.nextLine());
		System.out.println("\nDigite o valor da Despesa:");
		despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nDigite a data de Vencimento Despesa:");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), formataDate));
		System.out.println("\nDigite a data de Pagamento da Despesa:");
		despesaVO.setDataPagamento(LocalDate.parse(teclado.nextLine(), formataDate));
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.cadastrarDespesaController(despesaVO);

	}

}
