package lista;

public class TesteLista {
	public static void main(String[] args) {
		
		Lista l1 = new ListaArray(3);
		
		l1.insertFirst("A");
		l1.insertLast("C");
		System.out.println("Quem é o primeiro? " + l1.first());
		System.out.println("Quem é o último? " + l1.last());
		System.out.println("Qual o tamanho da lista? " + l1.size());
		System.out.println("A lista está vazia? " + l1.isEmpty());
		
		System.out.println("Quem vem antes do C? " + l1.before(1));
		System.out.println("Quem vem depois do A? " + l1.after(0));
		
		System.out.println("Mudando C por B...");
		l1.replaceElement(1, "B");
		System.out.println("Quem é o último? " + l1.last());
		
		System.out.println("Inserindo C depois do B...");
		l1.insertAfter(1, "C");
		System.out.println("Quem é o último? " + l1.last());
		System.out.println("Inserindo L antes do A...");
		l1.insertBefore(1, "L");
		System.out.println("Quem é o primeiro? " + l1.first());
		System.out.println("Qual o tamanho da lista agora? " + l1.size());
		System.out.println("Mostre a lista: ");
		l1.exibirLista();
		
		l1.remove(0);
		System.out.println("Quem é o primeiro após remover L? " + l1.first());
		System.out.println("Mostre a lista: ");
		l1.exibirLista();
		
		System.out.println("Trocando as posições de A e C... ");
		l1.swapElements(0, 2);
		System.out.println("Mostre a lista: ");
		l1.exibirLista();
		
		System.out.println("Atualmente, C é a primeira letra da lista? " + l1.isFirst("C"));
		System.out.println("Atualmente, A é a última letra da lista? " + l1.isLast("A"));
	}
}
