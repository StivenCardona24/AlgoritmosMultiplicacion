package Americano;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmericanoIterativoEstaticoDinamico {

	public static void main(String[] args) {
		ArrayList<Integer> arrNum1 = new ArrayList<>();
		arrNum1.add(9);
		arrNum1.add(4);
		arrNum1.add(2);
		arrNum1.add(2);
		arrNum1.add(0);
		arrNum1.add(3);
		arrNum1.add(8);

		ArrayList<Integer> arrNum2 = new ArrayList<>();
		arrNum2.add(3);
		arrNum2.add(5);
		arrNum2.add(8);
		arrNum2.add(5);
		arrNum2.add(0);

		ArrayList<Integer> resultado = Multitradicional2(arrNum1, arrNum2);

		System.out.println("RESULTADO: ");
		for (int i = 0; i < resultado.size(); i++) {
			System.out.print(resultado.get(i));
		}
	}

	// DEL LIBRO DEL PROFESOR PAGINA 112 modificado manual mente y corregido por IA
	// para dar los reusltados esperados
	public static ArrayList<Integer> Multitradicional2(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		int k = arreglo1.size() + arreglo2.size() - 1;
		int pos = arreglo1.size() + arreglo2.size() - 1;
		ArrayList<Integer> resultado = new ArrayList<>();

		// Inicializamos la lista resultado con ceros
		for (int i = 0; i <= k; i++) {
			resultado.add(0);
		}
		for (int i = arreglo1.size() - 1; i >= 0; i--) {
			for (int j = arreglo2.size() - 1; j >= 0; j--) {
				resultado.set(k, resultado.get(k) + arreglo1.get(i) * arreglo2.get(j));

				if (resultado.get(k) > 9) {
					if (k - 1 < resultado.size()) {
						resultado.set(k - 1, resultado.get(k - 1) + resultado.get(k) / 10);
					} else {
						resultado.add(resultado.get(k) / 10);
					}
					resultado.set(k, resultado.get(k) % 10);
				}
				k--;
			}
			k = pos;
			pos--;
			k--;
		}

		return resultado;
	}

}
