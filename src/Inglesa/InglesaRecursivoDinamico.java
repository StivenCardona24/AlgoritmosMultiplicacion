package Inglesa;

import java.util.ArrayList;

// Documentación generada por I.A.
// Codigo Ajustado manualmente posteriormente se ajustes con IA

public class InglesaRecursivoDinamico {

	/* Función principal que prueba la multiplicación inglesa recursiva.
	 * @param args Los argumentos de la línea de comandos (no se utilizan)
	 */
	public static void main(String[] args) {
		// Dos ArrayList de números enteros para multiplicar
		ArrayList<Integer> arrNum1 = new ArrayList<>();
		arrNum1.add(2);
		arrNum1.add(5);

		ArrayList<Integer> arrNum2 = new ArrayList<>();
		arrNum2.add(5);

		// Realizar la multiplicación inglesa recursiva
		ArrayList<Integer> result = multiplicaInglesaRecursiva(arrNum1, arrNum2);

		// Imprimir el resultado
		System.out.println("Resultado de la multiplicación: ");
		for (int num : result) {
			System.out.print(num);
		}
	}

	/* Realiza la multiplicación inglesa de dos ArrayList de números enteros de
	 * forma recursiva.
	 * @param arreglo1 El primer ArrayList de números enteros
	 * @param arreglo2 El segundo ArrayList de números enteros
	 * @return Un ArrayList que representa el resultado de la multiplicación
	 */
	public static ArrayList<Integer> multiplicaInglesaRecursiva(ArrayList<Integer> arreglo1,
			ArrayList<Integer> arreglo2) {
		ArrayList<Integer> resultado = new ArrayList<>(arreglo1.size() + arreglo2.size());
		for (int i = 0; i < arreglo1.size() + arreglo2.size(); i++) {
			resultado.add(0);
		}
		return multiplicaInglesaRecursivaHelper(arreglo1, arreglo2, 0, resultado);
	}

	/* Función auxiliar para la multiplicación inglesa recursiva.
	 * @param arreglo1  El primer ArrayList de números enteros
	 * @param arreglo2  El segundo ArrayList de números enteros
	 * @param pos       La posición actual en el segundo ArrayList
	 * @param resultado El ArrayList que almacena el resultado de la multiplicación
	 * @return Un ArrayList que representa el resultado de la multiplicación
	 */
	private static ArrayList<Integer> multiplicaInglesaRecursivaHelper(ArrayList<Integer> arreglo1,
			ArrayList<Integer> arreglo2, int pos, ArrayList<Integer> resultado) {
		if (pos >= arreglo2.size()) {
			return resultado;
		}
		// Actualizar el resultado recursivamente
		actualizarResultadoRecursivo(arreglo1, arreglo2, resultado, 0, 0);
		actualizarResultadoRecursivo(resultado, resultado.size() - 1);
		// Llamar recursivamente para procesar la siguiente posición en el segundo
		// ArrayList
		return multiplicaInglesaRecursivaHelper(arreglo1, arreglo2, pos + 1, resultado);
	}

	/* Actualiza recursivamente el resultado de la multiplicación.
	 * @param arreglo1  El primer ArrayList de números enteros
	 * @param arreglo2  El segundo ArrayList de números enteros
	 * @param resultado El ArrayList que almacena el resultado de la multiplicación
	 * @param i         El índice actual en el primer ArrayList
	 * @param pos       La posición actual en el segundo ArrayList
	 */
	public static void actualizarResultadoRecursivo(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2,
			ArrayList<Integer> resultado, int i, int pos) {
		if (i < arreglo1.size()) {
			resultado.set(i + pos + 1, resultado.get(i + pos + 1) + arreglo1.get(i) * arreglo2.get(pos));
			actualizarResultadoRecursivo(arreglo1, arreglo2, resultado, i + 1, pos);
		}
	}

	/* Actualiza recursivamente el resultado de la multiplicación para corregir los
	 * acarreos.
	 * @param resultado El ArrayList que almacena el resultado de la multiplicación
	 * @param k         El índice actual en el ArrayList de resultados
	 */
	public static void actualizarResultadoRecursivo(ArrayList<Integer> resultado, int k) {
		if (k > 0) {
			resultado.set(k - 1, resultado.get(k - 1) + resultado.get(k) / 10);
			resultado.set(k, resultado.get(k) % 10);
			actualizarResultadoRecursivo(resultado, k - 1);
		}
	}

}
