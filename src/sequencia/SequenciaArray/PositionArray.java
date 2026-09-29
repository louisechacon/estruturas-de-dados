package sequencia.SequenciaArray;
import sequencia.Position;

public class PositionArray implements Position {
	private Object item; // elemento nessa posição
	private int rank; // posição/índice do elemento na seq
	
	public PositionArray(Object item, int rank) {
		this.item = item;
		this.rank = rank;
	}
	
	@Override
	public Object element() {
		return item;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setItem(Object item) {
		this.item = item;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
}