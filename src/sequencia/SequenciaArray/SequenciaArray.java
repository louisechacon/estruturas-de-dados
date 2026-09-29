package sequencia.SequenciaArray;
import sequencia.Sequencia;
import sequencia.Position;
import vector.IndexOutOfBoundsException;
import sequencia.SequenciaVaziaExcecao;
import sequencia.InvalidPositionException;

public class SequenciaArray implements Sequencia {
	private int tamanho;
	private int capacidade;
	private PositionArray[] itens;
	
	public SequenciaArray(int capacidade) {
		this.capacidade = capacidade;
		itens = new PositionArray[capacidade];
		tamanho = 0;
		
	}
	
	@Override
	public Position atRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		return itens[rank];
	}
	
	@Override
	public int rankOf(Position node) {
		PositionArray pos = (PositionArray) node;
		int rank = pos.getRank();
		
		if (rank < 0 || rank >= tamanho || itens[rank] != pos) {
			throw new InvalidPositionException("Informe uma posição válida!");
		}
		
		return rank;
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
	public Object elemAtRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		return atRank(rank).element(); 
	}
	
	@Override
	public Object replaceAtRank(int rank, Object item) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		Object elemAntigo = itens[rank].element();
		itens[rank].setItem(item);
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
			itens[i].setRank(i);
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
			itens[i].setRank(i);
		}
		
		tamanho--;
		return itemRemovido;
	}
	
	
	@Override
	public Object first() {
		if (isEmpty()) {
			throw new SequenciaVaziaExcecao("A sequencia está vazia!");
		}
		
		return itens[0].element();
	}
	
	@Override
	public Object last() {
		if (isEmpty()) {
			throw new SequenciaVaziaExcecao("A sequencia está vazia!");
		}
		
		return itens[tamanho-1].element();
	}
	
	@Override
	public Object before(Position node) {
		int rank = rankOf(node);
		
		if (rank == 0) {
			throw new InvalidPositionException("Informe uma posição válida!");
		}
		
		return atRank(rank - 1).element();
	}
	
	@Override
	public Object after(Position node) {
		int rank = rankOf(node);
		
		if (rank == tamanho-1) {
			throw new InvalidPositionException("Informe uma posição válida!");
		}
		
		return atRank(rank + 1).element();
	}
	
	@Override
	public Object replaceElement(Position node, Object item) {
		int rank = rankOf(node);
		PositionArray pos = (PositionArray) atRank(rank);
		Object elemAntigo = pos.element();
		pos.setItem(item);
		return elemAntigo;
	}
	
	@Override
	public void swapElements(Position node1, Position node2) {
		int rank1 = rankOf(node1);
		int rank2 = rankOf(node2);
		
		PositionArray pos1 = (PositionArray) atRank(rank1);
		PositionArray pos2 = (PositionArray) atRank(rank2);
		
		Object aux = pos1.element();
		pos1.setItem(pos2.element());
		pos2.setItem(aux);
	}
	
	@Override
	public void insertBefore(Position node, Object item) {
		int rank = rankOf(node);
		insertAtRank(rank, item);
	}
	
	@Override
	public void insertAfter(Position node, Object item) {
		int rank = rankOf(node);
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
	public void remove(Position node) {
		int rank = rankOf(node);
		removeAtRank(rank);
	}
	
}
