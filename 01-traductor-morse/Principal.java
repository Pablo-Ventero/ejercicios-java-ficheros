package Traduccion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Principal {
    public static void main(String[] args) {
        // Necesitamos un fichero para leer 
        // Vamos a escribir en otro fichero
        
        // 1. Array de caracteres (alfabeto y números)
        char[] letrasNumeros = {
            ' ','0','1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
            
        };

        // 2. Array de Strings (Código Morse correspondiente)
        String[] codigoMorse = {
            "/","-----",".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
        };
        try (
                BufferedReader contenido = new BufferedReader(new FileReader("Texto.txt"));
                BufferedWriter escribir = new BufferedWriter(new FileWriter("morse.txt"));
            ){
           
            String linea = "";
            while((linea = contenido.readLine())!=null){
                linea = linea.toUpperCase(); // lo pongo todo mayúsculas
                //recorremos carácter a carácter
                for (int i = 0; i < linea.length(); i++) {
                    char letra = linea.charAt(i); // E
                    //Buscamos la letra y esa posición la elegimos
                    // para escribir el morse
                    int pos = Arrays.binarySearch(letrasNumeros, letra); //14
                    // codigoMorse[14] lo escribe en morse.txt
                    escribir.write(codigoMorse[pos]); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error en los ficheros: "+e.getMessage());
        }
    }
}
