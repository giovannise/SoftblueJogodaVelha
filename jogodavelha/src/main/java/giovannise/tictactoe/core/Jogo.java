package giovannise.tictactoe.core;

import giovannise.tictactoe.Constantes;
import giovannise.tictactoe.UI.UI;

public class Jogo {
	
	private Tabuleiro board = new Tabuleiro();
	private Jogador[] players = new Jogador[Constantes.SYMBOL_PLAYER.length];
	
	public void play() {
		UI.imprimeTituloDoJogo();
		
		for(int i = 0; i < players.length; i++) {
			players[i] = criaJogador(i);
		}
	}
	
	private Jogador criaJogador(int indice) {
		String name = UI.lerTextoDigitado("Jogador " + (indice + 1) + " =>");
		char symbol = Constantes.SYMBOL_PLAYER[indice];
		Jogador player = new Jogador(name, board, symbol);
		
		UI.imprimeTexto("O jogador " + name + " vai usar o símbolo '" + symbol +"'");
		
		return player;
	}

}
