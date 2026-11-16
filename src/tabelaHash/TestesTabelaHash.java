package tabelaHash;

public class TestesTabelaHash {
	public static void main(String[] args) {
		TabelaHash hashTableLP = new TabelaHashLinearProbing(13);
		
		hashTableLP.insert(18, "18");
		hashTableLP.insert(41, "41");
		hashTableLP.insert(22, "22");
		hashTableLP.insert(44, "44");
		hashTableLP.insert(59, "59");
		hashTableLP.insert(32, "32");
		hashTableLP.insert(31, "31");
		hashTableLP.insert(73, "73");
		
		System.out.println("Tabela Hash com Linear Probing:");
		hashTableLP.exibirTabelaHash();
		
		System.out.println("Chave 31: " + hashTableLP.findElement(31));
		System.out.println("");
		
		System.out.println("Removendo o 18: " + hashTableLP.removeElement(18));
		hashTableLP.exibirTabelaHash();
		System.out.println("Chave 44: " + hashTableLP.findElement(44));
	}
}
