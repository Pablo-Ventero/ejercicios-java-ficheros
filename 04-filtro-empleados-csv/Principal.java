package EjercicioExamen3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("empleados.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("informatica.txt"))) {

            String linea;
            int contador = 0;
            double suma = 0;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                String nombre       = partes[0].trim();
                String departamento = partes[1].trim();
                double sueldo       = Double.parseDouble(partes[2].trim());

                if (departamento.equalsIgnoreCase("Informatica")) {
                    bw.write(nombre.toUpperCase() + " - " + sueldo + " EUR");
                    bw.newLine();
                    suma = suma + sueldo;  // acumulamos el sueldo
                    contador++;            // contamos el empleado
                }
            }

            // La media se calcula DESPUÉS del while
            double media = suma / contador;
            System.out.println("Salario medio Informatica: " + media + " EUR");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
