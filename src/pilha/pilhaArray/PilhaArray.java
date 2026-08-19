package pilha.pilhaArray;

import pilha.Pilha;
import pilha.PilhaVaziaExcecao;

public class PilhaArray implements Pilha {
	private int capacidade;
	private int topo;
	private int fatorCrescimento;
	private Object[] itens;
	
	public PilhaArray(int capacidade, int fatorCrescimento) {
		this.capacidade = capacidade;
		this.topo = -1;
		this.fatorCrescimento = fatorCrescimento;
		if (this.fatorCrescimento <= 0) {
			this.fatorCrescimento = 0;
		}
		itens = new Object[capacidade];
	}

	@Override
	public void push(Object item) {
		if (this.topo >= this.capacidade-1) {
			if (this.fatorCrescimento == 0) {
				this.capacidade *= 2;
			} else {
				this.capacidade += fatorCrescimento;
			}
		
			Object[] novoArray = new Object[this.capacidade];
		
			for (int i = 0; i < itens.length; i++) {
				novoArray[i] = itens[i];
			}
			itens = novoArray;
		}
		itens[++topo] = item;
	}
	
	@Override
	public Object pop() throws PilhaVaziaExcecao {
		if (isEmpty()) {
			throw new PilhaVaziaExcecao("A pilha está vazia!");
		}
		Object itemDoTopo = itens[topo];
		this.topo--;
		return itemDoTopo;
	}
	
	@Override
	public Object top() throws PilhaVaziaExcecao {
		if (isEmpty()) {
			throw new PilhaVaziaExcecao("A pilha está vazia!");
		}
		return itens[topo];
	}
	
	@Override
	public boolean isEmpty() {
		return topo == -1;
	}
	
	@Override
	public int size() {
		return topo + 1;
	}
	
	@Override
	public void exibirPilha() {
		for (int i = 0; i <= topo; i++) {
			System.out.println("" + itens[i]);
		}
	}
}
