// OCULTAR PALABRAS: SIRVE PARA REEMPLAZAR LAS PALABRAS POR LOS '*'.

import java.util.Scanner;


public class OcultarPalabra {

    String stringPalabraSecreta;
    public static void main(String[] args) {
        String stringPalabraSecreta="";

        Scanner scannerPalabraSecreta = new Scanner(System.in);
        System.out.print("Ingrese Palabra Secreta: ");
        stringPalabraSecreta = scannerPalabraSecreta.nextLine();

        String palabraOculta = ocultarPalabra(stringPalabraSecreta);
        System.out.println("Palabra oculta: " + palabraOculta);
        scannerPalabraSecreta.close();
        System.out.println(stringPalabraSecreta);
    }

    public static String ocultarPalabra(String palabra) {
        StringBuilder palabraOculta = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            palabraOculta.append('*');
        }
        return palabraOculta.toString();
    }
    
}