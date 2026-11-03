package filaDePrioridadeHeap;

public class Item {
	private int chave;
	private Object elemento;
	
	public Item(int chave, Object elemento) {
		this.chave = chave;
		this.elemento = elemento;
	}
	
	public int getChave() {
		return chave;
	}
	
	public Object getElemento() {
		return elemento;
	}
	
	public String toString() {
		return "(" + chave + ", " + elemento + ")";
	}
}
