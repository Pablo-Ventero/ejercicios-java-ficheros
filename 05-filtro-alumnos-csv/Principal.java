package EjercicioExamen1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        // Abrimos los dos ficheros en el mismo try
        try (BufferedReader br = new BufferedReader(new FileReader("alumnos.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("aprobados_madrid.txt"))) {

            String linea;

            // Recorremos el fichero línea a línea
            while ((linea = br.readLine()) != null) {

                // Separamos los campos por la coma
                String[] partes = linea.split(",");

                String nombre = partes[0].trim();
                double nota   = Double.parseDouble(partes[1].trim());
                String ciudad = partes[2].trim();

                // Filtramos Madrid y aprobados
                if (ciudad.equalsIgnoreCase("Madrid") && nota >= 5) {
                    bw.write(nombre + " - " + nota);
                    bw.newLine();
                }
            }

            System.out.println("Fichero generado correctamente");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
