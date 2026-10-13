package fila;

import fila.filaArrayCircular.FilaArrayCircular;
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
		
		System.out.println("A fila implementada com lista ligada está vazia? " + f1.isEmpty());
		System.out.println("Elementos: ");
		f1.exibirFila();
		System.out.println("Tamanho da fila: " + f1.size() + " elemento(s)");
		System.out.println("");
		
		System.out.println("Invertendo uma FilaArrayCircular A, B, C: ");
		FilaArrayCircular fila = new FilaArrayCircular(10, 0);
		fila.enqueue("A");
		fila.enqueue("B");
		fila.enqueue("C");
		
		fila.inverterFila();
		fila.exibirFila();
		
		System.out.println("Invertendo uma FilaListaLigada A, B, C: ");
		FilaListaLigada fila2 = new FilaListaLigada();
		fila2.enqueue("A");
		fila2.enqueue("B");
		fila2.enqueue("C");
		
		fila2.inverterFila();
		fila2.exibirFila();
	}
}