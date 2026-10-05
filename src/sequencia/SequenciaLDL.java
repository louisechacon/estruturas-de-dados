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
		return remove(atRank(rank));
	}
	
	// método do goodrich p/ testar se a position é válida
	private Node checkPosition(Position p) {
		if (p == null) {
			throw new InvalidPositionException("Informe uma posição válida!");
		}
		if (p == inicio) {
			throw new InvalidPositionException("Informe uma posição válida!");
		}
		if (p == fim) {
			throw new InvalidPositionException("Informe uma posição válida!");
		}
		try {
			Node temp = (Node) p;
			if (temp.getPrev() == null || temp.getNext() == null) {
				throw new InvalidPositionException("Informe uma posição válida!");
			}
			return temp;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("Informe uma posição válida!");
		}
	}
	
	// métodos de lista
	
	@Override
	public Position first() {
		if (isEmpty()) {
			throw new SequenciaVaziaExcecao("A sequência está vazia!");
		}
		
		return inicio.getNext();
	}
	
	@Override
	public Position last() {
		if (isEmpty()) {
			throw new SequenciaVaziaExcecao("A sequência está vazia!");
		}
		
		return fim.getPrev();
	}
	
	@Override
	public Position before(Position p) {
		Node n = checkPosition(p);
		Node anterior = n.getPrev();
		if (anterior == inicio) {
			throw new IndexOutOfBoundsException("Não há posição antes da primeira!");
		}
		return anterior;
	}
	
	@Override
	public Position after(Position p) {
		Node n = checkPosition(p);
		Node posterior = n.getNext();
		if (posterior == fim) {
			throw new IndexOutOfBoundsException("Não há posição depois da última!");
		}
		return posterior;
	}
	
	@Override
	public Object replaceElement(Position p, Object item) {
		Node n = checkPosition(p);
		Object elemAntigo = n.element();
		n.setItem(item);
		return elemAntigo;
	}
	
	@Override
	public void swapElements(Position p1, Position p2) {
		Node n1 = checkPosition(p1);
		Node n2 = checkPosition(p2);
		Object aux = n1.element();
		n1.setItem(n2.element());
		n2.setItem(aux);
	}
	
	@Override
	public void insertBefore(Position p, Object item) {
		Node n = checkPosition(p);
		Node novoNode = new Node(item);
		Node nodeAnterior = n.getPrev();
		novoNode.setPrev(nodeAnterior);
		novoNode.setNext(n);
		nodeAnterior.setNext(novoNode);
		n.setPrev(novoNode);
		tamanho++;
	}
	
	@Override
	public void insertAfter(Position p, Object item) {
		Node n = checkPosition(p);
		Node novoNode = new Node(item);
		Node nodePosterior = n.getNext();
		novoNode.setPrev(n);
		novoNode.setNext(nodePosterior);
		n.setNext(novoNode);
		nodePosterior.setPrev(novoNode);
		tamanho++;
	}
	
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
	
	@Override
	public Object remove(Position p) {
		Node n = checkPosition(p);
		Node anterior = n.getPrev();
		Node posterior = n.getNext();
		anterior.setNext(posterior);
		posterior.setPrev(anterior);
		tamanho--;
		
		Object elemento = n.element();
		// desconecta a posição da lista e marca-a como inválida
		n.setNext(null);
		n.setPrev(null);
		return elemento;
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