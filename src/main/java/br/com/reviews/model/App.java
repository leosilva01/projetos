package br.com.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class App {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;

	private int qtdReviews;

	private String link;
	
	@ManyToOne
	private Usuario usuario;
	
	public Usuario getUsuario() {
	
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
	
		this.usuario = usuario;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getLink() {

		return link;
	}

	public void setLink(String link) {

		this.link = link;
	}

	public int getId() {

		return id;
	}

	public int getQtdReviews() {

		return qtdReviews;
	}
	
	public void votado(){
		
		System.out.println("app(antes do voto) a ser votado: "+ this);
		this.qtdReviews = qtdReviews + 1;
		this.usuario.votado();
		System.out.println("app(depois do voto) a ser votado: "+ this);
	}

	@Override
	public String toString() {
	
		return "nome do App: " + this.nome + " qtd de reviews: " +this.qtdReviews + " vinculado ao: " + this.usuario;
	}
	
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		App other = (App) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
