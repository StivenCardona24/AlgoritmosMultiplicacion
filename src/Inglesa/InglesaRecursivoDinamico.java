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
		arrNum1.add(0);
		arrNum1.add(2);
		arrNum1.add(4);

		ArrayList<Integer> arrNum2 = new ArrayList<>();
		arrNum2.add(5);
		arrNum2.add(5);
		arrNum2.add(2);
		arrNum2.add(3);
		arrNum2.add(0);

		// Realizar la multiplicación inglesa recursiva
		ArrayList<Integer> result = multiplicaInglesaRecursiva(arrNum1, arrNum2);

		// Imprimir el resultado
		System.out.println("Resultado de la multiplicación: ");
		for (int num : result) {
			System.out.print(num);
		}
	}

	/**
	 * Realiza la multiplicación inglesa de dos ArrayList de números enteros de forma recursiva.
	 * @param arrNum1 El primer número a multiplicar
	 * @param arrNum2 El segundo número a multiplicar
	 * @return Un ArrayList de números enteros con el resultado de la multiplicación
	 */
	public static ArrayList<Integer> multiplicaInglesaRecursiva(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2) {
		// Si alguno de los dos números es cero, el resultado es cero
		if (arrNum1.size() == 0 || arrNum2.size() == 0) {
			ArrayList<Integer> result = new ArrayList<>();
			result.add(0);
			return result;
		}

		// Si alguno de los dos números es uno, el resultado es el otro número
		if (arrNum1.size() == 1 && arrNum1.get(0) == 1) {
			return arrNum2;
		}
		if (arrNum2.size() == 1 && arrNum2.get(0) == 1) {
			return arrNum1;
		}

		int tam = arrNum1.size() + arrNum2.size();
		ArrayList<Integer> resultado = new ArrayList<>();
		for (int i = 0; i < tam; i++) {
			resultado.add(0);
		}
		resultado = calcularMultiplicacion1(arrNum1, arrNum2, resultado, 0, 0);
		return sumarMultiplicacion(resultado, tam-1);
	}

	/**
	 * Calcula la multiplicación de dos ArrayList de números enteros de forma recursiva.
	 * @param arrNum1 El primer número a multiplicar
	 * @param arrNum2 El segundo número a multiplicar
	 * @param resultado El ArrayList que almacenará el resultado de la multiplicación
	 * @param i El índice actual del primer número
	 * @param j El índice actual del segundo número
	 * @return Un ArrayList de números enteros con el resultado de la multiplicación
	 */
	private static ArrayList<Integer> calcularMultiplicacion1(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2, ArrayList<Integer> resultado, int i, int j) {
		// Si se ha llegado al final de los dos números, se devuelve el resultado
		if (i == arrNum1.size() && j == arrNum2.size()) {
			return resultado;
		}

		
		// Si se ha llegado al final del segundo número, se agrega un cero al resultado
	    calcularMultiplicacion2(arrNum1, arrNum2, resultado, i , j);
		

		// Si se ha llegado al final del primer número, se agrega un cero al resultado
		if (i < arrNum2.size()) {
			return calcularMultiplicacion1(arrNum1, arrNum2, resultado, i+1, 0);
		}

		return resultado;

	}

	private static ArrayList<Integer> calcularMultiplicacion2(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2, ArrayList<Integer> resultado, int i, int j) {

		
		// Si se ha llegado al final del segundo número, se agrega un cero al resultado
		if (j < arrNum1.size() && i < arrNum2.size()) {
			resultado.set(i+j+1, resultado.get(j+i+1) + arrNum1.get(j) * arrNum2.get(i));
			return calcularMultiplicacion2(arrNum1, arrNum2, resultado, i , j+1);
		}

		return resultado;

	}

	/**
	 * Suma los elementos de un ArrayList de números enteros de forma recursiva.
	 * @param resultado El ArrayList con los números a sumar
	 * @param tam La longitud del resultado
	 * @return Un ArrayList de números enteros con el resultado de la suma
	 */
	private static ArrayList<Integer> sumarMultiplicacion(ArrayList<Integer> resultado, int tam) {
		if (tam == 0) {
			return resultado;
		}

		resultado.set(tam-1, resultado.get(tam) / 10 + resultado.get(tam-1));	
		resultado.set(tam, resultado.get(tam) % 10);
		return sumarMultiplicacion(resultado, tam-1);
	}


}
