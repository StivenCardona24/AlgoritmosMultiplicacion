package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import Americano.AmericanoIterativoEstatico;
import Americano.AmericanoIterativoEstaticoDinamico;
import Americano.AmericanoRecursivoDinamico;
import Americano.AmricanoRecursivoEstatico;
import DivideVenceras.DV;
import Hindu.hinduIterativoEstatico;
import Inglesa.InglesaIterativoDinamico;
import Inglesa.InglesaIterativoEstatico;
import Inglesa.InglesaRecursivoDinamico;
import Inglesa.InglesaRecursivoEstatico;

public class Aplicacion {

	public static void main(String[] args) {
		int tam1 = 32; // Tamaño deseado para los arreglos
		int tam2 = 32;

		int[] arregloEstatico1 = ObtenerArreglo(1, tam1);
		int[] arregloEstatico2 = ObtenerArreglo(2, tam2);

		if (arregloEstatico1.length == 0 || arregloEstatico2.length == 0) {
			arregloEstatico1 = generarArreglo(tam1);
			arregloEstatico2 = generarArreglo(tam2);
			try {
				guardarArregloEnArchivo(arregloEstatico1, "Arreglo1" + tam1 + ".txt");
				guardarArregloEnArchivo(arregloEstatico2, "Arreglo2" + tam2 + ".txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ArrayList<Integer> arregloDinamico1 = new ArrayList<>();
		ArrayList<Integer> arregloDinamico2 = new ArrayList<>();
		for (int i = 0; i < arregloEstatico1.length; i++) {
			arregloDinamico1.add(arregloEstatico1[i]);
		}
		for (int i = 0; i < arregloEstatico2.length; i++) {
			arregloDinamico2.add(arregloEstatico2[i]);
		}

		System.out.println(Arrays.toString(arregloEstatico1));
		System.out.println(Arrays.toString(arregloEstatico2));

		Map<String, Long> tiempos = new LinkedHashMap<>();
		long startTime = System.nanoTime();
		int[] resultado = InglesaIterativoEstatico.multiplicaInglesa(arregloEstatico1, arregloEstatico2);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		tiempos.put("Inglesa Iterativo Estatico", elapsedTime);
		System.out.println("Resultado de la multiplicación Inglesa Iterativo Estatico: " + Arrays.toString(resultado) + "\n");

		startTime = System.nanoTime();
		ArrayList<Integer> resultadoDinamico = InglesaIterativoDinamico.multiplicaInglesa(arregloDinamico1, arregloDinamico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Inglesa Iterativo Dinamico", elapsedTime);
		System.out.println("Resultado de la multiplicación Inglesa Iterativo Dinamico: " + resultadoDinamico + "\n");

		startTime = System.nanoTime();
		resultado = InglesaRecursivoEstatico.multiplicaInglesaRecursiva(arregloEstatico1, arregloEstatico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Inglesa Recursivo Estatico", elapsedTime);
		System.out.println("Resultado de la multiplicación Inglesa Recursivo Estatico: " + Arrays.toString(resultado) + "\n");

		startTime = System.nanoTime();
		resultadoDinamico = InglesaRecursivoDinamico.multiplicaInglesaRecursiva(arregloDinamico1, arregloDinamico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Inglesa Recursivo Dinamico", elapsedTime);
		System.out.println("Resultado de la multiplicación Inglesa Recursivo Dinamico: " + resultadoDinamico + "\n");

		startTime = System.nanoTime();
		resultado = hinduIterativoEstatico.hindu(arregloEstatico1, arregloEstatico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Hindu Iterativo Estatico", elapsedTime);
		System.out.println("Resultado de la multiplicación Hindu Iterativo Estatico: " + Arrays.toString(resultado) + "\n");

		startTime = System.nanoTime();
		resultado = AmericanoIterativoEstatico.Multitradicional2(arregloEstatico1, arregloEstatico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Americano Iterativo Estatico", elapsedTime);
		System.out.println("Resultado de la multiplicación Americano Iterativo Estatico: " + Arrays.toString(resultado) + "\n");

		startTime = System.nanoTime();
		resultadoDinamico = AmericanoIterativoEstaticoDinamico.Multitradicional2(arregloDinamico1, arregloDinamico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Americano Iterativo Dinamico", elapsedTime);
		System.out.println("Resultado de la multiplicación Americano Iterativo Dinamico: " + resultadoDinamico + "\n");

		startTime = System.nanoTime();
		resultadoDinamico = AmericanoRecursivoDinamico.MultitradicionalRecursivo(arregloDinamico1, arregloDinamico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Americano Recursivo Dinamico", elapsedTime);
		System.out.println("Resultado de la multiplicación Americano Recursivo Dinamico: " + resultadoDinamico + "\n");

		startTime = System.nanoTime();
		resultado =  AmricanoRecursivoEstatico.MultitradicionalRecursivo(arregloEstatico1, arregloEstatico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Americano Recursivo Estatico", elapsedTime);
		System.out.println("Resultado de la multiplicación Americano Recursivo Estatico: " + Arrays.toString(resultado) + "\n");


		startTime = System.nanoTime();
		resultado = DV.dv1(arregloEstatico1, arregloEstatico2, tam1);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Divide y Venceras", elapsedTime);
		System.out.println("Resultado de la multiplicación Divide y Venceras: " + Arrays.toString(resultado) + "\n");

		ordenarTiempos(tiempos);
		guardarComoTXT(tiempos, "tiempos"+ tam1 + "x" + tam2 + ".txt");



	}

	public static int[] generarArreglo(int tam) {
		int[] arreglo1 = new int[tam];
		// Llenar los arreglos con valores aleatorios
		for (int i = 0; i < tam; i++) {
			arreglo1[i] = (int) (Math.random() * 10);
		}

		return arreglo1;
	}

	// Método para obtener los arreglos de los archivos
	// Método tomado del seguimiento parte 1
	@SuppressWarnings("resource")
	public static int[] ObtenerArreglo(int name, int cant) {
		int[] arreglo = new int[cant];
		FileReader Fr = null;
		BufferedReader br = null;
		String nombreArchivo = "Arreglo" + name + cant + ".txt";

		try {
			Fr = new FileReader(nombreArchivo);
			br = new BufferedReader(Fr);
			String linea;
			String delimiter = ",";
			while (((linea = br.readLine()) != null)) {
				String a[] = linea.split(delimiter);
				for (int l = 0; l < a.length; l++) {
					arreglo[l] = Integer.parseInt(a[l].trim());
				}
			}
		} catch (IOException e) {
			System.out.println(e);
			return new int[] {}; // Devolver un arreglo vacío si ocurre un error
		}
		return arreglo;
	}

	public static void guardarArregloEnArchivo(int[] arreglo, String nombreArchivo) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
			// Escribir los elementos del arreglo en el archivo
			for (int i = 0; i < arreglo.length; i++) {
				if (i == arreglo.length - 1) {
					writer.write(arreglo[i] + "");
				} else {
					writer.write(arreglo[i] + ", ");
				}
			}
		}
	}

	private static void ordenarTiempos(Map<String, Long> tiempos) {
        Object[] keys = tiempos.keySet().toArray();
        for (int i = 0; i < keys.length - 1; i++) {
            for (int j = 0; j < keys.length - i - 1; j++) {
                if (tiempos.get(keys[j]) > tiempos.get(keys[j + 1])) {
                    // Intercambiar los elementos si están en el orden incorrecto
                    Object temp = keys[j];
                    keys[j] = keys[j + 1];
                    keys[j + 1] = temp;
                }
            }
        }

		Map <String, Long> tiemposOrdenados = new LinkedHashMap<>();
		for (Object key : keys) {
			System.out.println(key + ": " + tiempos.get(key) + " nanosegundos");
			tiemposOrdenados.put((String) key, tiempos.get(key));
			
		}
		
		tiempos.clear();
		tiempos.putAll(tiemposOrdenados);
    }

		// Método para guardar los datos en un archivo de texto plano (TXT)
		private static void guardarComoTXT(Map<String, Long> tiempos, String nombreArchivo) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
				// Escribir cada algoritmo y su tiempo de ejecución en el archivo
				for (Map.Entry<String, Long> entry : tiempos.entrySet()) {
					writer.write(entry.getKey() + ": " + entry.getValue() + " nanosegundos");
					writer.newLine();
				}
				System.out.println("Datos de tiempo de ejecución guardados correctamente en formato TXT.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}