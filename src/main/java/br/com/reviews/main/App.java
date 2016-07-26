package br.com.reviews.main;

public class App {

	private String nome;

	private Long qtdPodeSerVotado = 0l;

	private Long qtdVotos = 0l;

	public App( final String nome ) {

		this.nome = nome;
		this.addQtdPodeSerVotado(1L);

	}

	/**
	 * Retorna o valor do atributo <code>nome</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNome() {

		return nome;
	}

	/**
	 * Define o valor do atributo <code>nome</code>.
	 *
	 * @param nome
	 */
	public void setNome(String nome) {

		this.nome = nome;
	}

	/**
	 * Retorna o valor do atributo <code>qtdPodeSerVotado</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getQtdPodeSerVotado() {

		return qtdPodeSerVotado;
	}

	public boolean podeSerVotado() {

		return this.qtdPodeSerVotado > 0;
	}

	public void addQtdPodeSerVotado(Long qtdPodeSerVotado) {

		this.qtdPodeSerVotado += qtdPodeSerVotado;
	}

	/**
	 * Retorna o valor do atributo <code>qtdVotos</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getQtdVotos() {

		return qtdVotos;
	}

	public void addQtdVotos(Long qtdVotos) {

		this.qtdVotos += qtdVotos;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
		return result;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		App other = (App) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "App [" + ( nome != null ? "nome=" + nome + ", " : "" ) + ( qtdPodeSerVotado != null ? "qtdPodeSerVotado=" + qtdPodeSerVotado + ", " : "" ) + ( qtdVotos != null ? "qtdVotos=" + qtdVotos : "" ) + "]";
	}

}
