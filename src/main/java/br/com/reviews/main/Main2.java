package br.com.reviews.main;

import br.com.reviews.model.App;
import br.com.reviews.model.Usuario;

public class Main2 {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		Usuario usuario2 = new Usuario();
		
		usuario.setLogin("leo");
		usuario2.setLogin("rapha");
		
		App app = new App();
		
		app.setNome("app");
		app.setUsuario(usuario2);
		
		usuario.vota(app);
		
		System.out.println(usuario.equals(usuario2));
		
	}
}
