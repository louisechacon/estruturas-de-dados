package filaDePrioridadeHeap;

public class HeapArray {
	private Item[] itens;
	private int tamanho;
	private int capacidade;
	
	public HeapArray(int capacidade) {
		this.capacidade = capacidade;
		tamanho = 0;
		itens = new Item[capacidade];
	}
	
	public int size() {
		return tamanho;
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public void inserir(Item item) {
		if (tamanho == capacidade-1) {
			capacidade *= 2;
			Item[] novoArray = new Item[capacidade];
			for (int i = 1; i <= tamanho; i++) {
				novoArray[i] = itens[i];
			}
			itens = novoArray;
		}
		
		itens[++tamanho] = item;
		upHeap(tamanho);
	}
	
	private void upHeap(int indice) {
		int indicePaiDoNo = indice / 2;
		
		/* upheap termina quando a chave k encontra o nó raiz ou um nó cujo pai
		   possua uma chave menor ou igual a k */
		while (indice > 1 && itens[indice].getChave() < itens[indicePaiDoNo].getChave()) {
			Item aux = itens[indice];
			itens[indice] = itens[indicePaiDoNo];
			itens[indicePaiDoNo] = aux;
			
			indice = indicePaiDoNo;
			indicePaiDoNo = indice / 2;
		}
	}
	
	public Item min() {
		return itens[1];
	} 
	
	public Item removeMin() {
		Item menor = itens[1];
		// substitui o da raiz c/ o do último nó
		itens[1] = itens[tamanho];
		tamanho--;
		downHeap(1);
		return menor;
	}
	
	private void downHeap(int indice) {
		int leftChild = 2 * indice;
		int rightChild = (2 * indice) + 1;
		int menor = indice;
		
		if (leftChild <= tamanho && itens[leftChild].getChave() < itens[menor].getChave()) {
			menor = leftChild;
		}
		
		if (rightChild <= tamanho && itens[rightChild].getChave() < itens[menor].getChave()) {
			menor = rightChild;
		}
		
		if (menor != indice) {
			Item aux = itens[indice];
			itens[indice] = itens[menor];
			itens[menor] = aux;
			
			downHeap(menor);
		}
	}
	
	public void exibirArray() {
		for (int i = 1; i <= tamanho; i++) {
			System.out.print(itens[i].getChave());
			if (i < tamanho) {
				System.out.print(" ");
			}
		}
	}
}
