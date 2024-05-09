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
        int[] arrNum1 = { 2, 0 };
        int[] arrNum2 = { 5 };
        // Realizar la multiplicación inglesa recursiva
        int[] result = InglesaRecursivoEstatico.multiplicaInglesaRecursiva(arrNum1, arrNum2);
        // Imprimir el resultado
        System.out.println("Resultado de la multiplicación: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
    
    /**
     * Realiza la multiplicación inglesa de dos arreglos de números enteros de forma recursiva.
     * 
     * @param arreglo1 El primer arreglo de números enteros
     * @param arreglo2 El segundo arreglo de números enteros
     * @return Un arreglo que representa el resultado de la multiplicación
     */
    public static int[] multiplicaInglesaRecursiva(int[] arreglo1, int[] arreglo2) {
        return multiplicaInglesaRecursivaHelper(arreglo1, arreglo2, 0, new int[arreglo1.length + arreglo2.length]);
    }

    /**
     * Función auxiliar para la multiplicación inglesa recursiva.
     * 
     * @param arreglo1   El primer arreglo de números enteros
     * @param arreglo2   El segundo arreglo de números enteros
     * @param pos        La posición actual en el segundo arreglo
     * @param resultado  El arreglo que almacena el resultado de la multiplicación
     * @return Un arreglo que representa el resultado de la multiplicación
     */
    private static int[] multiplicaInglesaRecursivaHelper(int[] arreglo1, int[] arreglo2, int pos, int[] resultado) {
        if (pos >= arreglo2.length) {
            return resultado;
        }
        // Actualizar el resultado recursivamente
        actualizarResultadoRecursivo(arreglo1, arreglo2, resultado, 0, 0);
        actualizarResultadoRecursivo(resultado, resultado.length - 1);
        // Llamar recursivamente para procesar la siguiente posición en el segundo arreglo
        return multiplicaInglesaRecursivaHelper(arreglo1, arreglo2, pos + 1, resultado);
    }
    
    /**
     * Actualiza recursivamente el resultado de la multiplicación.
     * 
     * @param arreglo1   El primer arreglo de números enteros
     * @param arreglo2   El segundo arreglo de números enteros
     * @param resultado  El arreglo que almacena el resultado de la multiplicación
     * @param i          El índice actual en el primer arreglo
     * @param pos        La posición actual en el segundo arreglo
     */
    public static void actualizarResultadoRecursivo(int[] arreglo1, int[] arreglo2, int[] resultado, int i, int pos) {
        if (i < arreglo1.length) {
            resultado[i + pos + 1] += arreglo1[i] * arreglo2[pos];
            actualizarResultadoRecursivo(arreglo1, arreglo2, resultado, i + 1, pos);
        }
    }

    /**
     * Actualiza recursivamente el resultado de la multiplicación para corregir los acarreos.
     * 
     * @param resultado  El arreglo que almacena el resultado de la multiplicación
     * @param k          El índice actual en el arreglo de resultados
     */
    public static void actualizarResultadoRecursivo(int[] resultado, int k) {
        if (k > 0) {
            resultado[k - 1] += resultado[k] / 10;
            resultado[k] %= 10;
            actualizarResultadoRecursivo(resultado, k - 1);
        }
    }

}
