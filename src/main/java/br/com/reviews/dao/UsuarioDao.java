package br.com.reviews.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.reviews.model.App;
import br.com.reviews.model.Role;
import br.com.reviews.model.TipoConta;
import br.com.reviews.model.Usuario;

@Repository @Transactional
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public void salva(final Usuario usuario) {
		
		
		usuario.setDataCadastro(Calendar.getInstance());

		usuario.setTipoConta(TipoConta.FREE);
		
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));

		//TODO mal feito
		Role role = manager.createQuery("select r from Role r where r.nome = 'ROLE_FREE'", Role.class).getResultList().get(0);
		usuario.addRole(role);

		this.manager.persist(usuario);
	}

	
	public Usuario localizarPorId(final int id) {

		return this.manager.find(Usuario.class, id);
	}

	public List<App> getApps(final Usuario usuario) {

		return usuario.getApps();
	}

	public List<Usuario> listarTodos() {

		return this.manager.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}
	
	public Usuario buscaPorLogin(String login){
		 Usuario usuario = this.manager.createQuery("select u from Usuario u where u.login = :login", Usuario.class)
				.setParameter("login", login).getSingleResult();

		return usuario;

	}
	
	public void altera(Usuario usuario){
		
		if(usuario.equals(manager.find(Usuario.class, usuario.getId()))){
			manager.merge(usuario);
			
		}
	}

}
