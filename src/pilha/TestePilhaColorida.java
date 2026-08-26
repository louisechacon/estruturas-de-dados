package pilha;

public class TestePilhaColorida {
	public static void main(String[] args) {
		
		PilhaColorida p1 = new PilhaColorida(7);
		p1.pushVermelha(2);
		p1.pushVermelha(10);
		p1.pushVermelha(7);
		p1.pushVermelha(8);
		p1.pushVermelha(1);
		p1.pushPreta(4);
		p1.pushPreta(5);
		System.out.println(p1.sizePilhas()); // deve retornar 7
		
		p1.pushVermelha(11);
		System.out.println(p1.sizePilhas()); // deve retornar 8
		
		p1.popVermelha();
		p1.popVermelha();
		p1.popVermelha();
		p1.popVermelha();
		p1.popVermelha();
		p1.popPreta();
		p1.popPreta();
		System.out.println(p1.sizePilhas()); // deve retornar 1
		
		p1.popVermelha();
		System.out.println(p1.sizePilhas()); // deve retornar 0
		
	}
}
