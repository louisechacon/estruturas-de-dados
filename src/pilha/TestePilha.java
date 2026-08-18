package pilha;

import pilha.pilhaArray.PilhaArray;
import pilha.pilhaListaLigada.PilhaListaLigada;

public class TestePilha {
	public static void main(String[] args) {
		
		PilhaArray p1 = new PilhaArray(100, 0);
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
		
		
		PilhaListaLigada p2 = new PilhaListaLigada();
		p2.push(5);
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
		
		System.out.println(p2.isEmpty());
		p2.exibirPilha();
	}
}