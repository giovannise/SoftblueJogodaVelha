package giovannise.tictactoe.UI;

import br.com.softblue.commons.io.Console;

public class UI {
	
	//se eu coloco static, não preciso de objeto para chamar o método, pois pertence a classe
	//se não colocar static, o método é do objeto, então precisa criar um objeto antes para chamar o método
	
	public static void imprimeTexto(String text) {
		System.out.println(text);
	}
	
	public static void imprimeTextoSemNovaLinha(String text) {
		System.out.print(text);
	}
	
	public static void imprimeNovaLinha() {
		System.out.println();
	}
	
	public static void imprimeTituloDoJogo() {
		imprimeTexto("==================");
		imprimeTexto("| JOGO DA  VELHA |");
		imprimeTexto("==================");
		imprimeNovaLinha();
	}
	
	public static String lerTextoDigitado(String text) {
		imprimeTextoSemNovaLinha(text + " ");
		return Console.readString();
	}

}
