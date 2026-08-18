package fila;

public interface Fila {
	void enqueue(Object item);
	Object dequeue() throws FilaVaziaExcecao;
	Object first() throws FilaVaziaExcecao;
	int size();
	boolean isEmpty();
}