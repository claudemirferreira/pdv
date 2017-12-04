package br.com.pdv.enumerated;

public enum TipoMovimentacaoEnum {

	ENTRADA(0, "ENTRADA"), SAIDA(1, "SAIDA");

	private int codigo;

	private String descricao;

	private TipoMovimentacaoEnum(int codigo, String descricao) {
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
