package giovannise.tictactoe.core;

import giovannise.tictactoe.Constantes;
import giovannise.tictactoe.UI.UI;

public class Jogo {
	
	private Tabuleiro board = new Tabuleiro();
	private Jogador[] players = new Jogador[Constantes.SYMBOL_PLAYER.length];
	private int jogadorAtual = 0;
	
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
	
	private Jogador proximo() {
		jogadorAtual++;
		
		//quando chega no final da fila, recomeça a fila do 0
		if(jogadorAtual >= players.length) {
			jogadorAtual = 0;
		}
		
		return players[jogadorAtual];
		
		/*
		 * ---OUTRA OPÇÃO DE ABORDAGEM---
		 * aqui ele vai pegar o valor atual do indice e dividir pelo tamanho do array
		 * fazer teste de mesa para validar que sempre vai dar uma fila circular
		 *  
		 * jogadorAtual = (jogadorAtual +1) % players.length;
		 * 
		 * return players[jogadorAtual];
		 */
	}

}
