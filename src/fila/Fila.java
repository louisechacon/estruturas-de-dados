package fila;

public interface Fila {
	public void enqueue(Object item);
	public Object dequeue() throws FilaVaziaExcecao;
	public Object first() throws FilaVaziaExcecao;
	public int size();
	public boolean isEmpty();
}
