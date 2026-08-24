package pilha;

import pilha.pilhaArray.PilhaArray;
import pilha.pilhaListaLigada.PilhaListaLigada;

public class TestePilha {
	public static void main(String[] args) {
		
		Pilha p1 = new PilhaArray(100, 0);
		p1.push(5);
		p1.push(3);
		p1.pop();
		p1.push(2);
		p1.push(8);
		p1.pop();
		p1.pop();
		p1.push(9);
		p1.push(1);
		p1.pop();
		p1.push(7);
		p1.push(6);
		p1.pop();
		p1.pop();
		p1.push(4);
		p1.pop();
		p1.pop();
		
		System.out.println("A pilha implementada com array está vazia? " + p1.isEmpty());
		System.out.println("Elementos: ");
		p1.exibirPilha();
		System.out.println("Tamanho da pilha: " + p1.size() + " elemento(s)");
		System.out.println();
		
		
		Pilha p2 = new PilhaListaLigada();
		p2.push(5);
		p2.push(3);
		p2.pop();
		p2.push(2);
		p2.push(8);
		p2.pop();
		p2.pop();
		p2.push(9);
		p2.push(1);
		p2.pop();
		p2.push(7);
		p2.push(6);
		p2.pop();
		p2.pop();
		p2.push(4);
		p2.pop();
		p2.pop();
		
		System.out.println("A pilha implementada com lista ligada está vazia? " + p2.isEmpty());
		System.out.println("Elementos: ");
		p2.exibirPilha();
		System.out.println("Tamanho da pilha: " + p2.size() + " elemento(s)");
	}
}