package Inglesa;

import Hindu.hinduIterativoEstatico;

public class InglesaIterativoEstatico {

	public static void main(String[] args) {
		int[] arrNum1 = { 5, 0 };
		int[] arrNum2 = { 2 };
		int[] result = InglesaIterativoEstatico.multiplicaInglesa(arrNum1, arrNum2);

		// Imprimir Resultado
		System.out.println("ingles resultado: ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}

	/* tomado del libro: Diseño de algoritmos con implementaciones en java en la
	 * pagina 115
	 * Multiplica dos números representados como arreglos de dígitos en notación
	 * inglesa.
	 * @param arreglo1 El primer número en notación inglesa.
	 * @param arreglo2 El segundo número en notación inglesa.
	 * @return Un arreglo que representa el resultado de la multiplicación.
	 */
	public static int[] multiplicaInglesa(int[] arreglo1, int[] arreglo2) {
		// El tamaño del resultado será la suma de las longitudes de ambos arreglos.
		int tam = arreglo1.length + arreglo2.length;
		int[] resultado = new int[tam];
		// Realizamos la multiplicación.
		for (int i = 0; i < arreglo2.length; i++) {
			for (int j = 0; j < arreglo1.length; j++) {
				resultado[i + j + 1] += arreglo1[j] * arreglo2[i];
			}
		}
		// Ajustamos los valores del resultado para que estén en notación inglesa.
		for (int k = tam - 1; k > 0; k--) {
			resultado[k - 1] += resultado[k] / 10;
			resultado[k] %= 10;
		}
		return resultado;
	}

}
