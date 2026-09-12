package lista;

// não consegui implementar sem quebrar a interface deixando O(1) 

public class ListaLDL {
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
		
		return inicio.getNext().getItem();
	}
	
	
	public Object last() {
		if (isEmpty()) {
			throw new ListaExcecao("A lista está vazia!");
		}
		
		return fim.getPrev().getItem();
	}
	
	
	public boolean isFirst(Node node) {
		if (isEmpty()) {
			throw new ListaExcecao("A lista está vazia!");
		}
		
		return node == inicio.getNext();
	}
	
	
	public boolean isLast(Node node) {
		if (isEmpty()) {
			throw new ListaExcecao("A lista está vazia!");
		}
		
		return node == fim.getPrev();
	}
	
	
	public Object before(Node node) {
		return node.getPrev().getItem();
	}
	
	
	public Object after(Node node) {
		return node.getNext().getItem();
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
	
	
	public void insertFirst(Object item) {
		Node novoNode = new Node(item);
		Node nodePosterior = inicio.getNext();
		novoNode.setPrev(inicio);
		novoNode.setNext(nodePosterior);
		inicio.setNext(novoNode);
		nodePosterior.setPrev(novoNode);
		tamanho++;
	}
	
	
	public void insertLast(Object item) {
		Node novoNode = new Node(item);
		Node atualUltimo = fim.getPrev();
		novoNode.setPrev(atualUltimo);
		novoNode.setNext(fim);
		atualUltimo.setNext(novoNode);
		fim.setPrev(novoNode);
		tamanho++;
	}
	
	
	public void remove(Node node) {
		if (isEmpty()) {
			throw new ListaExcecao("A lista está vazia!");
		}
		Node nodeAnterior = node.getPrev();
		Node nodePosterior = node.getNext();
		nodeAnterior.setNext(nodePosterior);
		nodePosterior.setPrev(nodeAnterior);
		tamanho--;
	}
	
	
	public void exibirLista() {
		Node atual = inicio.getNext();
		while (atual != fim) {
			System.out.println("" + atual.getItem());
			atual = atual.getNext();
		}
	}
	
	
	public Node search(Object item) {
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