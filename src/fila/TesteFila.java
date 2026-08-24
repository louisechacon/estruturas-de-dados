package fila;

import fila.filaListaLigada.FilaListaLigada;

public class TesteFila {
	public static void main(String[] args) {
		
		Fila f1 = new FilaListaLigada();
		
		f1.enqueue(5);
		f1.enqueue(3);
		f1.dequeue();
		f1.enqueue(2);
		f1.enqueue(8);
		f1.dequeue();
		f1.dequeue();
		f1.enqueue(9);
		f1.enqueue(1);
		f1.dequeue();
		f1.enqueue(7);
		f1.enqueue(6);
		f1.dequeue();
		f1.dequeue();
		f1.enqueue(4);
		f1.enqueue(7);
		f1.dequeue();
		
		System.out.println(f1.isEmpty());
		f1.exibirFila();
	}
}