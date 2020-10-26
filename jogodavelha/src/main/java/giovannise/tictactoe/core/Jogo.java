package giovannise.tictactoe.core;

import giovannise.tictactoe.Constantes;
import giovannise.tictactoe.UI.UI;

public class Jogo {
	
	Tabuleiro board = new Tabuleiro();
	Jogador[] players = new Jogador[Constantes.SYMBOL_PLAYER.length];
	
	public void play() {
		UI.imprimeTituloDoJogo();
		UI.lerTextoDigitado("Nome do Jogador:");
	}

}
