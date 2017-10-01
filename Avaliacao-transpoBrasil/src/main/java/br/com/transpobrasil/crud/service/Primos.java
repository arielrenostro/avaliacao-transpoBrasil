package br.com.transpobrasil.crud.service;

public class Primos {

	public static String main() {
		
		int[] 	numeros 		= new int[4961];
		int[] 	primeirosPrimos	= {2,3,5,7,11,13,17,19,23,29,31,37,41,43};
		
		// Preenche o array com todos os numeros...
		for(int i=0; i < numeros.length; i++) 
			numeros[i] = i+42;
		
		// Verifica os primeiros primos...
		for(int i=0; i < numeros.length; i++) {
			
			int n = numeros[i];
			
			for(int nn:primeirosPrimos) {
				
				if((n != nn) && ((n % nn) == 0)) {
					numeros[i] = 0;
					break;
				}
			}
		}
		
		// Faz a verifica��o por tentativa...
		for(int i=0; i < numeros.length; i++) {
			
			int n  = numeros[i]; // Numero a ser verificado
			
			// Defini��o de primo diz que todo primo � divisivel por 1 ou por ele mesmo.
			if(n > 1) {
				
				int nx = n/2; // Nenhum primo � divisivel por alguem maior que a sua metade
				
				// Vai at� a posi��o que o i est�, somente primos estar�o ali.
				for(int a=0; a < i; a++) {
					
					int nn = numeros[a];
					
					if(nn > 0) {
						// nn precisa ser: maior que 0, diferente de N, menor que a metade de N e n�o pode ter divis�o perfeita por qualquer valor menor que ele, a n�o ser 1
						if((nn != n) && (nn < nx) && ((n % nn) == 0)) {
							numeros[i] = 0;
							break;
						}
					}
				}
			}
		}
		
		String retorno = "";
		
		for(int i=0; i < numeros.length; i++) {
			
			if(numeros[i] > 0) {
				
				if(retorno.length() > 0)
					retorno += ", ";
				
				retorno += numeros[i];
			}
		}
		
		System.out.println(retorno);
		return retorno;
	}
}
