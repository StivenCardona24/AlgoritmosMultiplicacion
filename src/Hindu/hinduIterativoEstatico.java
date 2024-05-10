package Hindu;

import java.util.Arrays;

//Codigo Generado por I.A.

public class hinduIterativoEstatico {

	public static void main(String[] args) {
		int[] arrNum1 = { 9, 4, 2, 2, 0, 3, 8};
		int[] arrNum2 = { 3, 5, 8, 5, 0};
		hinduIterativoEstatico.hindu(arrNum1, arrNum2);
	}

	//COdigo Generado por I.A.
	public static int[] hindu(int[] num1, int[] num2) {
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
		
		return result;
	}
	
}
