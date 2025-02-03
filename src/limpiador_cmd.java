import java.io.IOException;
import java.util.ArrayList;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class limpiador_cmd {

    // Se realiza un bucle for para generar lineas a borrar.
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            System.out.println("Lineas a borrar");
        }
        limpiarPantalla();

    }

    // INICIO DE FUNCIÓN PARA LIMPIAR PANTALLA. ES PARA CMD UNICAMENTE.
    public static void limpiarPantalla(){
        /*
         Se utiliza para ingresar a la función la presión de la
         tecla ENTER.
         */
        try{
            System.out.println("Presione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();

            /*
             Dado que el sistema que utiliza Windows como terminal (cmd),
             acepta la palabra 'cls' para borrar, se le realiza una petición
             mediante la utilización del 'if', verificando que el sistema 
             operativo sea Windows. Una vez en este se le mandan a ingresar 
             por medio de 'comando.add' al sistema (cmd), que se dirija al 
             sistema principal (/c) para luego realizar el borrado de su contenido
             mediante (cls)
             */

            String sistemaOperativo = System.getProperty("os.name");
            /* 
            Se realiza el 'ArrayList' para obtener la cadena de caracteres
            que contiene la palabra Windows.
            RECUERDA QUE ESTA FUNCIÓN SE EJECUTA UNICAMENTE EN EL CMD(terminal) DE WINDOWS.
            */
            ArrayList<String> comando = new ArrayList<String>();
            // analiza si la cadena de catacteres coincide con las encontradas.
            if (sistemaOperativo.contains("Windows")) {
                // Al estar bien la cadena de caracteres, se agregan las ejecuciones deseadas.
                comando.add("cmd");
                comando.add("/c");
                comando.add("cls");

                /*
                 Siendo que pueden estar utilizando otro sistema
                 operativo vasados en UNIX: como el de Mac o Linux, se realiza un
                 'else' y se aplica 'clear' para que realice la 
                 limpieza de la pantalla.
                 */
            }else{
                comando.add("clear");
            }
            // Se crea un 'ProcessBuilder', con esto se realiza la llamada al sistema.
            ProcessBuilder pb = new ProcessBuilder(comando);
            /*
            Con 'Process' vincula la salida del comando que se realiza con el 
            proceso de toda la función que se está ejecutando
            */
            Process iniciProcess = pb.inheritIO().start();
            iniciProcess.waitFor();
        }catch(Exception e){
            System.err.println("ERROR: problemas al limpiar la pantalla "+e.getMessage());
        }
    }

// INICIO FUNCIÓN PARA LIMPIAR PANTALLA DE EDITOR DE CÓDIGO
    public static void limpiarAnt(){
        // Se da ingreso a la función mediante la presión de tecla ENTER.
        try{
            System.out.println("Presione ENTER para continuar: ");
            new java.util.Scanner(System.in).nextLine();
/*
 Se llaman mediante la librería importada 'Robot' a las distintas
 teclas necesarias para poder limpiar la pantalla de la terminal
 que utiliza nuestro editor de código. Puede ser Windows o Linux.
 En este caso se utiliza para limpiar, las teclas 'Control (Ctrl)'
 más la tecla 'L'.
 */
            Robot pressbot = new Robot();
            pressbot.keyPress(KeyEvent.VK_CONTROL);
            pressbot.keyPress(KeyEvent.VK_L);
            pressbot.keyRelease(KeyEvent.VK_CONTROL);
            pressbot.keyRelease(KeyEvent.VK_L);

            // Al utilizar el método 'try' se realiza la excepción de error.
        }catch(AWTException ex){
            System.out.println(""+ex.getMessage());
        }
    }
    // FIN DE FUNCIÓN LIMPIAR PANTALLA.

}
