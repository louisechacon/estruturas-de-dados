package vector;

public class VectorArrayCircular implements Vector {
	private Object[] itens;
	private int tamanho;
	private int capacidade;
	private int inicio;
	
	public VectorArrayCircular(int capacidade) {
		this.capacidade = capacidade;
		itens = new Object[capacidade];
		this.tamanho = 0;
		this.inicio = 0;
	}
	
	@Override
	public Object elemAtRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		return itens[(inicio + rank) % capacidade];
	}
	
	@Override
	public Object replaceAtRank(int rank, Object item) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		int indice = (inicio + rank) % capacidade;
		Object elemAntigo = itens[indice];
		itens[indice] = item;
		return elemAntigo;
	}
	
	@Override
	public void insertAtRank(int rank, Object item) {
		if (rank < 0 || rank > tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		if (tamanho == capacidade) {
			int novaCapacidade = capacidade * 2;
			Object[] novoArray = new Object[novaCapacidade];
			
			int inicioVector = inicio;
			for (int i = 0; i < tamanho; i++) {
				novoArray[i] = itens[inicioVector];
				inicioVector = (inicioVector + 1) % capacidade;
			}
			
			capacidade = novaCapacidade;
			inicio = 0;
			itens = novoArray;
		}
		
		for (int i = tamanho; i > rank; i--) {
			int indiceAtual = (inicio + i) % capacidade;
			int indiceAnterior = (inicio + i - 1) % capacidade;
			itens[indiceAtual] = itens[indiceAnterior];
		}
		
		int indiceInserir = (inicio + rank) % capacidade;
		itens[indiceInserir] = item; 
		tamanho++;
	}
	
	@Override
	public Object removeAtRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		int indiceDoRemovido = (inicio + rank) % capacidade;
		Object itemRemovido = itens[indiceDoRemovido];
		
		for (int i = rank; i < tamanho-1; i++) {
			int indiceAtual = (inicio + i) % capacidade;
			int indicePosterior = (inicio + i + 1) % capacidade;
			itens[indiceAtual] = itens[indicePosterior];
		}
		
		tamanho--;
		return itemRemovido;
	}
	
	@Override
	public int size() {
		return tamanho;
	}
	
	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}
}
