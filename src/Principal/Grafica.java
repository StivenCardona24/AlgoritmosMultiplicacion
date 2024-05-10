package Principal;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class Grafica extends ApplicationFrame {

    public Grafica(String title) {
        super(title);
    }

    public static void main(String[] args) {
        // Leer los datos del primer archivo de tiempos
        Map<String, Long> tiempos1 = leerDatosDesdeTXT("tiempos15x15.txt");
        // Leer los datos del segundo archivo de tiempos
        Map<String, Long> tiempos2 = leerDatosDesdeTXT("tiempos7x7.txt");

        // Crear un conjunto de datos para la gráfica
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Long> entry : tiempos1.entrySet()) {
            dataset.addValue(entry.getValue(), "Multiplicación 15 x 15", entry.getKey());
        }
        for (Map.Entry<String, Long> entry : tiempos2.entrySet()) {
            dataset.addValue(entry.getValue(), "Multiplicación 7 x 7", entry.getKey());
        }

        // Crear la gráfica
        JFreeChart chart = ChartFactory.createBarChart(
                "Tiempo de Ejecución de Algoritmos",
                "Algoritmo",
                "Tiempo (nanosegundos)",
                dataset);

        // Crear y configurar el panel de la gráfica
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        // Mostrar la gráfica en una ventana
        JFrame frame = new JFrame("Gráfico de Tiempos de Ejecución");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    // Método para leer los datos desde un archivo de tiempos
    private static Map<String, Long> leerDatosDesdeTXT(String nombreArchivo) {
        Map<String, Long> tiempos = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en algoritmo y tiempo
                String[] partes = linea.split(":");
                String algoritmo = partes[0].trim();
                long tiempo = Long.parseLong(partes[1].trim().split(" ")[0]);
                tiempos.put(algoritmo, tiempo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiempos;
    }
}
