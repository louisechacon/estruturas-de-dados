package filaDePrioridadeHeap;

public class FilaDePrioridade {
	private HeapArray heap;
	
	public FilaDePrioridade(int capacidade) {
		heap = new HeapArray(capacidade);
	}
	
	public void insert(int chave, Object elemento) {
		heap.inserir(new Item(chave, elemento));
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
	
	public void exibirArray() {
		heap.exibirArray();
	}
}