package br.com.pdv.enumerated;

public enum StatusCaixaEnum {

	ABERTO(0, "ABERTO"), FECHADO(1, "FECHADO"),;

	private int codigo;

	private String descricao;

	private StatusCaixaEnum(int codigo, String descricao) {
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
