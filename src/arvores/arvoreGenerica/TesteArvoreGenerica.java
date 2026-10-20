package arvores.arvoreGenerica;
import java.util.Iterator;

import arvores.arvoreGenerica.ArvoreGenerica.No;

public class TesteArvoreGenerica {
	public static void main(String[] args) {
		
		System.out.println("Testando árvore genérica!!!");
		ArvoreGenerica a1 = new ArvoreGenerica("Hogwarts");
		No hogwarts = a1.root();
		
		a1.addChild(hogwarts, "Ravenclaw");
		a1.addChild(hogwarts, "Gryffindor");
		
		Iterator it = a1.children(hogwarts);
		No ravenclaw = (No) it.next();
		No gryffindor = (No) it.next();
		
		a1.addChild(ravenclaw, "Luna");
		a1.addChild(gryffindor, "Hermione");
		a1.addChild(gryffindor, "Harry");
		
		System.out.println("Tamanho da árvore: " + a1.size());
		System.out.println("A árvore está vazia?: " + a1.isEmpty());
        System.out.println("Raiz: " + a1.root().element());
        System.out.println("Hogwarts é raiz?: " + a1.isRoot(hogwarts));
        
        System.out.println("Todos os nós:");
		Iterator nos = a1.Nos();
		while (nos.hasNext()) {
			No n = (No) nos.next();
			System.out.println(n.element() + " (profundidade " + a1.mostrarDepth(n) + ")");
		}
		
		System.out.println("Todos os elementos:");
		Iterator elementos = a1.elements();
		while (elementos.hasNext()) {
			Object elem = (Object) elementos.next();
			System.out.println(elem);
		}
		
		Iterator iterRaven = a1.children(ravenclaw);
		No luna = (No) iterRaven.next();
		
		Iterator iterGryf = a1.children(gryffindor);
		No hermione = (No) iterGryf.next();
		No harry = (No) iterGryf.next();
		
		System.out.println("Luna pertence a qual casa?: " + a1.parent(luna).element());
		System.out.println("Hermione pertence a qual casa?: " + a1.parent(hermione).element());
		System.out.println("Harry pertence a qual casa?: " + a1.parent(harry).element());
		
		System.out.println("Alunos da grifinória: ");
		Iterator filhosGryf = a1.children(gryffindor);
		while (filhosGryf.hasNext()) {
			System.out.print(((No) filhosGryf.next()).element() + " | ");
		}
		
		System.out.println("");
		System.out.println("Tem pelo menos um aluno na grifinória?: " + a1.isInternal(gryffindor));
        System.out.println("Luna é sem filhos?: " + a1.isExternal(luna));
		
        System.out.println("Altura da árvore: " + a1.height());
        System.out.println("Profundidade de Hermione: " + a1.mostrarDepth(hermione));
        
        System.out.println("Substituindo Harry por Rony...");
        Object personagemAntigo = a1.replace(harry, "Rony");
        System.out.println("Personagem antigo: " + personagemAntigo);
        System.out.println("Personagem novo: " + harry.element());
        
        System.out.println("Mostrando a árvore em pré ordem: ");
        a1.preOrder(hogwarts);
        
        System.out.println("Hermione e Luna vão trocar de casa...");
        a1.swapElements(luna, hermione);
        System.out.println("Mostrando a árvore em pós ordem: ");
        a1.posOrder(hogwarts);
        
        System.out.println("Removendo Rony...");
        a1.remove(harry);
        System.out.println("Mostrando a árvore em pré ordem: ");
        a1.preOrder(hogwarts);
	}
}