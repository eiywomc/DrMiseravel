package model.dto;

public class DespesaUsuarioDTO {
	private int id;
	private String nome;
	private double totalDespesa;
	public DespesaUsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DespesaUsuarioDTO(int id, String nome, double totalDespesa) {
		super();
		this.id = id;
		this.nome = nome;
		this.totalDespesa = totalDespesa;
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
	public double getTotalDespesa() {
		return totalDespesa;
	}
	public void setTotalDespesa(double totalDespesa) {
		this.totalDespesa = totalDespesa;
	}
	public void imprimir() {
		System.out.printf("\n %3s  %-20s  %-15s \n", this.getId(), this.getNome(), this.getTotalDespesa() );
		
	}
	
	
}
