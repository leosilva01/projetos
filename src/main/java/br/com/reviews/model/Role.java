package br.com.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	public Role(String nome) {
		this.nome = nome;
	}
	
	public Role() {	}
	
	
	public int getId() {
	
		return id;
	}
	
	public String getNome() {
	
		return nome;
	}

	public void setNome(String nome) {
	
		this.nome = nome;
	}

	@Override
	public String getAuthority() {

		return this.nome;
	}
	@Override
	public String toString() {
	
		return this.nome;
	}
	
}
