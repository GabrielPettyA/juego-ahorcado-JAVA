import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        Scanner scannerName = new Scanner(System.in);

        String palabraSecreta;

        Scanner scannerPalabraSecreta = new Scanner(System.in);
        System.out.print("Ingrese Palabra Secreta: ");
        String stringPalabraSecreta = scannerPalabraSecreta.nextLine();
        palabraSecreta = stringPalabraSecreta;

        String palabraOculta = ocultarPalabra(stringPalabraSecreta);
        System.out.println("Palabra oculta: " + palabraOculta);

        
        
        int intentosMaximos = 5;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        System.out.println("REGLAS:\n Tienes " + intentosMaximos
                + " intentos para adivinar la palabra secreta.\n Pasados dichos intentos, si no adivina, ust. pierde.");
        System.out.println("\nPalabra de " + palabraSecreta.length() + " letras.");

        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("\n ( " + String.valueOf(letrasAdivinadas) + " )");

            System.out.print("Introduce letra, por favor: ");
            char letra = Character.toLowerCase(scannerName.next().charAt(0));

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("\n¡Incorrecto! ...quedaron " + (intentosMaximos - intentos) + " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                String palabra = palabraSecreta.toUpperCase();
                System.out.println("¡Felicidades, " + palabra + " es la palabra secreta !!!");
            }
        }

        if (!palabraAdivinada) {
            System.out.println(" GAME OVER \n¡Qué pena, intente nuevamente!");
        }

        scannerName.close();
        scannerPalabraSecreta.close();


        

    }
    public static String ocultarPalabra(String palabra) {
        StringBuilder palabraOculta = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            palabraOculta.append('*');
        }
        return palabraOculta.toString();
    }


}
