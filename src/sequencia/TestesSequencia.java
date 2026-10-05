package sequencia;

public class TestesSequencia {
	public static void main(String[] args) {
		
		// Testes de TAD sequencia com array
		System.out.println("Testando TAD Sequencia com array!!!");
		
		Sequencia s1 = new SequenciaArray(5);

        s1.insertFirst("A");
        s1.insertLast("C");
        s1.insertLast("D");

        System.out.println("Primeiro: " + s1.first().element());
        System.out.println("Último: " + s1.last().element());

        s1.insertAtRank(1, "B");
        System.out.println("Elemento no rank 1: " + s1.elemAtRank(1));
        Position posB = s1.atRank(1);
        System.out.println("Elemento da posição com atRank(1): " + posB.element());
        System.out.println("Rank da posição: " + s1.rankOf(posB));


        System.out.println("Antes de B: " + s1.before(posB).element());
        System.out.println("Depois de B: " + s1.after(posB).element());

        System.out.println("Elemento substituído: " + s1.replaceAtRank(1, "X"));
        System.out.println("Sequência: ");
        s1.exibirSequencia();
        System.out.println("Elemento substituído: " + s1.replaceElement(posB, "B"));
        System.out.println("Sequência: ");
        s1.exibirSequencia();

        Position posA = s1.atRank(0);
        Position posC = s1.atRank(2);
        s1.swapElements(posA, posC);
        System.out.println("Sequência após swap: "); 
        s1.exibirSequencia();
        
        System.out.println("Inserindo L antes e depois de B, e depois removendo B: ");
        s1.insertBefore(posB, "L");
        s1.insertAfter(posB, "L");
        s1.remove(posB);
        s1.exibirSequencia();

        System.out.println("Removendo: " + s1.removeAtRank(0));
        System.out.println("Tamanho final: " + s1.size());
        System.out.println("Está vazia? " + s1.isEmpty());
        System.out.println("Sequência final: ");
        s1.exibirSequencia();
        
        System.out.println("");
        
        //Testes de TAD sequencia com lista duplamente ligada
        System.out.println("Testando TAD Sequencia com LDL!!!");
        
        Sequencia s2 = new SequenciaLDL();
        
        s2.insertFirst("E");
        s2.insertLast("G");
        s2.insertLast("H");
        
        System.out.println("Primeiro: " + s2.first().element());
        System.out.println("Último: " + s2.last().element());
        
        s2.insertAtRank(1, "F");
        System.out.println("Elemento no rank 1: " + s2.elemAtRank(1));
        Position posF = s2.atRank(1);
        System.out.println("Elemento da posição com atRank(1): " + posF.element());
        System.out.println("Rank da posição: " + s2.rankOf(posF));
        
        System.out.println("Antes de F: " + s2.before(posF).element());
        System.out.println("Depois de F: " + s2.after(posF).element());
        
        System.out.println("Elemento substituído: " + s2.replaceAtRank(1, "X"));
        System.out.println("Sequência: ");
        s2.exibirSequencia();
        System.out.println("Elemento substituído: " + s2.replaceElement(posF, "F"));
        System.out.println("Sequência: ");
        s2.exibirSequencia();
        
        Position posE = s2.atRank(0);
        Position posG = s2.atRank(2);
        s2.swapElements(posE, posG);
        System.out.println("Sequência após swap: "); 
        s2.exibirSequencia();
        
        System.out.println("Inserindo L antes e depois de F, e depois removendo F: ");
        s2.insertBefore(posF, "L");
        s2.insertAfter(posF, "L");
        s2.remove(posF);
        s2.exibirSequencia();
        
        System.out.println("Removendo: " + s2.removeAtRank(0));
        System.out.println("Tamanho final: " + s2.size());
        System.out.println("Está vazia? " + s2.isEmpty());
        System.out.println("Sequência final: ");
        s2.exibirSequencia();
        
        Position pos = s2.atRank(0);
        s2.remove(pos);
        s2.remove(pos);
    }
}
