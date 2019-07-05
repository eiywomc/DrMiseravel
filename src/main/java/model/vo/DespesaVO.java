package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaVO extends LancamentoVO{
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private String categoria;
	public DespesaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DespesaVO(int id, int idUsuario, String descricao, double valor) {
		super(id, idUsuario, descricao, valor);
		// TODO Auto-generated constructor stub
	}
	public DespesaVO(LocalDate dataVencimento, LocalDate dataPagamento, String categoria) {
		super();
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.categoria = categoria;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void imprimir() {
			
		System.out.printf("%3d %-3d %-37s %-6.2f   %-15s   %-15s   %-15s \n", this.getId(), this.getIdUsuario(), this.getDescricao(), this.getValor(), this.getDataVencimento().format(formataDate), this.verificarDataPagamento(this.getDataPagamento()), this.getCategoria());
	}
	
	private String verificarDataPagamento(LocalDate dataPagamento) {
		String resultado = "Não pago";
		if (dataPagamento != null) {
			resultado = dataPagamento.toString();
		}
		return resultado;
	}
}
