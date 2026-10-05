package sequencia;

public interface Sequencia {
	int size();
	boolean isEmpty();
	void exibirSequencia();
	
	Object elemAtRank(int rank);
	Object replaceAtRank(int rank, Object item);
	void insertAtRank(int rank, Object item);
	Object removeAtRank(int rank);
	
	Position first();
	Position last();
	Position before(Position p);
	Position after(Position p);
	Object replaceElement(Position p, Object item);
	void swapElements(Position p1, Position p2);
	void insertBefore(Position p, Object item);
	void insertAfter(Position p, Object item);
	void insertFirst(Object item);
	void insertLast(Object item);
	Object remove(Position p);
	
	Position atRank(int rank);
	int rankOf(Position p); 
}