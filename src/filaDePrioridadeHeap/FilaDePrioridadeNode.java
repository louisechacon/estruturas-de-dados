package filaDePrioridadeHeap;

public class FilaDePrioridadeNode {
	private HeapNode heap;

	public FilaDePrioridadeNode() {
		heap = new HeapNode();
	}

	public void insert(int chave, Object elemento) {
		heap.inserir(chave, elemento);
	}

	public Item removeMin() {
		return heap.removeMin();
	}

	public Item min() {
		return heap.min();
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public void mostrar() {
		heap.mostrar();
	}
}