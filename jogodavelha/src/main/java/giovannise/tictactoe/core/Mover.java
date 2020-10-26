package giovannise.tictactoe.core;

public class Mover {
	
	private int i;
	private int j;
	
	public Mover(String moveStr) {
		//vamos receber a posição em formato de string. ex: posição: "1,2"
		//este construtor vai vai quebrar a string e inserir em um array de 2 posições
		//ou seja, vai adicionar o número antes da vírgula em uma posição e pós vírgula em outra
		
		//aqui define a vígula como delimitador de separação da string e insere o resultado em um array de String
		//ficará algo como [ "1" "2" ]
		String[] tokens = moveStr.split(",");
		
		this.i = Integer.parseInt(tokens[0]); //recebe o valor da posição 0 do array (no exemplo acima, valor 1)
		this.j = Integer.parseInt(tokens[1]); //recebe o valor da posição 1 do array (no exemplo acima, valor 2)
		
		//TODO validar se a estrutura do moveStr está correta
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}

}
