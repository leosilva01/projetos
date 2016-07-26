package br.com.reviews.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.reviews.model.App;

@Repository
@Transactional(readOnly = true)
public class ReviewsDao {

	@PersistenceContext
	private EntityManager manager;

	public List<App> getListaParaReview() {

		List<App> ListaParaReview = this.manager.createQuery("select a from App a join Usuario u on u.id = a.usuario.id where u.pontos > 0", App.class).getResultList();

		return ListaParaReview;

	}

}
