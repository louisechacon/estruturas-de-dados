package tabelaHash;

public class TabelaHashLinearProbing implements TabelaHash {
	private Par[] tabela;
	private int tamanho;
	private static final String NO_SUCH_KEY = "NO_SUCH_KEY";
	
	public TabelaHashLinearProbing(int capacidade) {
		tabela = new Par[capacidade];
		tamanho = 0;
	}
	
	public void insert(int key, String value) {
		int indice = hash(key);
		
		// procura enquanto não acha célula vazia, AVAILABLE ou a própria chave
		while (tabela[indice] != null && tabela[indice] != Par.AVAILABLE && tabela[indice].getKey() != key) {
			indice = (indice + 1) % tabela.length;
		}
		
		if (tabela[indice] == null || tabela[indice] == Par.AVAILABLE) {
			tabela[indice] = new Par(key, value);
			tamanho++;
			
			if ((double) tamanho / tabela.length > 0.75) {
				rehash(); // caso a tabela hash atinja o limite de eficiência
			}
		} else {
			tabela[indice].setValue(value);
		}
		
	}
	
	private int hash(int key) {
		return key % tabela.length;
	}
	
	private void rehash() {
		Par[] tabelaAntiga = tabela;
		tabela = new Par[2 * tabelaAntiga.length];
		tamanho = 0;
		
		for (Par par : tabelaAntiga) {
			if (par != null && par != Par.AVAILABLE) {
				insert(par.getKey(), par.getValue());
			}
		}
	}
	
	public String findElement(int key) {
		int indice = hash(key);
		int probeCont = 0;
		
		while (probeCont < tabela.length) {
			Par parAtual = tabela[indice];
			
			if (parAtual == null) {
				return NO_SUCH_KEY;
			} else if (parAtual != Par.AVAILABLE && parAtual.getKey() == key) {
				return parAtual.getValue();
			} else {
				indice = (indice + 1) % tabela.length;
				probeCont++;
			}
		}	
		return NO_SUCH_KEY;	
	}
	
	public String removeElement(int key) {
		int indice = hash(key);
		int probeCont = 0;
		
		while (probeCont < tabela.length) {
			Par parAtual = tabela[indice];
			
			if (parAtual == null) {
				return NO_SUCH_KEY;
			} else if (parAtual != Par.AVAILABLE && parAtual.getKey() == key) {
				String elemento = parAtual.getValue();
				tabela[indice] = Par.AVAILABLE;
				tamanho--;
				return elemento;
			} else {
				indice = (indice + 1) % tabela.length;
				probeCont++;
			}
		}
		return NO_SUCH_KEY;
	}
	
	public int size() {
		return tamanho;
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public void exibirTabelaHash() {
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i] == null) {
				System.out.println(i + ": null");
			} else if (tabela[i] == Par.AVAILABLE) {
				System.out.println(i + ": AVAILABLE");
			} else {
				System.out.println(i + ": Chave = " + tabela[i].getKey() + ", Valor = " + tabela[i].getValue());
			}
		}
	}
}
