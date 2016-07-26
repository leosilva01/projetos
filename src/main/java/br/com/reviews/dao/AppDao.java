package br.com.reviews.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.reviews.model.App;

@Repository
@Transactional
public class AppDao {

	@PersistenceContext
	private EntityManager manager;

	public void salva(App app) {

		manager.persist(app);
	}

	public App buscaPorId(int id) {

		return manager.find(App.class, id);
	}

	public void altera(App app) {

		if (app.equals(manager.find(App.class, app.getId()))) {
			manager.merge(app);

		}
	}
}
