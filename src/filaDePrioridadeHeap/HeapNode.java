package filaDePrioridadeHeap;

public class HeapNode {
	private Node raiz;
	private Node ultimoNo;
	private int tamanho;
	
	public HeapNode() {
		raiz = null;
		ultimoNo = null;
		tamanho = 0;
	}
	
	public int size() {
		return tamanho;
	}
	
	public boolean isEmpty() {
		return raiz == null;
	}
	
	public Node root() {
		return raiz;
	}
	
	private boolean isRoot(Node no) {
		return no == raiz;
	}
	
	public Item min() {
		return new Item(raiz.getKey(), raiz.getElement());
	}
	
	public void inserir(int chave, Object elemento) {
		if (raiz == null) {
			raiz = new Node(chave, elemento, null);
			ultimoNo = raiz;
			tamanho = 1;
			return;
		}
		
		Node paiDoNovoNo = buscarPaiDoNovoNo();
		Node novoNo = new Node(chave, elemento, paiDoNovoNo);
		
		if (paiDoNovoNo.getLeftChild() == null) {
			paiDoNovoNo.setLeftChild(novoNo);
		} else {
			paiDoNovoNo.setRightChild(novoNo);
		}
		
		upHeap(novoNo);
		ultimoNo = novoNo;
		tamanho++;
	}
	
	private Node buscarPaiDoNovoNo() {
		Node atual = ultimoNo;
		
		if (isRoot(atual)) {
			return atual;
		}
		
		// enquanto nao for raiz e for filho direito, sobe p/ o pai
		while (!isRoot(atual) && atual.getParent().getRightChild() == atual) {
			atual = atual.getParent();
		}
		// se nao for raiz e o pai nao tiver filho direito, tem lugar
		if (!isRoot(atual) && atual.getParent().getRightChild() == null) {
			return atual.getParent();
		}
		// tem irmao direito, va p/ ele
		if (!isRoot(atual)) {
			atual = atual.getParent().getRightChild();
		}
		while (atual.getLeftChild() != null) {
			atual = atual.getLeftChild();
		}
		return atual;
	}
	
	private void upHeap(Node node) {
		while (!isRoot(node) && node.getKey() < node.getParent().getKey()) {
			Node pai = node.getParent();
			int chaveAux = node.getKey();
			Object elemAux = node.getElement();
			
			node.setKey(pai.getKey());
			node.setElement(pai.getElement());
			pai.setKey(chaveAux);
			pai.setElement(elemAux);
			node = pai;
		}
	}
	
	public Item removeMin() {
		Item menor = new Item(raiz.getKey(), raiz.getElement());
		
		int chaveAux = raiz.getKey();
		Object elemAux = raiz.getElement();
		raiz.setKey(ultimoNo.getKey());
		raiz.setElement(ultimoNo.getElement());
		ultimoNo.setKey(chaveAux);
		ultimoNo.setElement(elemAux);
		
		Node novoUltimoNo = novoUltimoNo();
		if (ultimoNo.getParent().getRightChild() == null) {
			ultimoNo.getParent().setLeftChild(null);
		} else {
			ultimoNo.getParent().setRightChild(null);
		}
		
		downHeap(raiz);
		tamanho--;
		ultimoNo = novoUltimoNo;
		return menor;
	}
	
	private Node novoUltimoNo() {
		Node atual = ultimoNo;
		
		if (isRoot(atual)) {
			return atual;
		}
		
		while (!isRoot(atual) && atual.getParent().getLeftChild() == atual) {
			atual = atual.getParent();
		}
		
		if (!isRoot(atual)) {
			atual = atual.getParent().getLeftChild();
		}
		
		while (atual.getRightChild() != null) {
			atual = atual.getRightChild();
		}
		
		return atual;
	}
	
	private void downHeap(Node node) {
		Node leftChild = node.getLeftChild();
		Node rightChild = node.getRightChild();
		Node menor = node;
		
		if (node.hasLeft() && leftChild.getKey() < menor.getKey()) {
			menor = leftChild;
		}
		
		if (node.hasRight() && rightChild.getKey() < menor.getKey()) {
			menor = rightChild;
		}
		
		if (menor != node) {
			int chaveAux = node.getKey();
			Object elemAux = node.getElement();
			node.setKey(menor.getKey());
			node.setElement(menor.getElement());
			menor.setKey(chaveAux);
			menor.setElement(elemAux);
			downHeap(menor);
		}
	}
	
	private int coluna;
	
	private int altura(Node node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(altura(node.getLeftChild()), altura(node.getRightChild()));
	}
	
	public void mostrar() {
		int h = altura(raiz);
		int numLinhas = h + 1;
		int numColunas = tamanho;

		Object[][] matriz = new Object[numLinhas][numColunas];
		coluna = 0;
		preencher(raiz, 0, matriz);
		
		for (int i = 0; i < numLinhas; i++) {
			for (int j = 0; j < numColunas; j++) {
				if (matriz[i][j] == null) {
					System.out.print("   ");
				} else {
					System.out.printf("%3s", matriz[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	private void preencher(Node node, int linha, Object[][] tabela) {
		if (node == null) {
			return;
		}

		preencher(node.getLeftChild(), linha + 1, tabela);
		tabela[linha][coluna] = node.getKey();
		coluna++;
		preencher(node.getRightChild(), linha + 1, tabela);
	}
}
