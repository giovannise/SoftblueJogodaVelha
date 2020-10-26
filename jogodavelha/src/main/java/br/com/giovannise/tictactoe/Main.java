package br.com.giovannise.tictactoe;

import giovannise.tictactoe.core.Game;

public class Main {

	public static void main(String[] args) {
		System.out.println("Jogo da Velha");
		
		Game g = new Game();
		
		g.play();
	}

}
