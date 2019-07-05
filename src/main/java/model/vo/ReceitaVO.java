package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceitaVO extends LancamentoVO {
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	LocalDate dateReceita;

	public ReceitaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReceitaVO(int id, int idUsuario, String descricao, double valor) {
		super(id, idUsuario, descricao, valor);
		// TODO Auto-generated constructor stub
	}

	public ReceitaVO(LocalDate dateReceita) {
		super();
		this.dateReceita = dateReceita;
	}

	public LocalDate getDateReceita() {
		return dateReceita;
	}

	public void setDateReceita(LocalDate dateReceita) {
		this.dateReceita = dateReceita;
	}

	public void imprimir() {
			System.out.printf("%2d %-2d %-37s %-6.2f %-20s \n", this.getId(), this.getIdUsuario(), this.getDescricao(), this.getValor(), this.getDateReceita());
			
	}
	
	// exemplo para imprimir this.getDataNascimento().format(formataDate));
	
	
	
}
