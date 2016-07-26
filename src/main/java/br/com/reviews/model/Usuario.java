package br.com.reviews.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;

	private String email;

	private int pontos;

	// TODO mal feito
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<App> apps;

	@DateTimeFormat
	private Calendar dataCadastro;

	@DateTimeFormat
	private Calendar dataExpiracao;
	
	//TODO tratar erro ao salvar login repetido
	@Column(unique = true)
	private String login;

	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuario_role", joinColumns= {@JoinColumn(name = "usuario_id")},
	inverseJoinColumns = {@JoinColumn (name="role_id")})
	private List<Role> roles = new ArrayList<>();

	//TODO toda logica de premuim
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;

	public String getEmail() {

		return this.email;
	}

	public int getPontos() {

		return this.pontos;
	}

	public void vota(App app) {

		System.out.println("usuario(antes do voto) que vota: " + this);
		this.pontos = pontos + 1;
		app.votado();
		System.out.println("usuario(depois do voto) que vota: " + this);
		
	}

	public void votado() {
		
		this.pontos = pontos - 1;
	}

	public Calendar getDataExpiracao() {

		return this.dataExpiracao;
	}

	public void setDataExpiracao(final Calendar dataExpiracao) {

		this.dataExpiracao = dataExpiracao;
	}

	public String getSenha() {

		return this.senha;
	}

	public void setSenha(final String senha) {

		this.senha = senha;
	}

	public TipoConta getTipoConta() {

		return this.tipoConta;
	}

	public void setTipoConta(final TipoConta tipoConta) {

		this.tipoConta = tipoConta;
	}

	public int getId() {

		return this.id;
	}

	public String getNome() {

		return this.nome;
	}

	public Calendar getDataCadastro() {

		return this.dataCadastro;
	}

	public String getLogin() {

		return this.login;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public void setDataCadastro(final Calendar dataCadastro) {

		this.dataCadastro = dataCadastro;
	}

	public void setLogin(final String login) {

		this.login = login;
	}

	public List<App> getApps() {

		return this.apps;
	}

	public void setApps(final List<App> apps) {

		this.apps = apps;
	}

	public List<Role> getRoles() {

		return this.roles;
	}

	public void setRoles(final List<Role> roles) {

		this.roles = roles;
	}

	public void addRole(final Role role) {

		this.roles.add(role);
	}

	@Override
	public String toString() {

		return "id:" + this.id + " usuario:" + this.nome + " login:" + this.login
				+ " email:" + this.email + " pontos: " + this.pontos;
	}
	
	


	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ( ( login == null ) ? 0 : login.hashCode() );
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.roles;
	}

	@Override
	public String getPassword() {

		return this.senha;
	}

	@Override
	public String getUsername() {

		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {

		// TODO ver depois
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	public boolean podeSerVotado() {

		if(pontos > 0){
			return true;
		} else{
			return false;
		}
	}
}
