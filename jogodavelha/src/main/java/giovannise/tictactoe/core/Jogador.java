package giovannise.tictactoe.core;

import giovannise.tictactoe.UI.UI;

public class Jogador {
	
	private String nome;
	private Tabuleiro tabuleiro;
	private char simbolo;
	
	public Jogador(String nome, Tabuleiro tabuleiro, char simbolo) {
		this.nome = nome;
		this.tabuleiro = tabuleiro;
		this.simbolo = simbolo;
	}

	public String getNome() {
		return nome;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public char getSimbolo() {
		return simbolo;
	}

	//alterado para private pq somente a própria classe jogador pode acessar 
	private Mover movimento() {
		String moveStr = UI.lerTextoDigitado("Jogador '" + nome + "' =>");
		return new Mover(moveStr);
	}
	
	public boolean play() {
		Mover movim = movimento();
		return tabuleiro.play(this, movim);
	}

}
