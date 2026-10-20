package arvores.arvoreBinariaDePesquisa;

public class Node {
	private Object key;
	private Node parent;
	private Node rightChild;
	private Node leftChild;
	
	public Node (Object key, Node parent) {
		this.key = key;
		this.parent = parent;
		this.rightChild = null;
		this.leftChild = null;
	}
	
	public Object getKey() {
		return key;
	}
	
	public void setKey(Object chave) {
		key = chave;
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
}
