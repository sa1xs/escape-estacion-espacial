/*INF-02: FUNDAMENTOS DE PROGRAMACION
 * PROYECTO FINAL: ESCAPE DE LA ESTACION ESPACIAL
 * ESTUDIANTES:
 * JOSE ARTURO GUTIERREZ MURILLO
 * SEBASTIAN SALAS HERNANDEZ
 * KEYLIN CASTILLO BARQUERO 
 */

import java.io.*;

public class EscapeEstacionEspacial {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //Instancia global de buffered reader para lectura de datos de usuario
    static PrintStream out = System.out;
    static boolean juegoActivo = true; //Booleano global para control la ejecución del juego
    static String[] pistasObtenidas = {"-","-","-","-","-","-","-","-","-","-"}; //Arreglo global de strings que almacenas las pistas que se han ido obteniendo
    static String [] opcionesUsuario = {"-1", "-1", "-1"}; //Arreglo global de strings que almacena las posibles opciones para las interacciones de cada habitación
    static int ubicacionMapa = 1; // Variable global para ubicar al jugador en el mapa.
    static int cantidadTurnos = 350; //Variable global para llevar la cuenta de turnos disponibles
    static int golpesAcumulados = 0; //Variable global para llevar los golpes acumulados del usuario
    static boolean [] objetivosCompletados = {false,false,false,false,false,false,false,false,false,false}; //Arreglo global de booleanos para llevar el control de los objetivos completados y fallados
    static boolean [] puertasAbiertas = {false,false,false}; //Arreglo global de booleanos para llevar el control de las puertas abiertas en el mapa
    static boolean juegoCompletado = false;
    public static void main(String[] args) throws IOException {
        introduccionAlJuego();
        reglasGenerales();
        do {
            switch (ubicacionMapa) {
                case 1:
                System.err.println("");
                System.err.println("");
                mapaEstacionEspacial();
                interaccionesHabitacionUno();
                    break;

                case 2:
                System.err.println("");
                System.err.println("");
                mapaEstacionEspacial();
                interaccionesHabitacionDos();
                    break;

                case 3:
                System.err.println("");
                System.err.println("");
                mapaEstacionEspacial();
                interaccionesHabitacionTres();
                    break;
            }
        } while (juegoActivo && (golpesAcumulados <= 60) && (cantidadTurnos > 0));
        mensajeFinal();
    }

    static void mensajeFinal () {
        if (juegoCompletado) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ESCAPE ESPACIAL EXITOSO, BIEN HECHO RYAN...");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ESCAPE ESPACIAL FALLADO.");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        }        
    }

    static void introduccionAlJuego() throws IOException{
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ESCAPE DE LA ESTACION ESPACIAL");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Después de una misión rutinaria de mantenimiento, el astronauta Ryan Voltan despierta confundido, desorientado y completamente solo, \n" + //
                        "luego de haber presenciado una gran explosión generada en uno de los reactores principales de la estación espacial Orion-7. Tras incorporarse,\n" + //
                        "Ryan examina brevemente el estado de la estación y concluye que en cualquier instante la estación podría volar en miles de pedazos. Al darse cuenta\n" + //
                        "de su situación, Ryan estará a punto de incursionar en la hazaña más importante de su vida. Sin más ayuda que su ingenio, traje espacial y las herramientas\n" + //
                        "que encuentre, Ryan deberá ir realizando misiones, resolviendo acertijos y tareas de distintos tipos para intentar ingresar a la cápsula de escape, lugar \n" + //
                        "donde se encuentra su única oportunidad para sobrevivir.");
    }

    static void reglasGenerales() throws IOException{
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("REGLAS GENERALES");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. Explora la estación, reune información y completa los objetivos para poder escapar.");
        System.out.println("2. Tienes que escapar de la estación en menos de XXX turnos. Cada intereacción te hace gastar un turno, así que no regreses a objetivos que ya completaste.");
        System.out.println("3. Puedes recibir como máximo 5 golpes. Si excedes esa cantidad de golpes pierdes automaticamente.");
        System.out.println("4. Si crees que no lo vas a lograr, puedes aplicar muerter asistida, lo que te hará perder la partida automáticamente.");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Presiona enter para continuar");
        in.readLine();
    }

    static void mapaEstacionEspacial() {
        int puertasCompletadas = 0;
        for (int i = 0; i < puertasAbiertas.length; i++) {
            if (puertasAbiertas[i]) {
                puertasCompletadas = puertasCompletadas + 1;
            }
        }
        switch (puertasCompletadas) {
            case 1:
                System.out.println("*--------+---------+--------**----------------------------------------*+--------------+------------+\n" + //
                                        "|        | PLANTA  |        ||                                        ||              |            |\n" + //
                                        "|        |ELECTRICA|        ||               LABORATORIO              || HERRAMIENTAS |   ARMARIO  |\n" + //
                                        "|        +---------+        ||                                        ||              |            |\n" + //
                                        "|                           |*----------------------------------------*+--------------+------------+\n" + //
                                        "|                           ||                                        ||                        +--+\n" + //
                                        "+---+                                                                *****                      |S |\n" + //
                                        "| P |                                                                * P *                      |W |\n" + //
                                        "| I |                                                                * U *                      |I |\n" + //
                                        "| Z |                                                                * E *                      |T |\n" + //
                                        "| A |                                                                * R *                      |C |\n" + //
                                        "| R |                                                                * T *                      |H |\n" + //
                                        "| R |                                                                * A *      +########+      +--+\n" + //
                                        "| A |                                                                *****      #        #         |\n" + //
                                        "+---+                       ||                                        ||        #  NAVE  #         |\n" + //
                                        "|                           ||                     +------------------+|        #        #         |\n" + //
                                        "|                           |*-----------+         |                  ||        +########+         |\n" + //
                                        "|       +-----------+       ||   CENTRO  +---------+     GIMNASIO     ||                           |\n" + //
                                        "|       |CONTROLADOR|       ||   MEDICO  |BASURERO |                  ||                           |\n" + //
                                        "*-------+-----------+-------**-----------+---------+------------------+*----******SALIDA******-----*");
                break;
            case 2:
                System.out.println("*--------+---------+--------**----------------------------------------*+--------------+------------+\n" + //
                                        "|        | PLANTA  |        ||                                        ||              |            |\n" + //
                                        "|        |ELECTRICA|        ||               LABORATORIO              || HERRAMIENTAS |   ARMARIO  |\n" + //
                                        "|        +---------+        ||                                        ||              |            |\n" + //
                                        "|                           |*----------------------------------------*+--------------+------------+\n" + //
                                        "|                           ||                                        ||                        +--+\n" + //
                                        "+---+                                                                                           |S |\n" + //
                                        "| P |                                                                                           |W |\n" + //
                                        "| I |                                                                                           |I |\n" + //
                                        "| Z |                                                                                           |T |\n" + //
                                        "| A |                                                                                           |C |\n" + //
                                        "| R |                                                                                           |H |\n" + //
                                        "| R |                                                                           +########+      +--+\n" + //
                                        "| A |                                                                           #        #         |\n" + //
                                        "+---+                       ||                                        ||        #  NAVE  #         |\n" + //
                                        "|                           ||                     +------------------+|        #        #         |\n" + //
                                        "|                           |*-----------+         |                  ||        +########+         |\n" + //
                                        "|       +-----------+       ||   CENTRO  +---------+     GIMNASIO     ||                           |\n" + //
                                        "|       |CONTROLADOR|       ||   MEDICO  |BASURERO |                  ||                           |\n" + //
                                        "*-------+-----------+-------**-----------+---------+------------------+*----******SALIDA******-----*");
                break;
            case 3:
                System.out.println("*--------+---------+--------**----------------------------------------*+--------------+------------+\n" + //
                                        "|        | PLANTA  |        ||                                        ||              |            |\n" + //
                                        "|        |ELECTRICA|        ||               LABORATORIO              || HERRAMIENTAS |   ARMARIO  |\n" + //
                                        "|        +---------+        ||                                        ||              |            |\n" + //
                                        "|                           |*----------------------------------------*+--------------+------------+\n" + //
                                        "|                           ||                                        ||                        +--+\n" + //
                                        "+---+                                                                                           |S |\n" + //
                                        "| P |                                                                                           |W |\n" + //
                                        "| I |                                                                                           |I |\n" + //
                                        "| Z |                                                                                           |T |\n" + //
                                        "| A |                                                                                           |C |\n" + //
                                        "| R |                                                                                           |H |\n" + //
                                        "| R |                                                                           +########+      +--+\n" + //
                                        "| A |                                                                           #        #         |\n" + //
                                        "+---+                       ||                                        ||        #  NAVE  #         |\n" + //
                                        "|                           ||                     +------------------+|        #        #         |\n" + //
                                        "|                           |*-----------+         |                  ||        +########+         |\n" + //
                                        "|       +-----------+       ||   CENTRO  +---------+     GIMNASIO     ||                           |\n" + //
                                        "|       |CONTROLADOR|       ||   MEDICO  |BASURERO |                  ||                           |\n" + //
                                        "*-------+-----------+-------**-----------+---------+------------------+*----                  -----*");
                break;
            default:
                System.out.println("*--------+---------+--------**----------------------------------------*+--------------+------------+\n" + //
                                        "|        | PLANTA  |        ||                                        ||              |            |\n" + //
                                        "|        |ELECTRICA|        ||               LABORATORIO              || HERRAMIENTAS |   ARMARIO  |\n" + //
                                        "|        +---------+        ||                                        ||              |            |\n" + //
                                        "|                           |*----------------------------------------*+--------------+------------+\n" + //
                                        "|                           ||                                        ||                        +--+\n" + //
                                        "+---+                      *****                                     *****                      |S |\n" + //
                                        "| P |                      * P *                                     * P *                      |W |\n" + //
                                        "| I |                      * U *                                     * U *                      |I |\n" + //
                                        "| Z |                      * E *                                     * E *                      |T |\n" + //
                                        "| A |                      * R *                                     * R *                      |C |\n" + //
                                        "| R |                      * T *                                     * T *                      |H |\n" + //
                                        "| R |                      * A *                                     * A *      +########+      +--+\n" + //
                                        "| A |                      *****                                     *****      #        #         |\n" + //
                                        "+---+                       ||                                        ||        #  NAVE  #         |\n" + //
                                        "|                           ||                     +------------------+|        #        #         |\n" + //
                                        "|                           |*-----------+         |                  ||        +########+         |\n" + //
                                        "|       +-----------+       ||   CENTRO  +---------+     GIMNASIO     ||                           |\n" + //
                                        "|       |CONTROLADOR|       ||   MEDICO  |BASURERO |                  ||                           |\n" + //
                                        "*-------+-----------+-------**-----------+---------+------------------+*----******SALIDA******-----*");
        }
    }

    static void mostrarEstado () throws IOException {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ESTADO");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Nombre: Ryan Voltan");
        System.out.println("Golpes acumulados: " + golpesAcumulados);
        System.out.println("Turnos disponibles " + cantidadTurnos );
        System.out.print("Presiona enter para continuar");
        in.readLine();
    }

    static void mostrarInformacionEncontrada () throws IOException   {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("INFORMACION ENCONTRADA");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < pistasObtenidas.length; i++) {
            System.out.println(pistasObtenidas[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Presiona enter para continuar");
        in.readLine();
    }

    static void interaccionesHabitacionUno () throws IOException {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("HABITACION #1");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. Ver pizarra con garabatos escritos");
        System.out.println("2. Recuperar control de puertas");
        System.out.println("3. Reestablecer energía de estación espacial");
        System.out.println("4. Abrir puerta para habitación #2");
        System.out.println("5. Avanzar a habitación #2");
        System.out.println("6. Mostrar estado");
        System.out.println("7. Mostrar información encontrada");
        System.out.println("0. Muerte asistida");
        System.out.print("Digita tu siguiente movimiento: ");
        opcionesUsuario[0] = in.readLine(); 
        switch (opcionesUsuario[0]) {
            case "1":
            interaccionPizarra();
                break;
            case "2":
            interaccionReinicioControlPuertas();
                break;
            case "3":
            interaccionReestablecerEnergia();
                break;
            case "4":
            interaccionAbrirPuertaUno();
                break;
            case "5":
            avanzarHabitacionDos();
                break;
            case "6":
            mostrarEstado();
                break;
            case "7":
            mostrarInformacionEncontrada();
                break;
            case "0":
            juegoActivo = false;
            break;
        
            default:
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Opción inválida, acumulaste un golpe y perdiste un turno..");
            cantidadTurnos = cantidadTurnos - 1;
            golpesAcumulados = golpesAcumulados + 1;
            System.out.print("Presiona enter para continuar");
            in.readLine();
                break;
        }
    }

    static void interaccionPizarra () throws IOException {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("PIZARRA");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (objetivosCompletados[2]) {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            System.out.println("En la pizarra se aprecia una gran cantidad de apuntes, cálculos, referencias y garabatos...");
            System.out.println("De todos los trazos distingues un patrón especifico: 1-1-0-1. No tienes idea a qué se refiere pero decides guardarlo en tu inventario.");
            pistasObtenidas[2] = "3. Patrón de pizarra: 1-1-0-1.";
            objetivosCompletados[2] = true;
            cantidadTurnos = cantidadTurnos - 1;
            System.out.print("Presiona enter para continuar");
            in.readLine();
        }
    }

    static void interaccionReinicioControlPuertas() throws IOException {
        //Definicion de variables locales al método para realizar la prueba
        String controlPuertasBienvenida = "Para reestablecer el sistema de control de puertas tendras que responder una serie de preguntas correctamente. Cada error que cometas acumulará golpes";
        String controlPuertasPreguntaUno = "2 X 3 + 5 X (9 / 3)";
        String controlPuertasPreguntaDos = "3x - 6 + 4x + 4 = 19";
        String controlPuertasPreguntaTres = "Un cubo tiene un volumen de 64 centímetros cúbicos. ¿Cuánto mide su arista?";
        String controlPuertasPreguntaCuatro = "Un poste vertical de 2,5 metros proyecta una sombra de 1,5 metros. Determine la altura que tiene un árbol que a la misma hora proyecta una sombra de 6 metros.";
        String controlPuertasError = "Respuesta incorrecta, debes iniciar desde el comienzo!";
        String controlPuertasCorrecto = "Respuesta correcta!. Siguiente problema:";
        String controlPuertasExitoso = "Respuesta correcta. Todas las preguntas fueron contestadas correctamente! Ya puedes interactuar con las puertas...";
        String opcionUsuario = "";

        if (objetivosCompletados[0]) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("REINICIO CONTROL DE PUERTAS");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            if (objetivosCompletados[1]) {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("Ya completaste esta interacción, perdiste un turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            } else {
                System.out.println(controlPuertasBienvenida);
                System.out.println("¿Estás listo para intentar el desafío? (S/N)");
                opcionUsuario = in.readLine().trim().toLowerCase();
                if (opcionUsuario.equals("s")) {
                    System.out.println("Resuelve la siguiente operacion:");
                    System.out.println(controlPuertasPreguntaUno);
                    int controlPuertasRespuestaUno = Integer.parseInt(in.readLine());
                    if (controlPuertasRespuestaUno == 21) {
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(controlPuertasCorrecto);
                        System.out.println("Resuelve la siguiente ecuacion:");
                        System.out.println(controlPuertasPreguntaDos);
                        int controlPuertasRespuestaDos = Integer.parseInt(in.readLine());
                        if (controlPuertasRespuestaDos == 3) {
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(controlPuertasCorrecto);
                            System.out.println(controlPuertasPreguntaTres);
                            int controlPuertasRespuestaTres = Integer.parseInt(in.readLine());
                            if (controlPuertasRespuestaTres == 4) {
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(controlPuertasCorrecto);
                                System.out.println(controlPuertasPreguntaCuatro);
                                int controlPuertasRespuestaCuatro = Integer.parseInt(in.readLine());
                                if (controlPuertasRespuestaCuatro == 10) {
                                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println(controlPuertasExitoso);
                                    cantidadTurnos = cantidadTurnos - 1;
                                    objetivosCompletados[1] = true;
                                    pistasObtenidas[1] = "2. Ya se puede interacturar con las puertas (875).";
                                    System.out.print("Presiona enter para continuar");
                                    in.readLine();
                                } else {
                                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println(controlPuertasError);
                                    System.out.println("Desafío cancelado, recibiste un golpe y perdiste un turno..");
                                    golpesAcumulados = golpesAcumulados + 1;
                                    cantidadTurnos = cantidadTurnos - 1;
                                    System.out.print("Presiona enter para continuar");
                                    in.readLine();
                                }
                            } else {
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(controlPuertasError);
                                System.out.println("Desafío cancelado, recibiste un golpe y perdiste un turno..");
                                golpesAcumulados = golpesAcumulados + 1;
                                cantidadTurnos = cantidadTurnos - 1;
                                System.out.print("Presiona enter para continuar");
                                in.readLine();
                            }
                        } else {
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(controlPuertasError);
                            System.out.println("Desafío cancelado, recibiste un golpe y perdiste un turno..");
                            golpesAcumulados = golpesAcumulados + 1;
                            cantidadTurnos = cantidadTurnos - 1;
                            System.out.print("Presiona enter para continuar");
                            in.readLine();
                        }
                    } else {
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(controlPuertasError);
                        System.out.println("Desafío cancelado, recibiste un golpe y perdiste un turno.");
                        golpesAcumulados = golpesAcumulados + 1;
                        cantidadTurnos = cantidadTurnos - 1;
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                    }
                } else {
                    cantidadTurnos = cantidadTurnos - 1;
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Desafío cancelado, perdiste un turno.");
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                }   
            }
        } else {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("La energía no está activada, no puedes realizar esta tarea. Perdiste un turno.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        }
    }

    static void interaccionReestablecerEnergia () throws IOException {
        int antonimosCorrectos = 0;
        String [] columnaUno = {"a.Claro","  b.Realidad","  c.Sol","  d.Valiente"};
        String [] columnaDos = {"1.Luna","  2.Cobarde","  3.Oscuro","  4.Ficcion"};
        String intentoPar;
        String opcionUsuario = "";
        boolean sinGolpes = true;
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("REESTABLECER ENERGIA DE ESTACION ESPACIAL");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (objetivosCompletados[0]) {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            System.out.println("Para completar el desafío tienes que relacionar las palabras entre sí, digitando la combinación 'numero+letra' respectiva.");
            System.out.println("¿Estás listo para intentar el desafío? (S/N)");
            opcionUsuario = in.readLine().trim().toLowerCase();
            if (opcionUsuario.equals("s")) {
                while ((antonimosCorrectos<4) && sinGolpes ) {
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Relaciona las palabras");
                    for (int i = 0; i < columnaUno.length; i++) {
                        if (i == columnaUno.length-1) {
                            System.out.print(columnaUno[i] );
                        } else {
                            System.out.print(columnaUno[i] + "," );
                        }
                    }
                    System.out.println();
                    for (int i = 0; i < columnaDos.length; i++) {
                        if (i == columnaDos.length-1) {
                            System.out.print(columnaDos[i] );
                        } else {
                            System.out.print(columnaDos[i] + "," );
                        }
                    }
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.print("Introduce un par de letra+numero:");
                    intentoPar = in.readLine().trim().toLowerCase();
                    switch (intentoPar) {
                        case "a3","3a":
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Par correcto!");
                        antonimosCorrectos++;
                        columnaUno[0] = "*******";
                        columnaDos[2] = "  ********";
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                            break;
                        case "b4","4b":
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Par correcto!");
                        antonimosCorrectos++;
                        columnaUno[1] = "  **********";
                        columnaDos[3] = "  *********";
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                            break;
                        case "c1","1c":
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Par correcto!");
                        antonimosCorrectos++;
                        columnaUno[2] = "  *****";
                        columnaDos[0] = "******";
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                            break;
                        case "d2","2d":
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Par correcto!");
                        antonimosCorrectos++;
                        columnaUno[3] = "  **********";
                        columnaDos[1] = "  *********";
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                            break;
                        default:
                        cantidadTurnos = cantidadTurnos - 1;
                        golpesAcumulados = golpesAcumulados + 1;
                        sinGolpes = false;
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("El par que introduciste es incorrecto.");
                        System.out.println("Desafío cancelado, recibiste un golpe y perdiste un turno.");
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                            break;
                    }
                }
                if (antonimosCorrectos == 4) {
                    cantidadTurnos = cantidadTurnos - 1;
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Desafío completado, se reestableció la energía de la estación espacial.");
                    objetivosCompletados[0] = true;
                    pistasObtenidas [0] = "1. Se reestableció la energía (170).";
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                }
            } else {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Desafío cancelado, perdiste un turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            }
        }
    }

    static void interaccionAbrirPuertaUno () throws IOException {

        String fobosSatelite = "";
        String deimosSatelite = "";
        String puertaPreguntaUno = "Para desbloquear la puerta ordene el nombre del satelite de marte: sofob";
        String puertaPreguntaDos = "Ordene el nombre del satelite de marte: modeis";
        String puertaCorrecta = "Palabra ordenada correctamente!";
        String puertaIncorrecta = "Incorrecto! Recibiste un golpe y perdiste un turno.";
        String puertaExito = "Ordenaste las palabras correctamente! *Se abren las puertas*";
        String opcionUsuario = "";

        if (objetivosCompletados[0] && objetivosCompletados[1]) {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("PUERTA #1");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            if (puertasAbiertas[0]) {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("Ya completaste esta interacción, perdiste un turno...");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            } else {
                System.out.println("Para abrir la puerta tienes que ingresar lo que te piden.");
                System.out.println("¿Estás listo para intentar el desafío? (S/N)");
                opcionUsuario = in.readLine().trim().toLowerCase();
                if (opcionUsuario.equals("s")) {
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    out.println(puertaPreguntaUno);
                    fobosSatelite = in.readLine().toLowerCase();
                    if (fobosSatelite.equals("fobos")) {
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        out.println(puertaCorrecta);
                        out.println(puertaPreguntaDos);
                        deimosSatelite = in.readLine().toLowerCase();
                        if (deimosSatelite.equals("deimos")) {
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                            out.println(puertaExito);
                            puertasAbiertas[0] = true;
                            cantidadTurnos = cantidadTurnos - 1;
                            System.out.print("Presiona enter para continuar");
                            in.readLine();
                        } else {
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                            out.println(puertaIncorrecta);
                            golpesAcumulados = golpesAcumulados + 1;
                            cantidadTurnos = cantidadTurnos - 1;
                            System.out.print("Presiona enter para continuar");
                            in.readLine();
                        }
                    } else {
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        out.println(puertaIncorrecta);
                        golpesAcumulados = golpesAcumulados + 1;
                        cantidadTurnos = cantidadTurnos - 1;
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                    }
                } else {
                    cantidadTurnos = cantidadTurnos - 1;
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Desafío cancelado, perdiste un turno.");
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                }
            }
        } else {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("La energía debe estar actividad y tener control sobre las puertas, no puedes realizar esta tarea. Perdiste un turno.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        }
    }

    static void avanzarHabitacionDos() throws IOException {
        if (puertasAbiertas[0]) {
            cantidadTurnos = cantidadTurnos - 1; 
            ubicacionMapa = 2;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Avanzaste a la habitación #2");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            cantidadTurnos = cantidadTurnos - 1; 
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("La puerta está cerrada, no puedes avanzar a la habitación #2");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        }
    }

    static void interaccionesHabitacionDos () throws IOException {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("HABITACION #2");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. Investigar centro médico");
        System.out.println("2. Investigar laboratorio espacial");
        System.out.println("3. Investigar gimnasio");
        System.out.println("4. Urgar basurero");
        System.out.println("5. Regresar a habitación #1");
        System.out.println("6. Abrir puerta para habitación #3");
        System.out.println("7. Avanzar a habitación #3");
        System.out.println("8. Mostrar estado");
        System.out.println("9. Mostrar información encontrada");
        System.out.println("0. Muerte asistida");
        System.out.print("Digita tu siguiente movimiento: ");
        opcionesUsuario[1] = in.readLine(); 
        switch (opcionesUsuario[1]) {
            case "1":
            interaccionCentroMedico();
                break;
            case "2":
            interaccionLaboratorioEspacial();
                break;
            case "3":
            interaccionGimnasio();
                break;
            case "4":
            interaccionBasurero();
                break;
            case "5":
            regresarhabitacionUno();
                break;
            case "6":
            interaccionAbrirPuertaDos();
                break;
            case "7":
            avanzarHabitacionTres();
                break;
            case "8":
            mostrarEstado();
                break;
            case "9":
            mostrarInformacionEncontrada();
                break;
            case "0":
            juegoActivo = false;
            break;
            default:
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Opción inválida, acumulaste un golpe y perdiste un turno.");
            cantidadTurnos = cantidadTurnos - 1;
            golpesAcumulados = golpesAcumulados + 1;
            System.out.print("Presiona enter para continuar");
            in.readLine();
                break;
        }
    }

    static void interaccionCentroMedico () throws IOException {
        String opcionUsuario = "";
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("CENTRO MEDICO");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (objetivosCompletados[3]) {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno...");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            System.out.println("En la mesa de se encuentra un botiquín. Si lo agarras, se te curarán 2 golpes recibidos.");
            System.out.println("¿Quieres agarrar el botiquín? (S/N)");
            opcionUsuario = in.readLine().trim().toLowerCase();
            if (opcionUsuario.equals("s")) {
                objetivosCompletados[3] = true;
                pistasObtenidas[3] = "4. Botiquín recolectado, se te curaron dos golpes recibidos.";
                cantidadTurnos = cantidadTurnos - 1;
                if (golpesAcumulados <= 2) {
                    golpesAcumulados = 0;
                } else {
                    golpesAcumulados = golpesAcumulados - 2;
                }
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Botiquín utilizado, consumiste el turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            } else {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Decidiste no agarrar el botiquín, consumiste un turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            }  
        }
    }

    static void interaccionLaboratorioEspacial () throws IOException {
        String [] codigoEjemplo = {"0",",","0",",","1",",","1"};
        String [] codigoUsuario = {"",",","",",","",",",""};
        String [] codigoCorrecto = {"1",",","1",",","0",",","1"};
        int contador=0;
        String opcionUsuario = "";
        boolean banderaIntroduccionCodigo = true;
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("LABORATORIO ESPACIAL");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (objetivosCompletados [6]) {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno...");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            System.out.println("Dentro del laboratorio se muestra la siguiente secuencia de 0's y 1's:");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("[");
            for (int i = 0; i < codigoEjemplo.length; i++) {
                System.out.print(codigoEjemplo[i]);
            }
            System.out.println("]");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Para completar el desafío tienes que introducir la combinación correcta.");
            System.out.println("¿Estás listo para intentar el desafío? (S/N)");
            opcionUsuario = in.readLine().trim().toLowerCase();
            if (opcionUsuario.equals("s")) {
                while (banderaIntroduccionCodigo) {
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Tu codigo propuesto se ve de la siguiente manera: ");
                    System.out.print("[");
                    for (int i = 0; i < codigoUsuario.length; i++) {
                        System.out.print(codigoUsuario[i]);
                    }
                    System.out.println("]");
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("1. Cambiar elemento en posición 1");
                    System.out.println("2. Cambiar elemento en posición 2");
                    System.out.println("3. Cambiar elemento en posición 3");
                    System.out.println("4. Cambiar elemento en posición 4");
                    System.out.println("5. Probar código");
                    System.out.println("Digita la opcion que quieres realizar: ");
                    opcionUsuario = in.readLine().trim().toLowerCase();
                    switch (opcionUsuario) {
                        case "1":
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("Digita el numero que deseas colocar en posicion 1: ");
                        codigoUsuario[0] = in.readLine().trim().toLowerCase();
                            break;
                        case "2":
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("Digita el numero que deseas colocar en posicion 2: ");
                        codigoUsuario[2] = in.readLine().trim().toLowerCase();
                            break;
                        case "3":
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("Digita el numero que deseas colocar en posicion 3: ");
                        codigoUsuario[4] = in.readLine().trim().toLowerCase();
                            break;
                        case "4":
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("Digita el numero que deseas colocar en posicion 4: ");
                        codigoUsuario[6] = in.readLine().trim().toLowerCase();
                            break;
                        case "5":
                        for (int i = 0; i < codigoUsuario.length; i++) {
                            if (codigoUsuario[i].equals(codigoCorrecto[i])) {
                                contador++;
                            }
                        }
                        if (contador == 7) {
                            cantidadTurnos = cantidadTurnos - 1;
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Codigo correcto, desafío completado.");
                            objetivosCompletados[6] = true;
                            pistasObtenidas[6] = "7. Completaste el desafío del laboratorio (608).";
                            System.out.print("Presiona enter para continuar");
                            in.readLine();
                        } else {
                            cantidadTurnos = cantidadTurnos - 1;
                            golpesAcumulados = golpesAcumulados + 1;
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Codigo incorrecto, desafío fallado.");
                            System.out.print("Presiona enter para continuar");
                            in.readLine();
                        }
                        banderaIntroduccionCodigo = false;
                            break;
                        default:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Digita una opcion válida.");
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                            break;
                    }
                }
            } else {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Desafío cancelado, perdiste un turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            }
        }
    }

    static void interaccionGimnasio () throws IOException {
        String opcionUsuario = "";
        String pushupUsuario = "";
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("GIMNASIO");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (objetivosCompletados[5]) {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno...");
            System.out.print("Presiona enter para continuar");
            in.readLine();  
        } else {
            System.out.println("Debes hacer 12 pushups para completar el desafío. Para hacer un pushup tienes que teclear cualquier cadena de caracteres");
            System.out.println("¿Estás listo para intentar el desafío? (S/N)");
            opcionUsuario = in.readLine().trim().toLowerCase();
            if (opcionUsuario.equals("s")) {
                for (int pushupMaximo=0; pushupMaximo < 12;) {
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Pushups realizados: " + pushupMaximo + "/12");
                    System.out.println("Digita lo que quieres para hacer un pushup: ");
                    pushupUsuario = in.readLine();
                    if (pushupUsuario.equals("")) {
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Tienes que digitar lo que sea para hacer un pushup.");
                    } else {
                        pushupMaximo++;
                    }
                }
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Pushups realizados: 12/12. Desafío completado.");
                objetivosCompletados[5] = true;
                pistasObtenidas[5] = "6. Ejercicio diario registrado (337).";
                System.out.print("Presiona enter para continuar");
                in.readLine(); 
            } else {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Desafío cancelado, perdiste un turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            }
        }
    }  

    static void interaccionBasurero () throws IOException {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("BASURERO");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (objetivosCompletados[4]) {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            System.out.println("Luego de buscar en el basurero, encuentras los planos sobre el diseño del traje espacial óptimo...");
            System.out.println("Puedes distinguir: Casco, mochila, peto, pantalones, botas y guantes.");
            System.out.println("No tienes idea a qué se refiere pero decides guardarlo en tu inventario");
            pistasObtenidas[4] = "5. Traje optimizado: Casco, mochila, peto, pantalones, botas y guantes. ";
            objetivosCompletados[4] = true;
            cantidadTurnos = cantidadTurnos - 1;
            System.out.print("Presiona enter para continuar");
            in.readLine();
        }
    }

    static void regresarhabitacionUno() throws IOException {
        cantidadTurnos = cantidadTurnos - 1; 
        ubicacionMapa = 1;
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Regresaste a la habitación #1");
        System.out.print("Presiona enter para continuar");
        in.readLine();
    }

    static void avanzarHabitacionTres() throws IOException {
        if (puertasAbiertas[1]) {
            cantidadTurnos = cantidadTurnos - 1; 
            ubicacionMapa = 3;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Avanzaste a la habitación #3.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            cantidadTurnos = cantidadTurnos - 1; 
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("La puerta está cerrada, no puedes avanzar a la habitación #3.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        }
    }

    static void interaccionAbrirPuertaDos () throws IOException {

        String titanLuna = "";
        String enceladoLuna = "";
        String puertaPreguntaUno = "Para desbloquear la puerta ordene el nombre de la luna de Saturno: natti";
        String puertaPreguntaDos = "Ordene el nombre de la luna de Saturno: ocladene";
        String puertaCorrecta = "Palabra ordenada correctamente!";
        String puertaIncorrecta = "Incorrecto! Tienes que empezar desde el inicio";
        String puertaExito = "Ordenaste las palabras correctamente! *Se abren las puertas*";
        String opcionUsuario = "";

        if (puertasAbiertas[1]) {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno...");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("PUERTA #2");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Para abrir la puerta tienes que ingresar lo que te piden.");
            System.out.println("¿Estás listo para intentar el desafío? (S/N)");
            opcionUsuario = in.readLine().trim().toLowerCase();
            if (opcionUsuario.equals("s")) {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                out.println(puertaPreguntaUno);
                titanLuna = in.readLine().toLowerCase();
                if (titanLuna.equals("titan")) {
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    out.println(puertaCorrecta);
                    out.println(puertaPreguntaDos);
                    enceladoLuna = in.readLine().toLowerCase();
                    if (enceladoLuna.equals("encelado")) {
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        out.println(puertaExito);
                        puertasAbiertas[1] = true;
                        cantidadTurnos = cantidadTurnos - 1;
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                    } else {
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        out.println(puertaIncorrecta);
                        System.out.println("Desafío cancelado, recibiste un golpe y perdiste un turno.");
                        golpesAcumulados = golpesAcumulados + 1;
                        cantidadTurnos = cantidadTurnos - 1;
                        System.out.print("Presiona enter para continuar");
                        in.readLine();
                    }
                } else {
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    out.println(puertaIncorrecta);
                    System.out.println("Desafío cancelado, recibiste un golpe y perdiste un turno.");
                    golpesAcumulados = golpesAcumulados + 1;
                    cantidadTurnos = cantidadTurnos - 1;
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                }
            } else {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Desafío cancelado, perdiste un turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            }
        }

    }

    static void interaccionesHabitacionTres () throws IOException {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("HABITACION #3");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. Interactuar con apagador de puerta principal (SWITCH)");
        System.out.println("2. Revisar armario espacial");
        System.out.println("3. Investigar caja de herramientas");
        System.out.println("4. Subir a nave de escape (Intento de escape)");
        System.out.println("5. Regresar a habitación #2");
        System.out.println("6. Mostrar estado");
        System.out.println("7. Mostrar información encontrada");
        System.out.println("0. Muerte asistida");
        System.out.print("Digita tu siguiente movimiento: ");
        opcionesUsuario[2] = in.readLine(); 
        switch (opcionesUsuario[2]) {
            case "1":
            interaccionSwitch();
                break;
            case "2":
            interaccionArmario();
                break;
            case "3":
            interaccionHerramientas();
                break;
            case "4":
            escapeFinal();
                break;
            case "5":
            regresarhabitacionDos();
                break;
            case "6":
            mostrarEstado();
                break;
            case "7":
            mostrarInformacionEncontrada();
                break;
            case "0":
            juegoActivo = false;
            break;
            default:
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Opción inválida, acumulaste un golpe y perdiste un turno.");
            cantidadTurnos = cantidadTurnos - 1;
            golpesAcumulados = golpesAcumulados + 1;
            System.out.print("Presiona enter para continuar");
            in.readLine();
                break;
        }
    } 

    static void interaccionSwitch () throws IOException {
        
        String opcionUsuario = "";        
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Interruptor puerta principal");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (objetivosCompletados[7]) {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            System.out.println("¿Quieres abrir la compuerta principal de la estación espacial? (S/N)");
            opcionUsuario = in.readLine().trim().toLowerCase();
            if (opcionUsuario.equals("s")) {
                cantidadTurnos = cantidadTurnos - 1;
                pistasObtenidas[7] = "8. Se abrió la compuerta principal.";
                objetivosCompletados[7] = true;
                puertasAbiertas[2] = true;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Se abrió la compuerta principal.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            } else {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Decidiste no abrir la compuerta principal.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            }
        }

    }

    static void interaccionHerramientas() throws IOException {
        String opcionUsuario = "";
        int sumaCorrecta = 7 + 5;
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("CAJA DE HERRAMIENTAS");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (objetivosCompletados[8]) {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno...");
            System.out.print("Presiona enter para continuar");
            in.readLine();  
        } else {
            System.out.println("Para recolectar las herramientas tienes que responder una pregunta");
            System.out.println("¿Estás listo para intentar el desafío? (S/N)");
            opcionUsuario = in.readLine().trim().toLowerCase();
            if (opcionUsuario.equals("s")) {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Resuelve esta suma:");
                System.out.println("7 + 5 = ?");
                System.out.print("Tu respuesta: ");
                int respuesta = Integer.parseInt(in.readLine().trim());
                if (respuesta == sumaCorrecta) {
                    cantidadTurnos = cantidadTurnos - 1;
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("¡Correcto! Recogiste las herramientas.");
                    objetivosCompletados[8] = true;
                    pistasObtenidas[8] = "9. Herramientas obtenidas.";
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                } else {
                    cantidadTurnos = cantidadTurnos - 1;
                    golpesAcumulados = golpesAcumulados + 1;
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Respuesta incorrecta. No pudiste recoger las herramientas.");
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                }
            } else {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Desafío cancelado, perdiste un turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            }
        }
    }

    static void interaccionArmario () throws IOException {
        String parteFaltante = "";
        String opcionUsuario = "";  
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ARMARIO ESPACIAL");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (objetivosCompletados[9]) {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("Ya completaste esta interacción, perdiste un turno.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        } else {
            out.println("Necesitas el traje espacial completo para poder escapar!");
            out.println("En este momento tienes: Casco, peto, guantes, pantalones y botas");
            out.println("Necesitas adivinar cuál parte del traje falta para completarlo");
            System.out.println("¿Estás listo para intentar el desafío? (S/N)");
            opcionUsuario = in.readLine().trim().toLowerCase();
            if (opcionUsuario.equals("s")) {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Digita la parte del traje que falta:");
                parteFaltante = in.readLine();
                if (parteFaltante.equals("mochila")) {
                    pistasObtenidas[9] = "10. Tienes todas las piezas del traje.";
                    cantidadTurnos = cantidadTurnos - 1;
                    objetivosCompletados[9] = true;
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Excelente, completaste el traje.");
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                } else {
                    cantidadTurnos = cantidadTurnos - 1;
                    golpesAcumulados = golpesAcumulados + 1;
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Parte incorrecta, recibiste un golpe y perdiste un turno.");
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                }
            } else {
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Desafío cancelado, perdiste un turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            }
        }
    }

    static void regresarhabitacionDos() throws IOException {
        cantidadTurnos = cantidadTurnos - 1; 
        ubicacionMapa = 2;
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Regresaste a la habitación #2");
        System.out.print("Presiona enter para continuar");
        in.readLine();
    }

    static void escapeFinal () throws IOException {

        String opcionUsuario = "";
        String codigoUsuario = "";
        int requisitos = 0;
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("NAVE DE ESCAPE");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Estás a punto de realizar el escape, sin embargo asegurate de tener los requisitos:");
        System.out.println("1. Herramientas necesarias para arreglar avería en receptor de señal.");
        System.out.println("2. Traje espacial completo.");
        System.out.println("3. Abrir la compuerta principal de la estación espacial.");
        System.out.println("4. Haber interactuado EXITOSAMENTE con todos los desafíos.");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Si cumples los requisitos, necesitarás introducir el código final para iniciar la nave y escapar.");
        System.out.println("PISTA: 'El orden es poder'");
        System.out.println("¿Estás listo? (S/N)");
        opcionUsuario = in.readLine().trim().toLowerCase();

        if (opcionUsuario.equals("s")) {
            for (int i = 0; i < objetivosCompletados.length; i++) {
                if (objetivosCompletados[i]) {
                    requisitos ++;
                }
            }
            if (requisitos == 10) {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Cumples con los requisitos para intentar despegar la nave!");
                System.out.print("Introduce el código de despegue: ");
                codigoUsuario = in.readLine();
                if (codigoUsuario.equals("170875337608")  ) {
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("CODIGO CORRECTO, DESPEGANDO NAVE...");
                    juegoCompletado = true;
                    juegoActivo = false;
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                } else {
                    golpesAcumulados = golpesAcumulados + 1;
                    cantidadTurnos = cantidadTurnos - 1;
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Codigo incorrecto, recibiste un golpe y perdiste un turno.");
                    System.out.print("Presiona enter para continuar");
                    in.readLine();
                }
            } else {
                golpesAcumulados = golpesAcumulados + 1;
                cantidadTurnos = cantidadTurnos - 1;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Requisitos incompletos, recibiste un golpe y perdiste un turno.");
                System.out.print("Presiona enter para continuar");
                in.readLine();
            }
        } else {
            cantidadTurnos = cantidadTurnos - 1;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Desafío cancelado, perdiste un turno.");
            System.out.print("Presiona enter para continuar");
            in.readLine();
        }
    }

}