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
		int tam1 = 7; // Tamaño deseado para los arreglos
		int tam2 = 7;

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
		InglesaIterativoEstatico.multiplicaInglesa(arregloEstatico1, arregloEstatico2);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		tiempos.put("Inglesa Iterativo Estatico", elapsedTime);

		startTime = System.nanoTime();
		InglesaIterativoDinamico.multiplicaInglesa(new ArrayList<>(arregloDinamico1), new ArrayList<>(arregloDinamico2));
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Inglesa Iterativo Dinamico", elapsedTime);

		arregloEstatico1 = ObtenerArreglo(1, tam1);
		arregloEstatico2 = ObtenerArreglo(2, tam2);
		startTime = System.nanoTime();
		InglesaRecursivoEstatico.multiplicaInglesaRecursiva(arregloEstatico1, arregloEstatico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Inglesa Recursivo Estatico", elapsedTime);

		startTime = System.nanoTime();
		InglesaRecursivoDinamico.multiplicaInglesaRecursiva(new ArrayList<>(arregloDinamico1), new ArrayList<>(arregloDinamico2));
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Inglesa Recursivo Dinamico", elapsedTime);

		arregloEstatico1 = ObtenerArreglo(1, tam1);
		arregloEstatico2 = ObtenerArreglo(2, tam2);
		startTime = System.nanoTime();
		hinduIterativoEstatico.hindu(arregloEstatico1, arregloEstatico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Hindu Iterativo Estatico", elapsedTime);

		arregloEstatico1 = ObtenerArreglo(1, tam1);
		arregloEstatico2 = ObtenerArreglo(2, tam2);
		startTime = System.nanoTime();
		AmericanoIterativoEstatico.Multitradicional2(arregloEstatico1, arregloEstatico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Americano Iterativo Estatico", elapsedTime);

		startTime = System.nanoTime();
		AmericanoIterativoEstaticoDinamico.Multitradicional2(new ArrayList<>(arregloDinamico1), new ArrayList<>(arregloDinamico2));
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Americano Iterativo Dinamico", elapsedTime);

		startTime = System.nanoTime();
		AmericanoRecursivoDinamico.americanoRecursivo(new ArrayList<>(arregloDinamico1), new ArrayList<>(arregloDinamico2));
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Americano Recursivo Dinamico", elapsedTime);

		arregloEstatico1 = ObtenerArreglo(1, tam1);
		arregloEstatico2 = ObtenerArreglo(2, tam2);
		startTime = System.nanoTime();
		AmricanoRecursivoEstatico.americanoRecursivo(arregloEstatico1, arregloEstatico2);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Americano Recursivo Estatico", elapsedTime);

		arregloEstatico1 = ObtenerArreglo(1, tam1);
		arregloEstatico2 = ObtenerArreglo(2, tam2);
		startTime = System.nanoTime();
		DV.dv1(arregloEstatico1, arregloEstatico2, tam1);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		tiempos.put("Divide y Venceras", elapsedTime);

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