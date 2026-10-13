package arvores;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ArvoreGenerica {
	No raiz;
	int tamanho;

	public ArvoreGenerica(Object item) {
		raiz = new No(null, item);
		tamanho = 1; 
	}

	public No root() {
		return raiz;
	}

	public No parent(No valor) {
		return (valor.parent());
	}

	public Iterator children(No valor) {
		return valor.children();
	}

	public boolean isInternal(No valor) {
		return (valor.childrenNumber() > 0); // se tiver pelo menos um filho, eh interno
	}

	public boolean isExternal(No valor) {
		return (valor.childrenNumber() == 0); // nó sem filhos
	}

	public boolean isRoot(No valor) {
		return valor == raiz;
	}

	public void addChild(No valor, Object item) {
		No novo = new No(valor, item);
		valor.addChild(novo);
		tamanho++;
	}
	
	public Object remove(No valor) throws InvalidNoException {
		No pai = valor.parent();
		if (pai != null && isExternal(valor))
			pai.removeChild(valor);
		else
			throw new InvalidNoException("Só pode remover nós externos e que tenham um pai (não seja raiz)!");
		Object item = valor.element();
		tamanho--;
		return item;
	}
	
	public void swapElements(No v, No w) {
		Object aux = v.element();
		v.setElement(w.element());
		w.setElement(aux);
	}
	
	public int mostrarDepth(No valor) {
		int profundidade = profundidade(valor);
		return profundidade;
	}
	
	private int profundidade(No valor) {
		if (valor == raiz)
			return 0;
		else
			return 1 + profundidade(valor.parent());
	}
	
	public int height() {
		return altura(raiz);
	}
	
	private int altura(No valor) {
		if (isExternal(valor)) {
			return 0;
		}
		else {
			int h = 0;
			Iterator it = valor.children();
			while (it.hasNext()) {
				No child = (No) it.next();
				h = Math.max(h, altura(child));
			}
			return 1 + h;
		}
	}
	
	/** Retorna um iterator com os elementos armazenados na árvore */
	public Iterator elements() {
		List<Object> lista = new ArrayList<>();
		listaDeElementos(raiz, lista);
		return lista.iterator();
	}
	
	private void listaDeElementos(No valor, List<Object> lista) {
		lista.add(valor.element());
		Iterator it = valor.children();
		while (it.hasNext()) {
			No child = (No) it.next();
			listaDeElementos(child, lista);
		}
	}
	
	/** Retorna um iterator com as posições (Nos) da árvore */
	public Iterator Nos() {
		List<No> lista = new ArrayList<>();
		listaDeNos(raiz, lista);
		return lista.iterator();
	}
	
	private void listaDeNos(No valor, List<No> lista) {
		lista.add(valor);
		Iterator it = valor.children();
		while (it.hasNext()) {
			No child = (No) it.next();
			listaDeNos(child, lista);
		}
	}
	
	public void preOrder(No valor) {
		System.out.println(valor.element());
		Iterator it = valor.children();
		while (it.hasNext()) {
			No child = (No) it.next();
			preOrder(child);
		}
	}
	
	public void posOrder(No valor) {
		Iterator it = valor.children();
		while (it.hasNext()) {
			No child = (No) it.next();
			posOrder(child);
		}
		System.out.println(valor.element());
	}
	
	// retorna o número de nós na árvore
	public int size() {
		return tamanho;
	}
	
	public boolean isEmpty() {
		return false; // sempre falso pois não permitimos remover a raiz
	}
	
	public Object replace(No valor, Object item) {
		Object elemAntigo = valor.element();
		valor.setElement(item);
		return elemAntigo;
	}
	
	
	public class No {
		private Object o;
		private No pai;
		private ArrayList filhos = new ArrayList();
		public No(No pai, Object o) {
			this.pai = pai;
			this.o = o;
		}
		public Object element() {
			return o;
		}
		public No parent() {
			return pai;
		}
		public void setElement(Object o) {
			this.o = o;
		}
		public void addChild(No o) {
			filhos.add(o);
		}
		public void removeChild(No o) {
			filhos.remove(o);
		}
		public int childrenNumber() {
			return filhos.size();
		}
		public Iterator children() {
			return filhos.iterator();
		}
	}
}
