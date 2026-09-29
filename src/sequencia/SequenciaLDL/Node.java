package sequencia.SequenciaLDL;
import sequencia.Position;

public class Node implements Position {
    private Node next;
    private Node prev;
    private Object item;

    public Node() {
        next = null;
        prev = null;
        item = null;
    }
    
    @Override
	public Object element() {
		return item;
	}

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setElement(Object item) {
        this.item = item;
    }
}