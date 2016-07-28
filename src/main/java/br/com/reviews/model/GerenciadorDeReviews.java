package br.com.reviews.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reviews.dao.AppDao;
import br.com.reviews.dao.ReviewsDao;
import br.com.reviews.dao.UsuarioDao;

@Component
public class GerenciadorDeReviews {

	@Autowired
	private ReviewsDao reviewsDao;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private AppDao appDao;

	// TODO nao permitir que 2 pessoas deem review no mesmo app(lock) ao mesmo tempo
	public boolean addReviews(Usuario usuarioQueVota, App app) {

		Usuario usuarioVotado = app.getUsuario();

		if (validaVoto(usuarioQueVota, usuarioVotado)) {

			usuarioQueVota.vota(app);

			usuarioDao.altera(usuarioQueVota);
			usuarioDao.altera(usuarioVotado);
			appDao.altera(app);

			return true;
		}
		
		return false;

	}

	private boolean validaVoto(Usuario usuarioQueVota, Usuario usuarioVotado) {

		if (usuarioQueVota.equals(usuarioVotado)) {
			return false;
		}
		if (!usuarioVotado.podeSerVotado()) {
			return false;
		}
		return true;
	}

	public List<App> getFilaReviews() {

		return reviewsDao.getListaParaReview();
		// TODO fazer historico de votos para que o app já votado não apareça na lista novamente
		// TODO nao listar apps do proprio usuario
	}
}
