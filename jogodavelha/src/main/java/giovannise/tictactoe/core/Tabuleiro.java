package giovannise.tictactoe.core;

import giovannise.tictactoe.Constantes;
import giovannise.tictactoe.UI.UI;

public class Tabuleiro {
	
	char[][] matriz;
	
	public Tabuleiro() {
		matriz = new char[Constantes.BOARD_SIZE][Constantes.BOARD_SIZE];
		limpar();
	}
	
	//percorre o array "limpando" os s�mbolos e inserindo espa�os em branco
	public void limpar() {
		for (int i=0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = ' ';
			}
		}
	}
	
	public void imprimir() {
		UI.imprimeNovaLinha();
		
		//percorre a matriz imprimindo o S�mbolo + pipe + linha tracejada
		for (int i=0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				UI.imprimeTextoSemNovaLinha(String.valueOf(matriz[i][j]));
				
				//se for a �ltima coluna (coluna 3), n�o imprime o pipe
				if (j < matriz[i].length - 1) {
					UI.imprimeTextoSemNovaLinha(" | ");
				}
			}
			
			//quebra de linha ap�s preenchimento da linha atual
			UI.imprimeNovaLinha();
			
			//se for a �ltima linha (linha 3) n�o imprime a linha tracejada
			if (i < matriz.length - 1) {
				UI.imprimeTexto("---------");
			}
		}
	}
	
	//valida se o tabuleiro est� cheio
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
		int i = movimento.i;
		int j = movimento.j;
		
		matriz[i][j] = player.simbolo;
		
		//essa anota��o abaixo serve como marca��o para criar tasks para n�o esquecer.
		//para visualizar = Window > Show View > Tasks
		//TODO checar se o jogador ganhou
		
		return false;
	}

}
