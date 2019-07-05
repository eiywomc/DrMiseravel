package view;

import java.util.Scanner;

public class Menu {
	Scanner teclado = new Scanner(System.in);
	private static final int OPCAO_MENU_CADASTRO = 1; // criar constando.
	private static final int OPCAO_MENU_RELATORIO = 2;
	private static final int OPCAO_MENU_SAIR = 3;
	
		
	
	public void apresentarMenu() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_SAIR) {
			switch(opcao) {
				case OPCAO_MENU_CADASTRO: {
					MenuCadastro menuCadastro = new MenuCadastro();
					menuCadastro.apresentarMenuCadastro();
					break;
				}
				case OPCAO_MENU_RELATORIO: {
					MenuRelatorio menuRelatorio = new MenuRelatorio();
					menuRelatorio.apresentarMenuRelatorio();
					break;
				}
				default: {
					System.out.println("Opção inválido.");			
				}
			}
			opcao = this.apresentarOpcoesMenu();
		}
		
	}
	
	public int apresentarOpcoesMenu() {
		System.out.println("Dr. Muquirana - Controle de Gastos");
		System.out.println("\nOpçóes:");
		System.out.println(OPCAO_MENU_CADASTRO + " - Cadastro");
		System.out.println(OPCAO_MENU_RELATORIO + " - Relatório");
		System.out.println(OPCAO_MENU_SAIR + " - Sair");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
}
