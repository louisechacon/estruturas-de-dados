package pilha;

public class PilhaColorida {
	private int capacidade;
	private int topoVermelha;
	private int topoPreta;
	private Object[] itens;
	
	public PilhaColorida(int capacidade) {
		this.capacidade = capacidade;
		this.topoVermelha = -1;
		this.topoPreta = capacidade;
		itens = new Object[capacidade];
	}
	
	
	public void pushVermelha(Object item) {
		if (topoVermelha == topoPreta - 1) {
			ajeitaTamanho(capacidade * 2);
		}
	
		itens[++topoVermelha] = item;
	}
	
	
	public void pushPreta(Object item) {
		if (topoPreta == topoVermelha + 1) {
			ajeitaTamanho(capacidade * 2);
		}
		
		itens[--topoPreta] = item;
	}
	
	
	public Object popVermelha() {
		if (isEmptyVermelha()) {
			throw new PilhaVaziaExcecao("A pilha está vazia!");
		}
		
		Object itemTopoVermelha = itens[topoVermelha];
		topoVermelha--;
		
		int tamanhoDuasPilhas = sizeVermelha() + sizePreta();
		if (tamanhoDuasPilhas <= capacidade / 3) {
			ajeitaTamanho(capacidade / 2);
		}
		
		return itemTopoVermelha; 
	}
	
	
	public Object popPreta() {
		if (isEmptyPreta()) {
			throw new PilhaVaziaExcecao("A pilha está vazia!");
		}
		
		Object itemTopoPreta = itens[topoPreta];
		topoPreta++;
		
		int tamanhoDuasPilhas = sizeVermelha() + sizePreta();
		if (tamanhoDuasPilhas <= capacidade / 3) {
			ajeitaTamanho(capacidade / 2);
		}

		return itemTopoPreta;
	}
	
	
	public Object topVermelha() {
		if (isEmptyVermelha()) {
			throw new PilhaVaziaExcecao("A pilha está vazia!");
		}
		
		return itens[topoVermelha]; 
	}
	
	
	public Object topPreta() {
		if (isEmptyPreta()) {
			throw new PilhaVaziaExcecao("A pilha está vazia!");
		}
		
		return itens[topoPreta];
	}
	
	
	public boolean isEmptyVermelha() {
		return topoVermelha == -1;
	}
	
	
	public boolean isEmptyPreta() {
		return topoPreta == capacidade;
	}
	
	
	public int sizeVermelha() {
		return topoVermelha + 1;
	}
	
	
	public int sizePreta() {
		return capacidade - topoPreta;
	} 
	
	
	public int sizePilhas() {
		return sizeVermelha() + sizePreta();
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	
	
	public void ajeitaTamanho(int novaCapacidade) {
		Object[] novoArray = new Object[novaCapacidade];
		
		for (int i = 0; i <= topoVermelha; i++) {
			novoArray[i] = itens[i];
		}
		
		int novoTopoPreta = novaCapacidade - sizePreta();
		int j = novoTopoPreta;
		for (int i = topoPreta; i < capacidade; i++) {
			novoArray[j] = itens[i];
			j++;
		} 
		
		itens = novoArray;
		topoPreta = novoTopoPreta;
		capacidade = novaCapacidade;
	}
}