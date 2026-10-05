package sequencia;
import vector.IndexOutOfBoundsException;

public class SequenciaArray implements Sequencia {
	private int tamanho;
	private int capacidade;
	private PositionArray[] itens;
	
	public SequenciaArray(int capacidade) {
		this.capacidade = capacidade;
		itens = new PositionArray[capacidade];
		tamanho = 0;
		
	}
	
	private class PositionArray implements Position {
		private Object item;
		private int rank;
		
		public PositionArray(Object item, int rank) {
			this.item = item;
			this.rank = rank;
		}
		
		@Override
		public Object element() {
			return item;
		}
	}
	
	// métodos ponte
	
	@Override
	public Position atRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		return itens[rank];
	}
	
	@Override
	public int rankOf(Position p) {
		PositionArray pos = (PositionArray) p;
		
		if (pos.rank < 0 || pos.rank >= tamanho || itens[pos.rank] != pos) {
			throw new InvalidPositionException("Informe uma posição válida!");
		}
		
		return pos.rank;
	}
	
	// métodos de vector
	
	@Override
	public Object elemAtRank(int rank) {
		return atRank(rank).element(); 
	}
	
	@Override
	public Object replaceAtRank(int rank, Object item) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		Object elemAntigo = itens[rank].element();
		itens[rank].item = item;
		return elemAntigo;
	}
	
	@Override
	public void insertAtRank(int rank, Object item) {
		if (rank < 0 || rank > tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		if (tamanho == capacidade) {
			int novaCapacidade = capacidade * 2;
			PositionArray[] novoArray = new PositionArray[novaCapacidade];
			
			for (int i = 0; i < tamanho; i++) {
				novoArray[i] = itens[i];
			}
			
			itens = novoArray;
			capacidade = novaCapacidade;
		}
		
		for (int i = tamanho; i > rank; i--) {
			itens[i] = itens[i - 1];
			itens[i].rank = i;
		}
		
		itens[rank] = new PositionArray(item, rank); 
		tamanho++;
	}
	
	@Override
	public Object removeAtRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		Object itemRemovido = itens[rank].element();
		
		for (int i = rank; i < tamanho-1; i++) {
			itens[i] = itens[i + 1];
			itens[i].rank = i;
		}
		
		tamanho--;
		return itemRemovido;
	}
	
	// métodos de lista
	
	@Override
	public Position first() {
		if (isEmpty()) {
			throw new SequenciaVaziaExcecao("A sequencia está vazia!");
		}
		
		return itens[0];
	}
	
	@Override
	public Position last() {
		if (isEmpty()) {
			throw new SequenciaVaziaExcecao("A sequencia está vazia!");
		}
		
		return itens[tamanho-1];
	}
	
	@Override
	public Position before(Position p) {
		int rank = rankOf(p);
		
		if (rank == 0) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		return itens[rank - 1];
	}
	
	@Override
	public Position after(Position p) {
		int rank = rankOf(p);
		
		if (rank == tamanho-1) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		return itens[rank + 1];
	}
	
	@Override
	public Object replaceElement(Position p, Object item) {
		int rank = rankOf(p);
		return replaceAtRank(rank, item);
	}
	
	@Override
	public void swapElements(Position p1, Position p2) {
		int rank1 = rankOf(p1);
		int rank2 = rankOf(p2);
		
		Object aux = elemAtRank(rank1);
		replaceAtRank(rank1, elemAtRank(rank2));
		replaceAtRank(rank2, aux);
	}
	
	@Override
	public void insertBefore(Position p, Object item) {
		int rank = rankOf(p);
		insertAtRank(rank, item);
	}
	
	@Override
	public void insertAfter(Position p, Object item) {
		int rank = rankOf(p);
		insertAtRank(rank + 1, item);
	}
	
	@Override
	public void insertFirst(Object item) {
		insertAtRank(0, item);
	}
	
	@Override
	public void insertLast(Object item) {
		insertAtRank(tamanho, item);
	}
	
	@Override
	public Object remove(Position p) {
		int rank = rankOf(p);
		return removeAtRank(rank);
	}
	
	// métodos genéricos
	
	@Override
	public int size() {
		return tamanho;
	}
		
	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}
		
	@Override
	public void exibirSequencia() {
		for (int i = 0; i < tamanho; i++) {
			System.out.println("" + itens[i].element());
		}
	}
} 
