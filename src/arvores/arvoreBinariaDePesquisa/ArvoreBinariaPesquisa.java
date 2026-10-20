package arvores.arvoreBinariaDePesquisa;

public class ArvoreBinariaPesquisa {
	private int tamanho;
	private Node raiz;
	
	public ArvoreBinariaPesquisa() {
		tamanho = 0;
		raiz = null;
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
	
	public boolean isRoot(Node valor) {
		return valor == raiz;
	}
	
	public Node parent(Node valor) {
		return valor.getParent();
	}
	
	public Node leftChild(Node valor) {
		return valor.getLeftChild();
	}
	
	public Node rightChild(Node valor) {
		return valor.getRightChild();
	}
	
	public boolean hasLeft(Node valor) {
		return valor.getLeftChild() != null;
	}
	
	public boolean hasRight(Node valor) {
		return valor.getRightChild() != null;
	}
	
	public boolean isInternal(Node valor) {
		return hasLeft(valor) || hasRight(valor);
	}
	
	public boolean isExternal(Node valor) {
		return !this.isInternal(valor);
	}
	
	private int altura(Node valor) {
		if (valor == null) {
			return -1;
		} else {
			return 1 + Math.max(altura(valor.getLeftChild()), altura((valor.getRightChild())));
		}
	}
	
	public int height() {
		return altura(raiz);
	}
	
	public int depth(Node valor) {
		if (isRoot(valor)) {
			return 0;
		} else {
			return 1 + depth(valor.getParent());
		}
	}
	
	public Node buscar(Object key, Node valor) {
		if (isExternal(valor)) {
			return valor;
		}
		else if ( (int) key < (int) valor.getKey()) {
			if (!hasLeft(valor)) {
				return valor;
			}
			return buscar(key, leftChild(valor));
		}
		else if ( (int) key == (int) valor.getKey()) {
			return valor;
		}
		else {
			if (!hasRight(valor)) {
				return valor;
			}
			return buscar(key, rightChild(valor));
		}
	}
	
	public Node inserir(Object key) {
		if (raiz == null) {
			raiz = new Node(key, null);
			tamanho++;
			return raiz;
		}
		
		Node nodeParent = buscar(key, raiz);
		
		if ( (int) key == (int) nodeParent.getKey()) {
			return nodeParent;
		}
		
		Node novoNode = new Node(key, nodeParent);
		if ( (int) key < (int) nodeParent.getKey()) {
			nodeParent.setLeftChild(novoNode);
			novoNode.setParent(nodeParent);
		}
		else {
			nodeParent.setRightChild(novoNode);
			novoNode.setParent(nodeParent);
		}
		
		tamanho++;
		return novoNode;
	}
	
	public Object remover(Object key) {
		Node node = buscar(key, raiz);
		int qtdFilhos = qtdFilhos(node);
		Node noParent = node.getParent();
		
		if (qtdFilhos == 0) {
			if (noParent == null) {
				raiz = null;
			} else if (noParent.getLeftChild() == node) {
				noParent.setLeftChild(null);
			} else {
				noParent.setRightChild(null);
			}
		}
		
		else if (qtdFilhos == 1) {
			Node child = node.getRightChild();
			if (node.getLeftChild() != null) {
				child = node.getLeftChild();
			}
			
			if (noParent == null) {
				raiz = child;
			} else if (noParent.getLeftChild() == node) {
				noParent.setLeftChild(child);
			} else {
				noParent.setRightChild(child);
			}
			child.setParent(noParent);
		}
		
		else { // se 2 filhos, sucessor é o menor da subárvore direita
			Node sucessor = menorNode(node.getRightChild());
			
			if (sucessor.getParent() != node) {
				sucessor.getParent().setLeftChild(sucessor.getRightChild());
				if (sucessor.getRightChild() != null) {
					sucessor.getRightChild().setParent(sucessor.getParent());
				}
				sucessor.setRightChild(node.getRightChild());
				sucessor.getRightChild().setParent(sucessor);
			}
			
			sucessor.setLeftChild(node.getLeftChild());
			sucessor.getLeftChild().setParent(sucessor);
			
			sucessor.setParent(noParent);
			if (noParent == null) {
				raiz = sucessor;
			} else if (noParent.getLeftChild() == node) {
				noParent.setLeftChild(sucessor);
			} else {
				noParent.setRightChild(sucessor);
			}
		}
		tamanho--;
		return node;
	}
	
	private int qtdFilhos(Node valor) {
		int cont = 0;
		if (hasLeft(valor)) {
			cont++;
		}
		if (hasRight(valor)) {
			cont++;
		}
		return cont;
	}
	
	private Node menorNode(Node valor) {
		while (valor.getLeftChild() != null) {
			valor = valor.getLeftChild();
		}
		return valor;
	}
	
	private int coluna;
	
	public void mostrar() {
		int h = altura(raiz);
		int numLinhas = h + 1;
		int numColunas = tamanho;
		
		Object[][] matriz = new Object[numLinhas][numColunas];
		coluna = 0;
		preencher(raiz, 0, matriz);
		
		for (int i = 0; i < numLinhas; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (matriz[i][j] == null) {
					System.out.print("  ");
				} else {
					System.out.printf("%2s", matriz[i][j]);
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
