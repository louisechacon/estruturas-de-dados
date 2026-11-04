package filaDePrioridadeHeap;

public class Node {
	private int key;
	private Object element;
	private Node parent;
	private Node rightChild;
	private Node leftChild;

	public Node(int key, Object element, Node parent) {
		this.key = key;
		this.element = element;
		this.parent = parent;
		this.rightChild = null;
		this.leftChild = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int chave) {
		key = chave;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object elemento) {
		element = elemento;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node pai) {
		parent = pai;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node filhoDireito) {
		rightChild = filhoDireito;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node filhoEsquerdo) {
		leftChild = filhoEsquerdo;
	}

	public boolean hasLeft() {
		return leftChild != null;
	}

	public boolean hasRight() {
		return rightChild != null;
	}

	public boolean isInternal() {
		return hasLeft() || hasRight();
	}

	public boolean isExternal() {
		return !this.isInternal();
	}
}