package lista;

public class Node {
	private Object item;
	private Node prev;
	private Node next;
	
	public Node(Object item) {
		this.item = item;
		prev = null;
		next = null;
	}
	
	public Object getItem() {
		return this.item;
	}
	
	public Node getPrev() {
		return this.prev;
	}
	
	public Node getNext() {
		return this.next;
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