package sequencia;
import vector.IndexOutOfBoundsException;

public class SequenciaLDL implements Sequencia {
	private int tamanho;
	private Node inicio;
	private Node fim;
	
	public SequenciaLDL() {
		tamanho = 0;
		inicio = new Node(null);
		fim = new Node(null);
		inicio.setNext(fim);
		fim.setPrev(inicio);
	}
	

	private class Node implements Position {
		private Object item;
		private Node prev;
		private Node next;
		
		public Node(Object item) {
			this.item = item;
			prev = null;
			next = null;
		}
		
		@Override
		public Object element() {
			return item;
		}
		
		public Node getPrev() {
			return prev;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setItem(Object item) {
			this.item = item;
		}
		
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	// métodos ponte
	
	@Override
	public Position atRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		Node atual = inicio.getNext();
		for (int i = 0; i < rank; i++) {
			atual = atual.getNext();
		}
		
		return atual;
	}
	
	@Override
	public int rankOf(Position n) {
		Node atual = inicio.getNext();
		int rank = 0;
		
		while (atual != fim) {
			if (atual == n) {
				return rank;
			}
			atual = atual.getNext();
			rank++;
		}
		
		throw new InvalidPositionException("Informe uma posição válida!");
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
		
		Node atual = inicio.getNext();
		for (int i = 0; i < rank; i++) {
			atual = atual.getNext();
		}
		
		Object aux = atual.element();
		atual.setItem(item);
		return aux;
	}
	
	@Override
	public void insertAtRank(int rank, Object item) {
		if (rank < 0 || rank > tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		Node node = new Node(item);
		Node nodeAtual = inicio.getNext();
		
		for (int i = 0; i < rank; i++) {
			nodeAtual = nodeAtual.getNext();
		}
		
		Node nodeAnterior = nodeAtual.getPrev();
		
		node.setPrev(nodeAnterior);
		node.setNext(nodeAtual);
		nodeAnterior.setNext(node);
		nodeAtual.setPrev(node); 
		
		tamanho++;
	}
	
	@Override
	public Object removeAtRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		Node nodeAntigo = inicio.getNext();
		
		for (int i = 0; i < rank; i++) {
			nodeAntigo = nodeAntigo.getNext();
		}
		
		Object elemEmRank = nodeAntigo.element();
		
		Node nodeAnterior = nodeAntigo.getPrev(); 
		Node nodePosterior = nodeAntigo.getNext();
		nodeAnterior.setNext(nodePosterior);
		nodePosterior.setPrev(nodeAnterior);
		
		tamanho--;
		return elemEmRank;
	}
	
	// métodos de lista
	@Override
	public void insertFirst(Object item) {
		Node novoNode = new Node(item);
		Node nodePosterior = inicio.getNext();
		novoNode.setPrev(inicio);
		novoNode.setNext(nodePosterior);
		inicio.setNext(novoNode);
		nodePosterior.setPrev(novoNode);
		tamanho++;
	}
	
	@Override
	public void insertLast(Object item) {
		Node novoNode = new Node(item);
		Node atualUltimo = fim.getPrev();
		novoNode.setPrev(atualUltimo);
		novoNode.setNext(fim);
		atualUltimo.setNext(novoNode);
		fim.setPrev(novoNode);
		tamanho++;
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
		Node atual = inicio.getNext();
		while (atual != fim) {
			System.out.println("" + atual.element());
			atual = atual.getNext();
		}
	}
}