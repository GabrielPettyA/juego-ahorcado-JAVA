import java.util.ArrayList;
import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        String palabraSecreta;

        Scanner scannerName = new Scanner(System.in);
        Scanner scannerPalabraSecreta = new Scanner(System.in);

        System.out.println("APRETE 'ENTER' PARA COMENZAR.\n SUERTE !!!");

        // inicio de expresión de java para leer entrada de textos de la consola.
        new java.util.Scanner(System.in).nextLine();
        // Inicio de comando de java para obtener el nombre del sistema operativo en el que se ejecuta la aplicación.
        String sistemaOperativo = System.getProperty("os.name");
        // Inicio para ingresar la palabra secreta a hacer adivinada.
        System.out.print("Ingrese Palabra Secreta: ");
        String stringPalabraSecreta = scannerPalabraSecreta.nextLine();
        palabraSecreta = stringPalabraSecreta;

        // Se crea una lista de objetos de tipo String
        ArrayList<String> comando = new ArrayList<String>();
        // Se verifica si el nombre del sistema operativo coincide, en este caso con Windows.
        if (sistemaOperativo.contains("Windows")) {
            // Al estar bien la cadena de caracteres, se agregan las ejecuciones deseadas.
            comando.add("cmd");// Se llama al cmd.
            comando.add("/c");// Se determina donde está parado el cursor.
            comando.add("cls");// Se pasan los caracteres reconocidos por el sistema para borrar toda linea anterior al mismo.
        }else{
            comando.add("clear");/* Siendo que pueden estar utilizando otro sistema
            operativo vasados en UNIX: como el de Mac o Linux, se realiza un
            'else' y se aplica 'clear' para que realice la 
            limpieza de la pantalla.*/
        }
        // Se crea un 'ProcessBuilder', con esto se realiza la llamada al sistema.
        ProcessBuilder pb = new ProcessBuilder(comando);
        /*
        Con 'Process' vincula la salida del comando que se realiza con el 
        proceso de toda la función que se está ejecutando
        */
        Process iniciProcess = pb.inheritIO().start();
        iniciProcess.waitFor();

        // Se llama a la Función 'ocultarPalabra' que se encuentra debajo".
        String palabraOculta = ocultarPalabra(stringPalabraSecreta);
        // Una vez ocultada la palabra, se imprime para solo mostrar los caracteres con '*'.
        System.out.println("Palabra oculta: " + palabraOculta);

        
        // Variables inicializadas según requerimientos del juego.
        int intentosMaximos = 5;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Inicio de lectura de la palabra secreta para poder ser comparada a cada letra ingresada.
        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        // Print para que el usuario pueda visualizar las normas del juego antes de ingresar palabras.
        System.out.println("\n REGLAS:\n Tienes " + intentosMaximos
                + " intentos para adivinar la palabra secreta.\n Pasados dichos intentos, si no adivina, ust. pierde.\n");
        System.out.println("\nPalabra de " + palabraSecreta.length() + " letras.");

        // Inicio bucle 'while' para poder leer letra ingresada y comparar a letras que contiene la palabra secreta seleccionada.
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
            // En caso de detectar el bucle 'for' que la letra ingresada es incorrecta(false), imprime estado de oportunidades.
            if (!letraCorrecta) {
                intentos++;
                System.out.println("\n¡Incorrecto! ...quedaron " + (intentosMaximos - intentos) + " intentos.");
            }
            // En caso de detectar que se ingresaron las letras correctas(true), se da por terminado el juego mostrando la palabra secreta.
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                String palabra = palabraSecreta.toUpperCase();
                System.out.println("\n¡FELICIDADES, \n"+ " " + palabra + " es la palabra secreta !!!");
            }
        }
        // Si las letras ingresadas son incorrectas(false) y la cantidad de oportunidades es igual a cero, se cierra el juego.
        if (!palabraAdivinada) {
            System.out.println(" GAME OVER \n¡Qué pena, intente nuevamente!");
        }

        /* IMPORTANTE: recuerda que se debe cerrar el llamado de 'Scanner' para que el 
        sistema ya no quede escuchando si hay algún otro ingreso de parte del usuario. */
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
