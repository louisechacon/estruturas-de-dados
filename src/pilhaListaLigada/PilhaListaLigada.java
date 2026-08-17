package pilhaListaLigada;

import pilha.Pilha;
import pilha.PilhaVaziaExcecao;

public class PilhaListaLigada implements Pilha {
	protected Node topo;
	protected int tamanho;
	
	public PilhaListaLigada() {
		this.topo = null;
		this.tamanho = 0;
	}
	
	@Override
	public void push(Object item) {
		Node node = new Node(item);
		node.setNext(this.topo);
		this.topo = node;
		this.tamanho++;
	}
	
	@Override
	public Object pop() {
		if (isEmpty()) {
			throw new PilhaVaziaExcecao("A pilha está vazia!");
		}
		
		Object itemRetirado = this.topo.getItem();
		this.topo = this.topo.getNext();
		this.tamanho--;
		return itemRetirado;
	}
	
	@Override
	public Object top() {
		if (isEmpty()) {
			throw new PilhaVaziaExcecao("A pilha está vazia!");
		}
		
		return this.topo.getItem();
	}
	
	@Override
	public boolean isEmpty() {
		return this.topo == null;
	}
	
	@Override
	public int size() {
		return this.tamanho;
	}
	
} // os nós são objetos da classe Node, seguindo a recomendação de Goodrich no livro "Estruturas de dados e algoritmos em java"