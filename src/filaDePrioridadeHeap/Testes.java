package filaDePrioridadeHeap;

public class Testes {
	public static void main(String[] args) {
		
		FilaDePrioridade fila1 = new FilaDePrioridade(10);
		
		fila1.insert(2, "Louise");
		fila1.insert(5, "Carla");
		fila1.insert(6, "Maria");
		fila1.insert(9, "Joana");
		fila1.insert(7, "Silvia");
		
		System.out.println("Tamanho: " + fila1.size());
        System.out.println("Item com a menor chave: " + fila1.min());
        System.out.println("Chaves: ");
        fila1.exibirArray();
        
        System.out.println("");
        System.out.println("Removendo item com a menor chave...");
        fila1.removeMin();
        System.out.println("Chaves: ");
        fila1.exibirArray();
        System.out.println("");
        
        
        System.out.println("Testando outra...");
        FilaDePrioridadeNode fila2 = new FilaDePrioridadeNode();
		fila2.insert(2, "Louise");
		fila2.insert(5, "Carla");
		fila2.insert(6, "Maria");
		fila2.insert(9, "Joana");
		fila2.insert(7, "Silvia");
	
		System.out.println("Tamanho: " + fila2.size());
		System.out.println("Item com a menor chave: " + fila2.min());
		System.out.println("Chaves: ");
		fila2.mostrar();
    
    	System.out.println("");
    	System.out.println("Removendo item com a menor chave...");
    	fila2.removeMin();
    	System.out.println("Chaves: ");
    	fila2.mostrar();
	}
}
