package sequencia;

public interface Sequencia {
	int size();
	boolean isEmpty();
	void exibirSequencia();
	
	Object elemAtRank(int rank);
	Object replaceAtRank(int rank, Object item);
	void insertAtRank(int rank, Object item);
	Object removeAtRank(int rank);
	
	Object first();
	Object last();
	Object before(Position node);
	Object after(Position node);
	Object replaceElement(Position node, Object item);
	void swapElements(Position node1, Position node2);
	void insertBefore(Position node, Object item);
	void insertAfter(Position node, Object item);
	void insertFirst(Object item);
	void insertLast(Object item);
	Object remove(Position node);
	
	Position atRank(int rank);
	int rankOf(Position node);
}