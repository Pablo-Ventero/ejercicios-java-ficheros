package EjercicioLeerFichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Contador del World");
        try {BufferedReader contenido = new BufferedReader(new FileReader("LazarilloDeTormes.txt"));
        
        //Contar palabras, letras, caracteres con espacio y sin espacio, parrafos y contar lineas si te digo el tamaño.
        String linea = null;
        int acumuladorCon = 0;
        int contaParrafos = 0; //Contar todos los parrafos
        int acumuladorPal = 0; //Contar todas las palabras
        int acumuladorSin = 0;
        while((linea=contenido.readLine())!=null){
            contaParrafos++;
            //Guardamos y acumulamos los caracteres por cada parrafo
            int caracteresCon = linea.length();
            acumuladorCon += caracteresCon;
            //Guardamos y acumulamos las palabras, tamaño del array
            String[] parrafo = linea.split("   ");
            int contadorPal = parrafo.length;
            acumuladorPal += contadorPal;
            //Ahora contamos las palabras sin espacios desde el parrafo[]
            int acumuladorLetras = 0;
            for (String s : parrafo) { //Por cada palabra acumulo el numero de letras
                acumuladorLetras += s.length();
            }
            acumuladorSin += acumuladorLetras;
        }
            System.out.println("Los parrafos son: " + contaParrafos);
            System.out.println("Caracteres con espacio: " + acumuladorCon);
            System.out.println("Palabras del texto: " + acumuladorPal);
            System.out.println("Caracteres sin espacio: " + acumuladorSin);
            
        } catch (IOException e) {
            System.err.println("Error en la lectura: " + e.getMessage());
        }
        
        System.out.println("Fin del programa");
    }
}
