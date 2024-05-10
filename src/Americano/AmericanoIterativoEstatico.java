package Americano;

public class AmericanoIterativoEstatico {

	public static void main(String[] args) {
		int[] arrNum1 = { 9, 4, 2, 2, 0, 3, 8};
		int[] arrNum2 = { 3, 5, 8, 5, 0};
		Multitradicional2(arrNum1, arrNum2);
	}
//// DEL LIBRO DEL PROFESOR PAGINA 112
	public static int[] Multitradicional2(int arreglo1[], int arreglo2[]) {
		int k = arreglo1.length + arreglo2.length - 1;
		int pos = arreglo1.length + arreglo2.length - 1;
		int resultado[] = new int[arreglo1.length + arreglo2.length];
		for (int i = arreglo1.length - 1; i >= 0; i--) {
			for (int j = arreglo2.length - 1; j >= 0; j--) {
				resultado[k] += arreglo1[i] * arreglo2[j];
				if (resultado[k] > 9) {
					resultado[k - 1] += resultado[k] / 10;
					resultado[k] = resultado[k] % 10;
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
