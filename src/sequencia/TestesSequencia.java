package sequencia;
import sequencia.SequenciaArray.SequenciaArray;

public class TestesSequencia {
	public static void main(String[] args) {
		
		Sequencia s1 = new SequenciaArray(5);

        s1.insertFirst("A");
        s1.insertLast("C");
        s1.insertLast("D");

        System.out.println("Primeiro: " + s1.first());
        System.out.println("Último: " + s1.last());

        s1.insertAtRank(1, "B");
        System.out.println("Elemento no rank 1: " + s1.elemAtRank(1));
        Position posB = s1.atRank(1);
        System.out.println("Elemento da posição com atRank(1): " + posB.element());
        System.out.println("Rank da posição: " + s1.rankOf(posB));


        System.out.println("Antes de B: " + s1.before(posB));
        System.out.println("Depois de B: " + s1.after(posB));

        System.out.println("Elemento substituído: " + s1.replaceAtRank(1, "X"));
        System.out.println("Sequência: " + s1.elemAtRank(0) + ", " + s1.elemAtRank(1) +
        		", " + s1.elemAtRank(2) + ", " + s1.elemAtRank(3));
        System.out.println("Elemento substituído: " + s1.replaceElement(posB, "B"));
        System.out.println("Sequência: " + s1.elemAtRank(0) + ", " + s1.elemAtRank(1) + 
        		", " + s1.elemAtRank(2) + ", " + s1.elemAtRank(3));

        Position posA = s1.atRank(0);
        Position posC = s1.atRank(2);
        s1.swapElements(posA, posC);
        System.out.println("Sequência após swap: " + s1.elemAtRank(0) + ", " + s1.elemAtRank(1) + 
        		", " + s1.elemAtRank(2) + ", " + s1.elemAtRank(3));

        s1.insertBefore(posB, "L");
        s1.insertAfter(posB, "L");
        s1.remove(posB);

        System.out.println("Removido: " + s1.removeAtRank(0));
        System.out.println("Tamanho final: " + s1.size());
        System.out.println("Está vazia? " + s1.isEmpty());
        System.out.println("Sequência final: " + s1.elemAtRank(0) + ", " + s1.elemAtRank(1) +
        		", " + s1.elemAtRank(2) + ", " + s1.elemAtRank(3));
    }
}
