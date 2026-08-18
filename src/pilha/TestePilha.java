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
		
		System.out.println(p1.isEmpty());
		p1.exibirPilha();
		
		
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
		
		System.out.println(p2.isEmpty());
		p2.exibirPilha();
	}
}