package EjercicioExamen2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("productos.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("frutas.txt"))) {

            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                String nombre    = partes[0].trim();
                String categoria = partes[1].trim();
                double precio    = Double.parseDouble(partes[2].trim());

                if (categoria.equalsIgnoreCase("Fruta")) {
                    bw.write(nombre + " - " + precio + " EUR");
                    bw.newLine();
                    contador++;
                }
            }

            System.out.println("Total frutas encontradas: " + contador);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
