package vector;

public interface Vector {
	Object elemAtRank(int rank);
	Object replaceAtRank(int rank, Object item);
	void insertAtRank(int rank, Object item);
	Object removeAtRank(int rank);
	int size();
	boolean isEmpty();
}
