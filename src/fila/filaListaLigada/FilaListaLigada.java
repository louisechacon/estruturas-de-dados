package fila.filaListaLigada;

import fila.Fila;
import fila.FilaVaziaExcecao;

public class FilaListaLigada implements Fila {
	protected Node head;
	protected Node tail;
	protected int tamanho;
	
	public FilaListaLigada() {
		this.head = null;
		this.tail = null;
		this.tamanho = 0;
	}
	
	@Override
	public void enqueue(Object item) {
		Node node = new Node(item);
		node.setNext(null);
		
		if (tamanho == 0) {
			head = node;
		} else {
			tail.setNext(node);
		}
		
		tail = node;
		tamanho++;
	}
	
	@Override
	public Object dequeue() throws FilaVaziaExcecao {
		if (isEmpty()) {
			throw new FilaVaziaExcecao("A fila está vazia!");
		}
		
		Object itemRetirado = head.getItem();
		head = head.getNext();
		tamanho--;
		
		if (tamanho == 0) {
			tail = null;
		}
		
		return itemRetirado;
	}
}