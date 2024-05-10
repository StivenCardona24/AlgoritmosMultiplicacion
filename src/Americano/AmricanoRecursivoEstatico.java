package Americano;

//Generado manualmente con ajustes de IA

public class AmricanoRecursivoEstatico {

	public static void main(String[] args) {
		int[] arrNum1 = { 9, 4, 2, 2, 0, 3, 8};
		int[] arrNum2 = { 3, 5, 8, 5, 0};
		//americanoRecursivo(arrNum1, arrNum2);
		int[] resultado = MultitradicionalRecursivo(arrNum1, arrNum2);
		System.out.println("AMERICANO RESULTADO: ");
		for (int i = 0; i < resultado.length; i++) {
			System.out.print(resultado[i]);
		}
	}
//// DEL LIBRO DEL PROFESOR PAGINA 112 cambiado a recursivo manualmente
	public static int[] MultitradicionalRecursivo(int arreglo1[], int arreglo2[]) {
		int k = arreglo1.length + arreglo2.length - 1;
		int pos = k;
		int resultado[] = new int[arreglo1.length + arreglo2.length];
		ciclosuperior(arreglo1, arreglo2, resultado, k, pos, arreglo1.length - 1);
		return resultado;
	}

	private static void ciclosuperior(int[] arreglo1, int[] arreglo2, int[] resultado, int k, int pos, int indice) {
		if (indice >= 0) {
			multiplicarArreglosRecursivo(arreglo1, arreglo2, resultado, indice, arreglo2.length - 1, k);
			k = pos;
            ciclosuperior(arreglo1,arreglo2,resultado,k -1,pos -1 , indice-1);
        }
	}

	public static void multiplicarArreglosRecursivo(int[] arreglo1, int[] arreglo2, int[] resultado, int i, int j, int k) {
        if (j >= 0) {
            resultado[k] += arreglo1[i] * arreglo2[j];
            if (resultado[k] > 9) {
                resultado[k - 1] += resultado[k] / 10;
                resultado[k] %= 10;
            }
			k--;
            multiplicarArreglosRecursivo(arreglo1, arreglo2, resultado, i, j - 1, k);
        }
    }

}

