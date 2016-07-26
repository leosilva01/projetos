package br.com.reviews.main;

public class Main {

	public static void main(String[] args) {
		App rodolfo = new App("rodolfo");
		App leo = new App("leo");
		App thais = new App("thais");
		App camila = new App("camila");		
		
		GerenciadorDeVotos.addVote(rodolfo, leo);
		GerenciadorDeVotos.addVote(rodolfo, thais);
		GerenciadorDeVotos.addVote(rodolfo, camila);
		GerenciadorDeVotos.addVote(leo, rodolfo);
		GerenciadorDeVotos.addVote(thais, leo);
		
		System.out.println("\n\n******************************************\n\n");
		
		System.out.println("rodolfo: "+rodolfo);
		System.out.println("Leo: "+leo);
		System.out.println("camila: "+camila);
		System.out.println("thais: "+thais);
		
	}
}
