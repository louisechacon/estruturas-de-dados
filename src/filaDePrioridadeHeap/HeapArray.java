package filaDePrioridadeHeap;

public class HeapArray {
	private Item[] chaves;
	private int tamanho;
	private int capacidade;
	
	public HeapArray(int capacidade) {
		this.capacidade = capacidade;
		tamanho = 0;
		chaves = new Item[capacidade];
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
				novoArray[i] = chaves[i];
			}
			chaves = novoArray;
		}
		
		chaves[++tamanho] = item;
		upHeap(tamanho);
	}
	
	private void upHeap(int indice) {
		int indicePaiDoNo = indice / 2;
		
		/* upheap termina quando a chave k encontra o nó raiz ou um nó cujo pai
		   possua uma chave menor ou igual a k */
		while (indice > 1 && chaves[indice].getChave() < chaves[indicePaiDoNo].getChave()) {
			Item aux = chaves[indice];
			chaves[indice] = chaves[indicePaiDoNo];
			chaves[indicePaiDoNo] = aux;
			
			indice = indicePaiDoNo;
			indicePaiDoNo = indice / 2;
		}
	}
	
	public Item min() {
		return chaves[1];
	} 
	
	public Item removeMin() {
		Item menor = chaves[1];
		chaves[1] = chaves[tamanho]; // substitui chave da raiz c/ a chave no último nó
		tamanho--;
		downHeap(1);
		return menor;
	}
	
	private void downHeap(int indice) {
		int leftChild = 2 * indice;
		int rightChild = (2 * indice) + 1;
		int menor = indice;
		
		if (leftChild <= tamanho && chaves[leftChild].getChave() < chaves[menor].getChave()) {
			menor = leftChild;
		}
		
		if (rightChild <= tamanho && chaves[rightChild].getChave() < chaves[menor].getChave()) {
			menor = rightChild;
		}
		
		if (menor != indice) {
			Item aux = chaves[indice];
			chaves[indice] = chaves[menor];
			chaves[menor] = aux;
			
			downHeap(menor);
		}
	}
	
	public void exibirArray() {
		for (int i = 1; i <= tamanho; i++) {
			System.out.print(chaves[i].getChave());
			if (i < tamanho) {
				System.out.print(" ");
			}
		}
	}
}
