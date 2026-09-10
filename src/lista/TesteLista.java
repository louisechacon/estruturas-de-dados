package lista;

public class TesteLista {
	public static void main(String[] args) {
		
		Lista l1 = new ListaArray(3);
		
		l1.insertFirst("A");
		l1.insertLast("C");
		System.out.println("Quem é o primeiro? " + l1.first());
		System.out.println("Quem é o último? " + l1.last());
		
		System.out.println("Quem vem antes do C? " + l1.before(1));
		System.out.println("Quem vem depois do A? " + l1.after(0));
		
		System.out.println("Mudando C por B...");
		l1.replaceElement(1, "B");
		System.out.println("Quem é o último? " + l1.last());
		
		System.out.println("Inserindo C depois do B...");
		l1.insertAfter(1, "C");
		System.out.println("Quem é o último? " + l1.last());
		System.out.println("Inserindo L antes do A...");
		l1.insertBefore(1, "L");
		System.out.println("Quem é o primeiro? " + l1.first());
		
		l1.remove(0);
		System.out.println("Quem é o primeiro após remover L? " + l1.first());
	}
}
