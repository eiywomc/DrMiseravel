package model.vo;

public class CategoriaVO {
	private int idCategoria;
	private String descricao;
	public CategoriaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaVO(int idCategoria, String descricao) {
		super();
		this.idCategoria = idCategoria;
		this.descricao = descricao;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
