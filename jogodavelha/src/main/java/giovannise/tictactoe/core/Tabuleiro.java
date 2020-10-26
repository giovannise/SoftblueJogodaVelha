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
		
		matriz[i][j] = player.getSimbolo();
		
		//essa anotação abaixo serve como marcação para criar tasks para não esquecer.
		//para visualizar = Window > Show View > Tasks
		//TODO checar se o jogador ganhou
		
		return false;
	}

}
