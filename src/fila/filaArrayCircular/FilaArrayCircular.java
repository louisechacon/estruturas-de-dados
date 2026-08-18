package fila.filaArrayCircular;

import fila.Fila;
import fila.FilaVaziaExcecao;

public class FilaArrayCircular implements Fila {
	private int i;
	private int f;
	private int tamanho;
	private int incremento;
	private Object[] itens;
	
	public FilaArrayCircular(int tamanho, int incremento) {
		this.tamanho = tamanho;
		this.incremento = incremento;
		itens = new Object[tamanho];
	}
	
	@Override
	public void enqueue(Object item) {
		if (size() == tamanho-1) {
			int novoTamanho;
			if (incremento == 0) {
				novoTamanho = tamanho * 2;
			} else {
				novoTamanho = tamanho + incremento;
			}
			
			Object[] novoArray = new Object[novoTamanho];
			
			int inicioFila = i;
			for (int ff = 0; ff < size(); ff++) {
				novoArray[ff] = itens[inicioFila];
				inicioFila = (inicioFila + 1) % tamanho;
			}
			
			f = size(); // novo final da fila
			i = 0; // novo início da fila
			tamanho = novoTamanho;
			itens = novoArray;
		}
		
		itens[f] = item;
		f = (f + 1) % tamanho;
	}
	
	@Override
	public int size() {
		return (tamanho - i + f) % tamanho;
	}
	
}
