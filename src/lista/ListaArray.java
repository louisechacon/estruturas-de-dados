package lista;

public class ListaArray implements Lista {
	private Object[] itens;
	private int tamanho;
	private int capacidade;
	
	public ListaArray(int capacidade) {
		this.capacidade = capacidade;
		tamanho = 0;
		itens = new Object[capacidade];
	}
	
	public int size() {
		return tamanho;
	}
	
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	
	public Object first() {
		if (isEmpty()) {
			throw new ListaVaziaExcecao("A lista está vazia!");
		}
		return itens[0];
	}
	
	
	public Object last() {
		if (isEmpty()) {
			throw new ListaVaziaExcecao("A lista está vazia!");
		}
		return itens[tamanho-1];
	}
	
	
	public boolean isFirst(Object item) {
		if (isEmpty()) {
			throw new ListaVaziaExcecao("A lista está vazia!");
		}
		return item == first();
	}
	
	
	public boolean isLast(Object item) {
		if (isEmpty()) {
			throw new ListaVaziaExcecao("A lista está vazia!");
		}
		return item == last();
	}
	
	
	public Object before(int n) {
		if (n < 0 || n >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma posição válida!");
		}
		return itens[n - 1];
	}
	
	
	public Object after(int n) {
		if (n < 0 || n >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma posição válida!");
		}
		return itens[n + 1];
	}
	
	
	public Object replaceElement(int n, Object item) {
		if (n < 0 || n >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma posição válida!");
		}
		
		if (isEmpty()) {
			throw new ListaVaziaExcecao("A lista está vazia!");
		}
		
		Object elemAntigo = itens[n];
		itens[n] = item;
		return elemAntigo;
	}
	
	
	public void swapElements(int n, int m) {
		if (n < 0 || n >= tamanho || m < 0 || m >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma posição válida!");
		}
		
		if (isEmpty()) {
			throw new ListaVaziaExcecao("A lista está vazia!");
		}
		
		Object aux = itens[n];
		itens[n] = itens[m];
		itens[m] = aux;
	}
	
	
	public void insertBefore(int n, Object item) {
		if (tamanho == capacidade) {
			aumentaCapacidade();
		}
		
		if (n < 0 || n >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma posição válida!");
		}
		
		for (int i = tamanho; i > n - 1; i--) {
			itens[i] = itens[i - 1];
		}
		
		itens[n - 1] = item;
		tamanho++;
	}
	
	
	public void insertAfter(int n, Object item) {
		if (tamanho == capacidade) {
			aumentaCapacidade();
		}
		
		if (n < 0 || n >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma posição válida!");
		}
		
		for (int i = tamanho; i > n + 1; i--) {
			itens[i] = itens[i - 1];
		}
		
		itens[n + 1] = item;
		tamanho++;
	}
	
	public void insertFirst(Object item) {
		if (tamanho == capacidade) {
			aumentaCapacidade();
		}
		
		for (int i = tamanho; i > 0; i--) {
			itens[i] = itens[i - 1];
		}
		
		itens[0] = item;
		tamanho++;
	}
	
	
	public void insertLast(Object item) {
		if (tamanho == capacidade) {
			aumentaCapacidade();
		}

		itens[tamanho] = item;
		tamanho++;
	}
	
	
	public void remove(int n) {
		if (n < 0 || n >= tamanho) {
			throw new IndexOutOfBoundsException("Informe uma posição válida!");
		}
		
		if (isEmpty()) {
			throw new ListaVaziaExcecao("A lista está vazia!");
		}
		
		for (int i = n; i < tamanho-1; i++) {
			itens[i] = itens[i + 1];
		}
		
		tamanho--;
	}
	
	public void aumentaCapacidade() {
		int novaCapacidade = capacidade * 2;
		Object[] novaLista = new Object[novaCapacidade];
		
		for (int i = 0; i < tamanho; i++) {
			novaLista[i] = itens[i];
		}
		itens = novaLista;
		capacidade = novaCapacidade;
	}
	
	public void exibirLista() {
		for (int i = 0; i < tamanho; i++) {
			System.out.println("" + itens[i]);
		}
	}
}