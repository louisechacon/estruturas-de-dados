package pilha;

public interface Pilha {
	void push(Object item);
	Object pop() throws PilhaVaziaExcecao;
	Object top() throws PilhaVaziaExcecao;
	int size();
	boolean isEmpty();
}