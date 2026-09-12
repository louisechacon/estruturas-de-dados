package lista;

// não consegui implementar sem quebrar a interface

public class ListaLDL implements Lista {
	private int tamanho;
	private Node inicio;
	private Node fim;
	
	public ListaLDL() {
		tamanho = 0;
		inicio = new Node(null);
		fim = new Node(null);
		inicio.setNext(fim);
		fim.setPrev(inicio);
	}
	
	public int size() {
		return tamanho;
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public Object first() {
		if (isEmpty()) {
			throw new ListaExcecao("A lista está vazia!");
		}
		
		return inicio.getNext();
	}
	
	public Object last() {
		if (isEmpty()) {
			throw new ListaExcecao("A lista está vazia!");
		}
		
		return fim.getPrev();
	}
	
	public boolean isFirst(Node node) {
		if (isEmpty()) {
			throw new ListaExcecao("A lista está vazia!");
		}
		
		return node == first();
	}
	
	public boolean isLast(Node node) {
		if (isEmpty()) {
			throw new ListaExcecao("A lista está vazia!");
		}
		
		return node == last();
	}
	
	public Object before(Node node) {
		return node.getPrev();
	}
	
	public Object after(Node node) {
		return node.getNext();
	}
	
	public Object replaceElement(Node node, Object item) {
		if (isEmpty()) {
			throw new ListaExcecao("A lista está vazia!");
		}
		
		Object aux = node.getItem();
		node.setItem(item);
		return aux;
	}
	
	public void swapElements(Node n, Node m) {
		Object aux = n.getItem();
		n.setItem(m.getItem());
		m.setItem(aux);
	}
	
	public void insertBefore(Node node, Object item) {
		Node novoNode = new Node(item);
		Node nodeAnterior = node.getPrev();
		novoNode.setPrev(nodeAnterior);
		novoNode.setNext(node);
		nodeAnterior.setNext(novoNode);
		node.setPrev(novoNode);
		tamanho++;
	}
	
	public void insertAfter(Node node, Object item) {
		Node novoNode = new Node(item);
		Node nodePosterior = node.getNext();
		novoNode.setPrev(node);
		novoNode.setNext(nodePosterior);
		node.setNext(novoNode);
		nodePosterior.setPrev(novoNode);
		tamanho++;
	}
	
	public void exibirLista() {
		
	}
	
	private Node search(Object item) {
		Node atual = inicio.getNext();
		while (atual != fim) {
			if (atual.getItem().equals(item)) {
				return atual;
			}
			atual = atual.getNext();
		}
		throw new ListaExcecao("Item não encontrado na lista!");
	}
}