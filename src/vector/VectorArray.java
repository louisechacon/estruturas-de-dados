package vector;

public class VectorArray implements Vector {
	private Object[] itens;
	private int tamanho;
	private int capacidade;
	
	public VectorArray(int capacidade) {
		this.capacidade = capacidade;
		itens = new Object[capacidade];
		this.tamanho = 0;
	}
	
	@Override
	public Object elemAtRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		return itens[rank]; 
	}
	
	@Override
	public Object replaceAtRank(int rank, Object item) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		Object elemAntigo = itens[rank];
		itens[rank] = item;
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
			
			for (int i = 0; i < tamanho; i++) {
				novoArray[i] = itens[i];
			}
			
			itens = novoArray;
			capacidade = novaCapacidade;
		}
		
		for (int i = tamanho; i > rank; i--) {
			itens[i] = itens[i - 1];
		}
		
		itens[rank] = item; 
		tamanho++;
	}
	
	@Override
	public Object removeAtRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		Object itemRemovido = itens[rank];
		
		for (int i = rank; i < tamanho-1; i++) {
			itens[i] = itens[i + 1];
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
	
	@Override
	public void exibirVector() {
		for (int i = 0; i < tamanho; i++) {
			System.out.println("" + itens[i]);
		}
	}
}
