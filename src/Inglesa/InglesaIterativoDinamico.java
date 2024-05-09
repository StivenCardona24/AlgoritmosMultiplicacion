package Inglesa;

import java.util.ArrayList;

// Documentación generada por I.A.
// Codigo ajustado manualmente con base a Diseño de algoritmos con implementaciones en java en la pagina 115
// posteriormente a cambair manual se  ajustes con IA

public class InglesaIterativoDinamico {

	public static void main(String[] args) {
		ArrayList<Integer> arrNum1 = new ArrayList<>();
		arrNum1.add(5);
		arrNum1.add(1);
		ArrayList<Integer> arrNum2 = new ArrayList<>();
		arrNum2.add(5);
		ArrayList<Integer> result = multiplicaInglesa(arrNum1, arrNum2);

		// Imprimir Resultado
		System.out.println("Ingles resultado: ");
		for (int num : result) {
			System.out.print(num);
		}
	}

	/* Multiplica dos números representados como ArrayList de dígitos en notación
	 * inglesa.
	 * @param arreglo1 El primer número en notación inglesa.
	 * @param arreglo2 El segundo número en notación inglesa.
	 * @return Un ArrayList que representa el resultado de la multiplicación.
	 */
	public static ArrayList<Integer> multiplicaInglesa(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		// El tamaño del resultado será la suma de las longitudes de ambos ArrayList.
		int tam = arreglo1.size() + arreglo2.size();
		ArrayList<Integer> resultado = new ArrayList<>(tam);
		
		// Inicializar el resultado con ceros.
		for (int i = 0; i < tam; i++) {
			resultado.add(0);
		}
		
		// Realizamos la multiplicación.
		for (int i = 0; i < arreglo2.size(); i++) {
			for (int j = 0; j < arreglo1.size(); j++) {
				resultado.set(i + j + 1, resultado.get(i + j + 1) + arreglo1.get(j) * arreglo2.get(i));
			}
		}
		
		// Ajustamos los valores del resultado para que estén en notación inglesa.
		for (int k = tam - 1; k > 0; k--) {
			int carry = resultado.get(k) / 10;
			resultado.set(k - 1, resultado.get(k - 1) + carry);
			resultado.set(k, resultado.get(k) % 10);
		}
		
		// Eliminar los ceros sobrantes al principio, si los hay.
		while (resultado.size() > 1 && resultado.get(0) == 0) {
			resultado.remove(0);
		}
		return resultado;
	}
}
