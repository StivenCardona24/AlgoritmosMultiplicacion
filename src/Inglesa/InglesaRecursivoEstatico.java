package Inglesa;

//Documentación generada por I.A.
//Codigo creado manualmente con ajustes de IA

public class InglesaRecursivoEstatico {

    /**
     * Función principal que prueba la multiplicación inglesa recursiva.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        // Dos arreglos de números enteros para multiplicar
        int[] arrNum1 = { 2, 0, 2, 4, 6 };
        int[] arrNum2 = { 5, 5, 2, 3, 0 };
        // Realizar la multiplicación inglesa recursiva
        int[] result = multiplicaInglesaRecursiva(arrNum1, arrNum2);
        // Imprimir el resultado
        System.out.println("Resultado de la multiplicación: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    public static int[] multiplicaInglesa(int[] arreglo1, int[] arreglo2) {

        int tam = arreglo1.length + arreglo2.length;
        int[] resultado = new int[tam];
        for (int i = 0; i < arreglo2.length; i++) {

            for (int j = 0; j < arreglo1.length; j++) {

                resultado[i + j + 1] += arreglo1[j] * arreglo2[i];

            }

        }
        for (int k = tam - 1; k > 0; k--) {

            resultado[k - 1] += resultado[k] / 10;
            resultado[k] %= 10;

        }
        return resultado;

    }

    /**
     * Realiza la multiplicación inglesa de dos arreglos de números enteros de forma
     * recursiva.
     * 
     * @param arrNum1 El primer número a multiplicar
     * @param arrNum2 El segundo número a multiplicar
     * @return Un arreglo de números enteros con el resultado de la multiplicación
     */

    public static int[] multiplicaInglesaRecursiva(int[] arrNum1, int[] arrNum2) {

        // Si alguno de los dos números es cero, el resultado es cero
        if (arrNum1.length == 1 && arrNum1[0] == 0 || arrNum2.length == 1 && arrNum2[0] == 0) {
            return new int[] { 0 };
        }

        // Si alguno de los dos números es uno, el resultado es el otro número
        if (arrNum1.length == 1 && arrNum1[0] == 1) {
            return arrNum2;
        }
        if (arrNum2.length == 1 && arrNum2[0] == 1) {
            return arrNum1;
        }

        int tam = arrNum1.length + arrNum2.length;
        int[] result = calcularMultiplicacion(arrNum1, arrNum2, new int[tam], 0, 0);
        return sumarMultiplicacion(result, tam-1);
    }

    /**
     * Realiza la multiplicación inglesa de dos arreglos de números enteros de forma
     * recursiva.
     * 
     * @param arrNum1 El primer número a multiplicar
     * @param arrNum2 El segundo número a multiplicar
     * @param result  El arreglo que almacenará el resultado de la multiplicación
     * @param i       Índice para recorrer el primer número
     * @param j       Índice para recorrer el segundo número
     * @return Un arreglo de números enteros con el resultado de la multiplicación
     */

    private static int[] calcularMultiplicacion(int[] arrNum1, int[] arrNum2, int[] result, int i, int j) {

        // Si se ha llegado al final de los dos arreglos, se devuelve el resultado
        if (i == arrNum1.length && j == arrNum2.length) {
            return result;
        }

        // Si se ha llegado al final del segundo arreglo, se reinicia el índice y se
        // avanza en el primer arreglo
        if (j < arrNum2.length && i < arrNum2.length) {
            result[i + j + 1] += arrNum1[j] * arrNum2[i];
            return calcularMultiplicacion(arrNum1, arrNum2, result, i, j+1);
        }
        
        // Si se ha llegado al final del primer arreglo, se reinicia el índice y se
        // avanza en el segundo arreglo
        if (i < arrNum2.length) {
            return calcularMultiplicacion(arrNum1, arrNum2, result, i + 1, 0 );
        }

        return result;

    }


    public static int[] sumarMultiplicacion(int[] result, int k) {
       if(k == 0){
           return result;
       }
        result[k - 1] += result[k] / 10;
        result[k] %= 10;
        return sumarMultiplicacion(result, k-1);
    }

}
