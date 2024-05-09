package Americano;

import java.util.ArrayList;

//Codigo generadado I.A

public class AmericanoRecursivoDinamico {

	public static void main(String[] args) {
		ArrayList<Integer> arrNum1 = new ArrayList<>();
		arrNum1.add(2);
		arrNum1.add(5);
		ArrayList<Integer> arrNum2 = new ArrayList<>();
		arrNum2.add(2);
		americanoRecursivo(arrNum1, arrNum2);
	}
	// Cambio de codigo generado manual
	public static void americanoRecursivo(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2) {
		// Crear una matriz para almacenar los productos parciales
		int[][] productosParciales = new int[arrNum2.size()][arrNum1.size() + arrNum2.size() + 1];

		calcularProductosParcialesRecursivo(arrNum1, arrNum2, 0, 0, productosParciales);
		// Calcular la suma total
		int[] sumaTotal = new int[arrNum1.size() + arrNum2.size() + 1];
		calcularSumaTotalRecursivo(arrNum1, arrNum2, 0, 0, sumaTotal, productosParciales);
		// Realizar el acarreo hacia la derecha
		realizarAcarreoDerechaRecursivo(sumaTotal, sumaTotal.length - 1);
		int resultado = convertirArregloANumero(sumaTotal, 0, 0);
		// Imprimir el resultado
		System.out.println("El resultado de la multiplicación es: " + resultado);
	}

	// Organiza los numeros en una matriz para posteriormente acomodarlos
	public static void calcularProductosParcialesRecursivo(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2, int i, int j, int[][] productosParciales) {
		if (i == arrNum2.size()) {
			// Hemos procesado todos los elementos de arrNum2, salimos de la recursión
			return;
		}
		if (j < arrNum1.size()) {
			// Calculamos el producto parcial y lo almacenamos en la matriz
			productosParciales[i][j + i] = arrNum1.get(j) * arrNum2.get(i);
			// Llamada recursiva para el siguiente elemento de arrNum1
			calcularProductosParcialesRecursivo(arrNum1, arrNum2, i, j + 1, productosParciales);
		} else {
			// Pasamos al siguiente dígito de arrNum2
			calcularProductosParcialesRecursivo(arrNum1, arrNum2, i + 1, 0, productosParciales);
		}
	}

	// Suma los numeros que se encuentran en la misma posicion vertical en la matriz
	public static void calcularSumaTotalRecursivo(ArrayList<Integer> arrNum1, ArrayList<Integer> arrNum2, int i, int j, int[] sumaTotal, int[][] productosParciales) {
		if (i < arrNum2.size()) {
			if (j < arrNum1.size() + arrNum2.size() + 1) {
				// Sumamos el producto parcial a la suma total
				sumaTotal[j] += productosParciales[i][j];
				// Llamada recursiva para el siguiente índice j
				calcularSumaTotalRecursivo(arrNum1, arrNum2, i, j + 1, sumaTotal, productosParciales);
			} else {
				// Pasamos al siguiente índice i
				calcularSumaTotalRecursivo(arrNum1, arrNum2, i + 1, 0, sumaTotal, productosParciales);
			}
		}
	}

	public static void realizarAcarreoDerechaRecursivo(int[] sumaTotal, int i) {
		if (i > 0) {
			sumaTotal[i - 1] += sumaTotal[i] / 10;
			sumaTotal[i] %= 10;
			// Llamada recursiva para el siguiente índice i
			realizarAcarreoDerechaRecursivo(sumaTotal, i - 1);
		}
	}

	// Convertir el resultado de la multiplicación a un número entero
	public static int convertirArregloANumero(int[] sumaTotal, int i, int resultado) {
		if (i < sumaTotal.length - 2) {
			return convertirArregloANumero(sumaTotal, i + 1, resultado * 10 + sumaTotal[i]);
		} else {
			return resultado;
		}
	}

}
