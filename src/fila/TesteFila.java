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
		
		System.out.println("A fila implementada com lista ligada está vazia? " + f1.isEmpty());
		System.out.println("Elementos: ");
		f1.exibirFila();
		System.out.println("Tamanho da fila: " + f1.size() + " elemento(s)");
	}
}