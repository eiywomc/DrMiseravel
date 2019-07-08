package model.dto;

public class SaldoUsuarioDTO {
	private int id;
	private String nome;
	private double totalReceita;
	private double totalDespesa;
	private double totalSaldo;
	public SaldoUsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaldoUsuarioDTO(int id, String nome, double totalReceita, double totalDespesa, double totalSaldo) {
		super();
		this.id = id;
		this.nome = nome;
		this.totalReceita = totalReceita;
		this.totalDespesa = totalDespesa;
		this.totalSaldo = totalSaldo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getTotalReceita() {
		return totalReceita;
	}
	public void setTotalReceita(double totalReceita) {
		this.totalReceita = totalReceita;
	}
	public double getTotalDespesa() {
		return totalDespesa;
	}
	public void setTotalDespesa(double totalDespesa) {
		this.totalDespesa = totalDespesa;
	}
	public double getTotalSaldo() {
		return totalSaldo;
	}
	public void setTotalSaldo(double totalSaldo) {
		this.totalSaldo = totalSaldo;
	}
	
}
