package br.com.reviews.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.reviews.dao.UsuarioDao;
import br.com.reviews.model.Usuario;

@Service()
public class CustomUsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.buscaPorLogin(login);

		if (usuario == null) {
			System.out.println("usuario nao encontrado");
			throw new UsernameNotFoundException("usuário não encontrado");
		}
		return new org.springframework.security.core.userdetails.User(usuario.getUsername()
				, usuario.getPassword(), true, true, true, true, usuario.getRoles());
	}

}
