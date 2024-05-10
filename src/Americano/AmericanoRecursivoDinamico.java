package Americano;

import java.util.ArrayList;

//Codigo generadado I.A

public class AmericanoRecursivoDinamico {

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
		ArrayList<Integer> resultado= MultitradicionalRecursivo(arrNum1, arrNum2);
		System.out.println("RESULTADO: ");
		for (int i = 0; i < resultado.size(); i++) {
			System.out.print(resultado.get(i));
		}
	}

	public static ArrayList<Integer>  MultitradicionalRecursivo(ArrayList<Integer>  arreglo1, ArrayList<Integer>  arreglo2) {
		int k = arreglo1.size() + arreglo2.size() - 1;
		int pos = k;
		ArrayList<Integer> resultado = new ArrayList<>();
		for (int i = 0; i < arreglo1.size() + arreglo2.size(); i++) {
            resultado.add(0);
        }
		ciclosuperior(arreglo1, arreglo2, resultado, k, pos, arreglo1.size() - 1);
		return resultado;
	}

	private static void ciclosuperior(ArrayList<Integer>  arreglo1, ArrayList<Integer>  arreglo2, ArrayList<Integer>  resultado, int k, int pos, int indice) {
		if (indice >= 0) {
			multiplicarArreglosRecursivo(arreglo1, arreglo2, resultado, indice, arreglo2.size() - 1, k);
			k = pos;
            ciclosuperior(arreglo1,arreglo2,resultado,k -1,pos -1 , indice-1);
        }
	}

	public static void multiplicarArreglosRecursivo(ArrayList<Integer>  arreglo1, ArrayList<Integer>  arreglo2, ArrayList<Integer> resultado, int i, int j, int k) {
        if (j >= 0) {
			resultado.set(k, resultado.get(k) + arreglo1.get(i) * arreglo2.get(j));
			if (resultado.get(k) > 9) {
                resultado.set(k - 1, resultado.get(k - 1) + resultado.get(k) / 10);
                resultado.set(k, resultado.get(k) % 10);
            }

			k--;
            multiplicarArreglosRecursivo(arreglo1, arreglo2, resultado, i, j - 1, k);
        }
    }

}
