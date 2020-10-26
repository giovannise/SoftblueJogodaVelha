package giovannise.tictactoe.core;

public class Mover {
	
	private int i;
	private int j;
	
	public Mover(String moveStr) {
		//vamos receber a posi��o em formato de string. ex: posi��o: "1,2"
		//este construtor vai vai quebrar a string e inserir em um array de 2 posi��es
		//ou seja, vai adicionar o n�mero antes da v�rgula em uma posi��o e p�s v�rgula em outra
		
		//aqui define a v�gula como delimitador de separa��o da string e insere o resultado em um array de String
		//ficar� algo como [ "1" "2" ]
		String[] tokens = moveStr.split(",");
		
		this.i = Integer.parseInt(tokens[0]); //recebe o valor da posi��o 0 do array (no exemplo acima, valor 1)
		this.j = Integer.parseInt(tokens[1]); //recebe o valor da posi��o 1 do array (no exemplo acima, valor 2)
		
		//TODO validar se a estrutura do moveStr est� correta
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}

}
