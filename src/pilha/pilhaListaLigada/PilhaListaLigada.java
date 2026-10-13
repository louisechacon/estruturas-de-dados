package pilha.pilhaListaLigada;

import pilha.Pilha;
import pilha.PilhaVaziaExcecao;
import pilha.pilhaArray.PilhaArray;

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
	
	@Override
	public void exibirPilha() {
		Node atual = topo;
		while (atual != null) {
			System.out.println("" + atual.getItem());
			atual = atual.getNext();
		}
	}
	
	@Override
	/* recebe como parâmetro uma pilha e coloca todos os elementos desta
	pilha no topo da pilha que chamou o método. */
	public void adicionaPilha(Pilha p) {
		Pilha temp1 = new PilhaArray(1, 0);
		Pilha temp2 = new PilhaArray(1, 0);
		
		while (p.size() != 0) {
			Object item = p.pop();
			temp1.push(item);
			temp2.push(item);
		}
		
		while (temp1.size() != 0) {
			this.push(temp1.pop());
		}
		
		while (temp2.size() != 0) {
			p.push(temp2.pop());
		}
	}
	
} // os nós são objetos da classe Node, seguindo a recomendação de Goodrich no livro "Estruturas de dados e algoritmos em java"