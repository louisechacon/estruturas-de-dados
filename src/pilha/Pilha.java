package pilha;

public interface Pilha {
	public void push(Object item);
	public Object pop() throws PilhaVaziaExcecao;
	public Object top() throws PilhaVaziaExcecao;
	public int size();
	public boolean isEmpty();
}
