package giovannise.tictactoe.core;

import giovannise.tictactoe.Constantes;

public class Jogo {
	
	Tabuleiro board = new Tabuleiro();
	Jogador[] players = new Jogador[Constantes.SYMBOL_PLAYER.length];
	
	public void play() {
		System.out.println("Jogando...");
	}

}
