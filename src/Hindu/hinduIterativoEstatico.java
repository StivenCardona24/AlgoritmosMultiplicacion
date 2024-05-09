package Hindu;

import java.util.Arrays;

//Codigo Generado por I.A.

public class hinduIterativoEstatico {

	public static void main(String[] args) {
		int[] arrNum1 = { 4, 5 };
		int[] arrNum2 = { 2, 3 ,4 };
		hinduIterativoEstatico.hindu(arrNum1, arrNum2);
	}

	//COdigo Generado por I.A.
	public static void hindu(int[] num1, int[] num2) {
		int m = num1.length;
		int n = num2.length;
		int[] result = new int[m + n];

		// Multiplicación usando el método hindú
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int product = num1[i] * num2[j];
				int sum = product + result[i + j + 1]; // Suma con el dígito previo
				result[i + j] += sum / 10; // Lleva el exceso al dígito anterior
				result[i + j + 1] = sum % 10; // Guarda el dígito en la posición adecuada
			}
		}
		
		//Imprimir Resultado
		System.out.println("Hindu resultado: ");
		for (int i = 0 ; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
	
}
