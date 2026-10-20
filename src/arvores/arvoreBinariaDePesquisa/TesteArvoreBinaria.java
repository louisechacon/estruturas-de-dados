package arvores.arvoreBinariaDePesquisa;

public class TesteArvoreBinaria {
	public static void main(String[] args) {
		
		ArvoreBinariaPesquisa a1 = new ArvoreBinariaPesquisa();
		
		System.out.println("Inserindo elementos...");
		a1.inserir(6);
		a1.inserir(2);
		a1.inserir(9);
		a1.inserir(1);
		a1.inserir(4);
		a1.inserir(8);
		a1.inserir(5);
		
		System.out.println("Árvore: ");
		a1.mostrar();
		
		
		a1.remover(4);
		System.out.println("Removendo o 4... ");
		System.out.println("Árvore: ");
		a1.mostrar();
		
		ArvoreBinariaPesquisa a2 = new ArvoreBinariaPesquisa();
		System.out.println("Inserindo elementos na nova árvore...");
		a2.inserir(6);
		a2.inserir(2);
		a2.inserir(9);
		a2.inserir(1);
		a2.inserir(4);
		a2.inserir(8);
		a2.inserir(3);
		a2.inserir(5);
		System.out.println("Árvore: ");
		a2.mostrar();
		
		a2.remover(2);
		System.out.println("Removendo o 2... ");
		System.out.println("Árvore: ");
		a2.mostrar();
		
		System.out.println("6 é raiz?: " + a2.isRoot(a2.root()));
		System.out.println("Altura da nova árvore: " + a2.height());
		Node no5 = a2.buscar(5, a2.root());
        System.out.println("Profundidade de 5: " + a2.depth(no5));
	}
}
