package vector;

public class TesteVector {
	public static void main(String[] args) {
		
		// testes de vector com array
		
		Vector v1 = new VectorArray(5);
		System.out.println("Testando vetor com array");
		System.out.println("O vetor está vazio? " + v1.isEmpty());
		System.out.println("Qual o tamanho do vetor? " + v1.size());
		
		System.out.println("Inserindo elementos... ");
		
		v1.insertAtRank(0, "A");
		v1.insertAtRank(1, "B");
		v1.insertAtRank(2, "C");
		v1.insertAtRank(3, "D");
		v1.insertAtRank(4, "E");
		
		System.out.println("O vetor está vazio? " + v1.isEmpty());
		System.out.println("Qual o tamanho do vetor? " + v1.size());
		System.out.println("Elementos: ");
		v1.exibirVector();
		
		System.out.println("Qual o elemento na colocação zero? " + v1.elemAtRank(0));
		
		System.out.println("Trocando letra 'E' por letra 'L'... ");
		v1.replaceAtRank(4, "L");
		System.out.println("Como está o vetor agora?");
		v1.exibirVector();
		
		System.out.println("Inserindo um novo elemento no vetor...");
		v1.insertAtRank(0, "L");
		System.out.println("Como ficou o vetor após inserir um novo 'L'?");
		v1.exibirVector();
		System.out.println("Qual o tamanho do vetor agora? " + v1.size());
		
		System.out.println("Removendo todos os L's...");
		v1.removeAtRank(5);
		v1.removeAtRank(0);
		System.out.println("Como ficou o vetor afinal?");
		v1.exibirVector();
		System.out.println("O vetor está vazio? " + v1.isEmpty());
		System.out.println("Qual o tamanho final do vetor? " + v1.size());
		System.out.println("");
		
		
		// testes de vector com lista duplamente ligada
		
		Vector v2 = new VectorLDL();
		System.out.println("Testando vetor com lista duplamente encadeada");
		System.out.println("O vetor está vazio? " + v2.isEmpty());
		System.out.println("Qual o tamanho do vetor? " + v2.size());

		System.out.println("Inserindo elementos... ");

		v2.insertAtRank(0, "F");
		v2.insertAtRank(1, "G");
		v2.insertAtRank(2, "H");
		v2.insertAtRank(3, "I");
		v2.insertAtRank(4, "J");

		System.out.println("O vetor está vazio? " + v2.isEmpty());
		System.out.println("Qual o tamanho do vetor? " + v2.size());
		System.out.println("Elementos: ");
		v2.exibirVector();

		System.out.println("Qual o elemento na colocação zero? " + v2.elemAtRank(0));

		System.out.println("Trocando letra 'J' por letra 'L'... ");
		v2.replaceAtRank(4, "L");
		System.out.println("Como está o vetor agora?");
		v2.exibirVector();

		System.out.println("Inserindo um novo elemento no vetor...");
		v2.insertAtRank(0, "L");
		System.out.println("Como ficou o vetor após inserir um novo 'L'?");
		v2.exibirVector();
		System.out.println("Qual o tamanho do vetor agora? " + v2.size());

		System.out.println("Removendo todos os L's...");
		v2.removeAtRank(5);
		v2.removeAtRank(0);
		System.out.println("Como ficou o vetor afinal?");
		v2.exibirVector();
		System.out.println("O vetor está vazio? " + v2.isEmpty());
		System.out.println("Qual o tamanho final do vetor? " + v2.size());
	}
}
