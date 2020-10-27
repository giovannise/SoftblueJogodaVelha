package giovannise.tictactoe.core;

import giovannise.tictactoe.Constantes;
import giovannise.tictactoe.UI.UI;

public class Jogo {
	
	private Tabuleiro board = new Tabuleiro();
	private Jogador[] players = new Jogador[Constantes.SYMBOL_PLAYER.length];
	private int indiceJogadorAtual = -1;
	
	public void play() {
		UI.imprimeTituloDoJogo();
		
		for(int i = 0; i < players.length; i++) {
			players[i] = criaJogador(i);
		}
		
		boolean terminou = false;
		Jogador jogadorAtual = proximo();
		Jogador vencedor = null;
		
		while(!terminou) {
			board.imprimir();
			
			boolean sequenciaEncontrada;
			
			try {
				sequenciaEncontrada = jogadorAtual.play();
			} catch (MovimentoInvalidoException e) {
				UI.imprimeTexto("ERRO: " + e.getMessage());
				continue;
			}
			
			if(sequenciaEncontrada) {
				terminou = true;
				vencedor = jogadorAtual;
			} else if (board.cheio()) {
				terminou = true;
				System.out.println("EMPATE");
			}
			
			jogadorAtual = proximo();
		}
		
		if (vencedor == null) {
			UI.imprimeTexto("O jogo terminou empatado!");
		} else {
			UI.imprimeTexto("O jogador '" + vencedor.getNome() + "' venceu o jogo!");
		}
		
		board.imprimir();
		UI.imprimeTexto("---FIM DO JOGO---");
	}
	
	private Jogador criaJogador(int indice) {
		String name = UI.lerTextoDigitado("Jogador " + (indice + 1) + " =>");
		char symbol = Constantes.SYMBOL_PLAYER[indice];
		Jogador player = new Jogador(name, board, symbol);
		
		UI.imprimeTexto("O jogador " + name + " vai usar o símbolo '" + symbol +"'");
		
		return player;
	}
	
	private Jogador proximo() {
		indiceJogadorAtual++;
		
		//quando chega no final da fila, recomeça a fila do 0
		if(indiceJogadorAtual >= players.length) {
			indiceJogadorAtual = 0;
		}
		
		return players[indiceJogadorAtual];
		
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
