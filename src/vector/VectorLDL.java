package vector;

public class VectorLDL implements Vector {
	private int tamanho;
	private Node inicio;
	private Node fim;
	
	public VectorLDL() {
		tamanho = 0;
		inicio = new Node(null);
		fim = new Node(null);
		inicio.setNext(fim);
		fim.setPrev(inicio);
	}
	
	
	@Override
	public Object elemAtRank(int rank) {
		if (rank < 0 || rank >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma colocação válida!");
		}
		
		Node atual = inicio.getNext();
		for (int i = 0; i < rank; i++) {
			atual = atual.getNext();
		}
		
		return atual.getItem();
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
		
		Object aux = atual.getItem();
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
		
		node.setPrev(nodeAtual.getPrev());
		node.setNext(nodeAtual);
		Node nodeAnterior = nodeAtual.getPrev();
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
		
		Object elemEmRank = nodeAntigo.getItem();
		
		Node nodeAnterior = nodeAntigo.getPrev(); 
		Node nodePosterior = nodeAntigo.getNext();
		nodeAnterior.setNext(nodePosterior);
		nodePosterior.setPrev(nodeAnterior);
		
		tamanho--;
		return elemEmRank;
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
		Node atual = inicio.getNext();
		while (atual != fim) {
			System.out.println("" + atual.getItem());
			atual = atual.getNext();
		}
	}
	
	// Goodrich diz em "Estruturas de dados e algoritmos em Java" que, numa lista vazia, os nós sentinelas apontam um p/ o outro
}
