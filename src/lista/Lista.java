package lista;

public interface Lista {
	int size();
	boolean isEmpty();
	boolean isFirst(Object item);
	boolean isLast(Object item);
	Object first();
	Object last();
	Object before(int n);
	Object after(int n);
	Object replaceElement(int n, Object item);
	void swapElements(int n, int m);
	void insertBefore(int n, Object item);
	void insertAfter(int n, Object item);
	void insertFirst(Object item);
	void insertLast(Object item);
	void remove(int n);
}