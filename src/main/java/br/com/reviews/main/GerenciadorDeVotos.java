package br.com.reviews.main;

public class GerenciadorDeVotos {

	public static void addVote(App origem, App destino) {

		if (!destino.podeSerVotado() || destino.equals(origem)) {

			System.err.println("Operação não realizada pois o destino não pode ser votado");
			return;
		}

		origem.addQtdPodeSerVotado(1l);

		destino.addQtdVotos(1L);

		destino.addQtdPodeSerVotado(-1l);

		System.out.println("###################################################################################");
		System.out.println(origem.getNome() +" votou em "+destino.getNome());
		System.out.println("Resumo: ORIGEM[ PodeSerVotado: "+origem.getQtdPodeSerVotado()+", Votos: "+origem.getQtdVotos()+"]");
		System.out.println("Resumo: DESTINO[ PodeSerVotado: "+destino.getQtdPodeSerVotado()+", Votos: "+destino.getQtdVotos()+"]");
		System.out.println("###################################################################################");
		
	}

}
