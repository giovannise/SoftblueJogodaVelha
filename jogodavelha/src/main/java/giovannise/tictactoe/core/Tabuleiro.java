package giovannise.tictactoe.core;

import giovannise.tictactoe.Constantes;
import giovannise.tictactoe.UI.UI;

public class Tabuleiro {
	
	private char[][] matriz;
	
	public Tabuleiro() {
		matriz = new char[Constantes.BOARD_SIZE][Constantes.BOARD_SIZE];
		limpar();
	}
	
	//percorre o array "limpando" os símbolos e inserindo espaços em branco
	public void limpar() {
		for (int i=0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = ' ';
			}
		}
	}
	
	public void imprimir() {
		UI.imprimeNovaLinha();
		
		//percorre a matriz imprimindo o Símbolo + pipe + linha tracejada
		for (int i=0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				UI.imprimeTextoSemNovaLinha(String.valueOf(matriz[i][j]));
				
				//se for a última coluna (coluna 3), não imprime o pipe
				if (j < matriz[i].length - 1) {
					UI.imprimeTextoSemNovaLinha(" | ");
				}
			}
			
			//quebra de linha após preenchimento da linha atual
			UI.imprimeNovaLinha();
			
			//se for a última linha (linha 3) não imprime a linha tracejada
			if (i < matriz.length - 1) {
				UI.imprimeTexto("---------");
			}
		}
	}
	
	//valida se o tabuleiro está cheio
	public boolean cheio() {
		for (int i=0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean play(Jogador player, Mover movimento) {
		int i = movimento.getI();
		int j = movimento.getJ();
		
		//TODO validar os movimentos
		
		matriz[i][j] = player.getSimbolo();
		
		//essa anotação abaixo serve como marcação para criar tasks para não esquecer.
		//para visualizar = Window > Show View > Tasks
		//TODO checar se o jogador ganhou
		//apagar após realizar a task, mas vou deixar aqui para fins de anotação.
		
		//retorna true se ganhou e false se ainda está jogando
		//retorna true e um deles for true, somente retorna false se TODOS foram false
		return checkLinhaS(player) || checkColunaS(player) || checkDiagonal1(player) || checkDiagonal2(player);
	}
	
	private boolean checkLinha(int i, Jogador player) {
		char simbolo = player.getSimbolo();
		
		for(int j = 0; j < Constantes.BOARD_SIZE; j++) {
			if(matriz[i][j]!= simbolo) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkLinhaS(Jogador player) {
		for(int i = 0; i < Constantes.BOARD_SIZE; i++) {
			if(checkLinha(i, player)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean checkColuna(int j, Jogador player) {
		char simbolo = player.getSimbolo();
		
		for(int i = 0; i < Constantes.BOARD_SIZE; i++) {
			if(matriz[i][j]!= simbolo) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkColunaS(Jogador player) {
		for(int j = 0; j < Constantes.BOARD_SIZE; j++) {
			if(checkLinha(j, player)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkDiagonal1(Jogador player) {
		char simbolo = player.getSimbolo();

		for(int i = 0; i < Constantes.BOARD_SIZE; i++) {
			//valida as posições 0 e 0, 1 e 1, 2 e 2 para validar se o simbolo está lá
			if(matriz[i][i] != simbolo) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkDiagonal2(Jogador player) {
		char simbolo = player.getSimbolo();
		int ultimaLinha = Constantes.BOARD_SIZE - 1; 
		
		for(int i = ultimaLinha, j = 0; i >= 0; i--, j++) {
			if (matriz[i][j] != simbolo) {
				return false;
			}
		}
		
		return true;
	}
}
