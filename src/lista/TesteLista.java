package lista;

public class TesteLista {
	public static void main(String[] args) {
		
		// testes de TAD lista com array
		
		Lista l1 = new ListaArray(3);
		
		System.out.println("Testando TAD lista com array");
		
		l1.insertFirst("A");
		l1.insertLast("C");
		System.out.println("Quem é o primeiro? " + l1.first());
		System.out.println("Quem é o último? " + l1.last());
		System.out.println("Qual o tamanho da lista? " + l1.size());
		System.out.println("A lista está vazia? " + l1.isEmpty());
		System.out.println("A é a primeira letra da lista? " + l1.isFirst("A"));
		System.out.println("C é a última letra da lista? " + l1.isLast("C"));
		System.out.println("Quem vem antes do C? " + l1.before(1));
		System.out.println("Quem vem depois do A? " + l1.after(0));
		
		System.out.println("Mudando C por B...");
		l1.replaceElement(1, "B");
		System.out.println("Mostre a lista: ");
		l1.exibirLista();
		
		System.out.println("Inserindo C depois do B...");
		l1.insertAfter(1, "C");
		System.out.println("Inserindo L antes do A...");
		l1.insertBefore(1, "L");
		System.out.println("Mostre a lista: ");
		l1.exibirLista();
		
		l1.remove(0);
		System.out.println("Removendo o primeiro elemento... ");
		System.out.println("Mostre a lista: ");
		l1.exibirLista();
		
		System.out.println("Trocando as posições de A e C... ");
		l1.swapElements(0, 2);
		System.out.println("Mostre a lista: ");
		l1.exibirLista();
		
		System.out.println("");
		
		
		// testes de TAD lista com lista duplamente ligada
		
		ListaLDL l2 = new ListaLDL();
		
		System.out.println("Testando TAD lista com lista duplamente ligada");
		
		l2.insertFirst("A");
		Node nodeA = l2.search("A");
		System.out.println("Qual o tamanho da lista? " + l2.size());
		System.out.println("A lista está vazia? " + l2.isEmpty());
		System.out.println("Quem é o primeiro? " + l2.first());
		System.out.println("Quem é o último? " + l2.last());
		System.out.println("A é o primeiro? " + l2.isFirst(nodeA));
		System.out.println("A é o último? " + l2.isLast(nodeA));
		
		System.out.println("Inserindo B depois de A...");
		l2.insertAfter(nodeA, "B");
		Node nodeB = l2.search("B");
		System.out.println("Quem vem depois do A? " + l2.after(nodeA));
		System.out.println("Quem vem antes do B? " + l2.before(nodeB));
		System.out.println("Mostre a lista: ");
		l2.exibirLista();

		System.out.println("Mudando B por C...");
		l2.replaceElement(nodeB, "C");
		System.out.println("Mostre a lista: ");
		l2.exibirLista();

		System.out.println("Inserindo L antes do A...");
		l2.insertBefore(nodeA, "L");
		System.out.println("Mostre a lista: ");
		l2.exibirLista();

		l2.remove(nodeA);
		System.out.println("Removendo o A... ");
		System.out.println("Mostre a lista: ");
		l2.exibirLista();

		System.out.println("Trocando as posições de L e C... ");
		Node nodeL = l2.search("L");
		l2.swapElements(nodeL, nodeB);
		System.out.println("Mostre a lista: ");
		l2.exibirLista();
	}
}
