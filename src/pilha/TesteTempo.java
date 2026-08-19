/*
 * Created on 01/09/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Robinson
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package pilha;

import pilha.pilhaArray.PilhaArray;

public class TesteTempo {
	public static void main(String[] args) {
		Integer[] b = new Integer[1];
		
		PilhaArray pp = new PilhaArray(1, 0);
		
		long inicio = System.currentTimeMillis();
		System.out.println("inserindo");
		for (int f = 0; f < 1000000; f++){ 		  
		  pp.push(f);
		}
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de inserção: " + (fim - inicio) + " ms");
		
		System.out.println("retirando");
		for (int f = 0; f < 1000000; f++){
			  pp.pop();
		}
	}
}