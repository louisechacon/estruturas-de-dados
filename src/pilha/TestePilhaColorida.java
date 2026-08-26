package pilha;

public class TestePilhaColorida {
	public static void main(String[] args) {
		
		PilhaColorida p1 = new PilhaColorida(7);
		
		System.out.println("Capacidade atual do array, que comporta as duas pilhas: ");
		System.out.println(p1.getCapacidade());
		
		p1.pushVermelha(2);
		p1.pushVermelha(10);
		p1.pushVermelha(7);
		p1.pushVermelha(8);
		p1.pushVermelha(1);
		p1.pushPreta(4);
		p1.pushPreta(5);
		
		System.out.println("A pilha vermelha está vazia?: "); // não
		System.out.println(p1.isEmptyVermelha());
		System.out.println("A pilha preta está vazia?: "); // não
		System.out.println(p1.isEmptyPreta());
		
		System.out.println("Tamanho das duas pilhas juntas: ");
		System.out.println(p1.sizePilhas()); // deve retornar 7
		System.out.println("Topo da pilha vermelha: "); // 1
		System.out.println(p1.topVermelha());
		System.out.println("Topo da pilha preta: "); // 5
		System.out.println(p1.topPreta());
		
		p1.pushVermelha(11);
		p1.pushPreta(10);
		System.out.println("Capacidade atual do array, após adicionar novos elementos nas pilhas: ");
		System.out.println(p1.getCapacidade()); // deve ser 14, que é a capacidade do array duplicada
		System.out.println("Novo tamanho da pilha: ");
		System.out.println(p1.sizePilhas()); // e retornar 9 (novo tamanho das duas pilhas juntas)
		System.out.println("Novo topo da pilha vermelha: "); // 11
		System.out.println(p1.topVermelha());
		System.out.println("Novo topo da pilha preta: "); // 10
		System.out.println(p1.topPreta());
		
		p1.popVermelha();
		p1.popVermelha();
		p1.popVermelha();
		p1.popVermelha();
		p1.popVermelha();
		p1.popPreta();
		System.out.println("Novo tamanho das duas pilhas juntas, após remover elementos: ");
		System.out.println(p1.sizePilhas()); // deve retornar 3
		System.out.println("Capacidade atual do array, após retirar elementos das pilhas: "); // deve ser 7, que é o array reduzido pela metade
		System.out.println(p1.getCapacidade());
		
		p1.popVermelha();
		p1.popPreta();
		p1.popPreta();
		System.out.println("Novo tamanho das duas pilhas juntas, após remover mais elementos: ");
		System.out.println(p1.sizePilhas()); // deve retornar 0
		
		System.out.println("A pilha vermelha está vazia?: "); // sim
		System.out.println(p1.isEmptyVermelha());
		System.out.println("A pilha preta está vazia?: "); // sim
		System.out.println(p1.isEmptyPreta());
	}
}
