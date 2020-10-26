package giovannise.tictactoe.core;

import giovannise.tictactoe.Constantes;
import giovannise.tictactoe.UI.UI;

public class Jogo {
	
	private Tabuleiro board = new Tabuleiro();
	private Jogador[] players = new Jogador[Constantes.SYMBOL_PLAYER.length];
	
	public void play() {
		UI.imprimeTituloDoJogo();
		
		board.imprimir();
		
		//UI.lerTextoDigitado("Nome do Jogador:");
	}

}
