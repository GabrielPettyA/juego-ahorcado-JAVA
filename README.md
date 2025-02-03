# Bienvenidos al juego 'Ahorcado'

Este es el juego del ahorcado realizado mediante el lenguaje de programación 
'Java', el mismo consta de adivinar la palabra secreta seleccionada para poder
ganar, pero ojo! usted tiene una cantidad limitada de oportunidades para poder 
acertar las letras que forman la palabra antes ser derrotado.

## Nombre de Repositorio

juego-ahorcado-JAVA

# Características del juego.

Se presenta con las reglas básicas para poder iniciar el juego. Contiene 
un ingreso de palabra, el cual se lo pedirá el sistema, para poder determinar 
que palabra secreta será la dispuesta para adivinar.
Tendrá 5 oportunidades para adivinar la palabra, mediante la selección de una 
letra, antes de terminar con sus oportunidades, de no adivinar en este período, 
el sistema dará por terminado el juego, el mismo le mostrará, en caso de no 
acertar con su letra, la cantidad de opciones que le queda antes de dar por 
concluido el juego. Pero en caso de que su letra sea la correcta, le ocupará en 
el lugar designado dicha letra, según la palabra secreta seleccionada. De 
finalizar toda la palabra, el sistema lo declarará como ganador mostrándole la 
palabra secreta adivinada.

# Herramientas utilizadas.

1. Importación de librería java.util.Scanner.
2. Clase con declaración public.
3. Funciones con declaración public static al igual que el main.
4. Variables de tipo String, int y boolean.
5. Construcción de Scanner: new Scanner.
6. Bucles: for, while y sus respectivos condicionales.
7. Utilización de return, valueOf.
8. Super implementaciones: length(), length, close(), charAt(), equals(), 
   append() y toString().
9. Impresión en terminal: println y print para controlar en qué linea 
   deseamos mostrar el texto o cursor.
10. Utilización de métodos: toLowerCase(), toUpperCase() y nextLine()
11. Clases:  StringBuilder y System.
12. Expresión de Java: new java.util.Scanner(System.in)
13. Comando Java: System.getProperty("os.name")
14. llamando a función 'ocultarPalabra()'.

# EXTRA !!!

    Se agrega archivo extra con limpiadores de pantalla en caso de que deseen 
    utilizarlo de manera voluntaria según le parezca. El archivo solo se 
    encuentra a modo de ejemplificar algunas alternativas para limpiar las
    pantallas tanto de cmd, en caso de bajar el código para poder utilizarlo
    localmente, como también, en la terminal del editor de código.
    Fue agregado a este juego a modo de poder brindar una información extra 
    para poder utilizar si así lo requieren. La función se utiliza para poder 
    limpiar la terminal local del Visual Studio Code, permitiendo de esta
    forma, que el jugador que debe adivinar la palabra secreta, no pueda
    visualizarla una vez que fue escrita.
    También se agrega archivo 'OcultarPalabra.java'. El mismo muestra como
    ejemplo, el código para poder ocultar una palabra mediante el reemplazo
    de la misma por '*'. Dicho método fue empleado en el juego a modo de
    ejemplificar como se puede usar, adaptándolo a éste.