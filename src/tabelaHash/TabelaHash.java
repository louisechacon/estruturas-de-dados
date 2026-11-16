package tabelaHash;

public interface TabelaHash {
	void insert(int key, String value);
	String findElement(int key);
	String removeElement(int key);
	int size();
	boolean isEmpty();
	void exibirTabelaHash();
}