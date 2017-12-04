package br.com.pdv.enumerated;

public enum UnidadeMedidaEnum {

	UNIDADE(1, "UNIDADE"), PESO(2, "PESO"), METRO(3, "METRO");

	private int codigo;

	private String descricao;

	private UnidadeMedidaEnum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
