package diseno.de.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DisenoDeProductos {

    // Datos generales
    private static Scanner sc = new Scanner(System.in);
    private static String nombre;
    private static String desastre;
    private static String zona;
    private static String rutaAsignada = "Ruta Norte"; // por defecto
    private static List<String> historial = new ArrayList<>();

    public static void main(String[] args) {
        // Historial inicial (como en las pantallas)
        historial.add("Día: 02/03/2025 | Zona: B | Ruta: Ruta Sur | Tipo de riesgo: Huayco");
        historial.add("Día: 15/06/2025 | Zona: C | Ruta: Ruta Este | Tipo de riesgo: Sismo");
        historial.add("Día: 08/09/2025 | Zona: A | Ruta: Ruta Oeste | Tipo de riesgo: Terremoto");

        mostrarBienvenida();
        registrarUsuario();
        flujoRutasEvacuacion();
        menuPrincipal(); // aquí se queda hasta que el usuario termine
    }

    // -------------------- UTILITARIOS ----------------------- //

    private static void mostrarBienvenida() {
        System.out.println("=====================================");
        System.out.println("     ¡BIENVENIDO A EVACUAYA!         ");
        System.out.println("        ALERTA TEMPRANA              ");
        System.out.println("=====================================");
        pausar();
    }

    private static void pausar() {
        System.out.println("\nPresione ENTER para continuar...");
        sc.nextLine();
    }

    private static int leerEntero(String mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine();
            try {
                valor = Integer.parseInt(linea);
                if (valor < min || valor > max) {
                    System.out.println("Opción inválida. Ingrese un número entre " + min + " y " + max + ".");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }
    }

    // -------------------- REGISTRO ----------------------- //

    private static void registrarUsuario() {
        System.out.println("\n=========== REGISTRO DE USUARIO ===========");
        System.out.print("Nombre completo: ");
        nombre = sc.nextLine();

        System.out.print("Indica el desastre natural (Ej.: Sismo, Huayco, Inundación): ");
        desastre = sc.nextLine();

        System.out.print("¿En qué zona estás? (A, B, C, D o E): ");
        zona = sc.nextLine().trim().toUpperCase();

        System.out.println("\nREGISTRO EXITOSO");
        System.out.println("EvacuaYA registró correctamente tus datos.");
        System.out.println("Ahora se te pedirá seleccionar una ruta de evacuación.");
        pausar();
    }

    // -------------------- RUTAS DE EVACUACIÓN ----------------------- //

    private static void flujoRutasEvacuacion() {
        seleccionarRuta();
        mostrarMapaRuta();
        mostrarIndicaciones();
        mostrarZonasSeguras();
        confirmarRutaAsignada();
    }

    private static void seleccionarRuta() {
        System.out.println("\n=========== UBICACIÓN Y RUTAS ===========");
        System.out.println("Registro: Zona " + zona + " - Precisión en Puno");
        System.out.println("\nRutas de evacuación disponibles:");
        System.out.println("1. Ruta Norte");
        System.out.println("2. Ruta Sur");
        System.out.println("3. Ruta Este");
        System.out.println("4. Ruta Oeste");
        System.out.println("5. Ruta Central");
        System.out.println("6. Volver al registro");

        int op = leerEntero("Seleccione una opción: ", 1, 6);

        if (op == 6) {
            // Volver al registro
            registrarUsuario();
            seleccionarRuta();
            return;
        }

        switch (op) {
            case 1: rutaAsignada = "Ruta Norte"; break;
            case 2: rutaAsignada = "Ruta Sur"; break;
            case 3: rutaAsignada = "Ruta Este"; break;
            case 4: rutaAsignada = "Ruta Oeste"; break;
            case 5: rutaAsignada = "Ruta Central"; break;
            default: rutaAsignada = "Ruta Norte";
        }
    }

    private static void mostrarMapaRuta() {
        System.out.println("\n=========== MAPA DE EVACUACIÓN ===========");
        System.out.println("Ruta seleccionada: " + rutaAsignada);
        System.out.println("(Mapa simbólico) Calle 5 -> Calle 6 -> Salida " + rutaAsignada.split(" ")[1]);
        System.out.println("\nRecuerde: MANTENER LA CALMA.");
        pausar();
    }

    private static void mostrarIndicaciones() {
        System.out.println("\n=========== INDICACIONES ===========");
        System.out.println("Ruta " + rutaAsignada);
        System.out.println("1. Evacuar la estructura donde esté.");
        System.out.println("2. Caminar por la calle 5 una cuadra.");
        System.out.println("3. Doblar hacia la derecha y seguir por la calle 6.");
        System.out.println("4. Doblar por la izquierda e ir por la salida " + rutaAsignada.split(" ")[1] + ".");
        System.out.println("\nOpciones:");
        System.out.println("1. Ver zonas seguras");
        System.out.println("2. Seguir sin ver zonas seguras");

        int op = leerEntero("Seleccione una opción: ", 1, 2);
        // sea cual sea, luego pasamos a mostrarZonasSeguras (como en las pantallas)
        if (op == 1) {
            // simplemente continúa
        }
    }

    private static void mostrarZonasSeguras() {
        System.out.println("\n=========== ZONAS SEGURAS CERCANAS ===========");
        System.out.println("Lista de lugares identificados como seguros:");
        System.out.println("1. Hospital de Puno");
        System.out.println("2. Mercado 'Unión y dignidad'");
        pausar();
    }

    private static void confirmarRutaAsignada() {
        System.out.println("\n=========== RUTA ASIGNADA ===========");
        System.out.println("¡Felicidades " + nombre + "!");
        System.out.println("EvacuaYA asignó tu ruta de evacuación y zonas seguras con éxito.");
        pausar();

        // Guardamos el registro actual en el historial
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hoy = LocalDate.now().format(fmt);
        String registro = "Día: " + hoy +
                " | Zona: " + zona +
                " | Ruta de evacuación: " + rutaAsignada +
                " | Tipo de riesgo: " + desastre;
        historial.add(registro);
    }

    // -------------------- MENÚ PRINCIPAL ----------------------- //

    private static void menuPrincipal() {
        while (true) {
            System.out.println("\n=========== MENÚ PRINCIPAL ===========");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Pedir ayuda");
            System.out.println("2. Abrir lista de chats");
            System.out.println("3. Recibir consejos");
            System.out.println("4. Preguntas frecuentes");
            System.out.println("5. Historial");
            System.out.println("6. Fin del programa");

            int op = leerEntero("Opción: ", 1, 6);

            switch (op) {
                case 1: pedirAyuda(); break;
                case 2: abrirListaChats(); break;
                case 3: recibirConsejos(); break;
                case 4: preguntasFrecuentes(); break;
                case 5: verHistorial(); break;
                case 6: salirPrograma(); break;
            }
        }
    }

    // -------------------- PEDIR AYUDA ----------------------- //

    private static void pedirAyuda() {
        System.out.println("\n=========== VALIDACIÓN DE LOS DATOS ===========");
        System.out.println("Nombre completo: " + nombre);
        System.out.println("Desastre natural: " + desastre);
        System.out.println("Usted registró: Ubicación Zona " + zona + " - Puno");
        System.out.println("Se le asignó: " + rutaAsignada);
        System.out.println("(Mapa simbólico de la ruta)");
        System.out.println("\n1. Validar");
        System.out.println("2. Volver al menú");

        int op = leerEntero("Seleccione una opción: ", 1, 2);
        if (op == 2) return;

        System.out.println("\n¡DATOS VALIDADOS PARA EL PEDIDO DE AYUDA!");
        pausar();

        menuServiciosEmergencia();
    }

    private static void menuServiciosEmergencia() {
        System.out.println("\n=========== ELIGE SERVICIO ===========");
        System.out.println("1. Ambulancia");
        System.out.println("2. Bomberos");
        System.out.println("3. Policías");
        System.out.println("4. Defensa civil");
        System.out.println("5. Volver al menú");

        int op = leerEntero("Seleccione una opción: ", 1, 5);

        if (op == 5) return;

        String servicio = "";
        switch (op) {
            case 1: servicio = "Ambulancia"; break;
            case 2: servicio = "Bomberos"; break;
            case 3: servicio = "Policías"; break;
            case 4: servicio = "Defensa civil"; break;
        }

        System.out.println("\n========== SOS ==========");
        System.out.println("Servicio: " + servicio);
        System.out.println("¡La ayuda va en camino!");
        pausar();
    }

    // -------------------- LISTA DE CHATS ----------------------- //

    private static void abrirListaChats() {
        while (true) {
            System.out.println("\n=========== LISTA DE CHATS ===========");
            System.out.println("1. María Campos Ortiz");
            System.out.println("2. Laura Torres Vertiz");
            System.out.println("3. Juliana Paredes Cárdenas");
            System.out.println("4. Mariana López Arteaga");
            System.out.println("5. Yuli Irene Quispe");
            System.out.println("0. Volver al menú");

            int op = leerEntero("Seleccione un contacto: ", 0, 5);
            if (op == 0) return;

            String nombreContacto;
            switch (op) {
                case 1: nombreContacto = "María Campos Ortiz"; break;
                case 2: nombreContacto = "Laura Torres Vertiz"; break;
                case 3: nombreContacto = "Juliana Paredes Cárdenas"; break;
                case 4: nombreContacto = "Mariana López Arteaga"; break;
                case 5: nombreContacto = "Yuli Irene Quispe"; break;
                default: nombreContacto = "Contacto"; break;
            }

            chatConContacto(nombreContacto);
        }
    }

    private static void chatConContacto(String contacto) {
        while (true) {
            System.out.println("\n=========== CHAT CON " + contacto.toUpperCase() + " ===========");
            System.out.println(contacto + ": Carlos, debemos encontrarnos.");
            System.out.println(contacto + ": Mándame tu ubicación.");
            System.out.println(contacto + " ha mandado su ubicación en tiempo real. (VER)");
            System.out.println(contacto + ": ¿Dónde estás?!");
            System.out.println("\nOpciones:");
            System.out.println("1. Ver ubicación del contacto");
            System.out.println("2. Enviar mensaje (simulado)");
            System.out.println("3. Volver a la lista de chats");

            int op = leerEntero("Seleccione una opción: ", 1, 3);

            if (op == 3) return;
            if (op == 2) {
                System.out.print("Escriba su mensaje: ");
                String msg = sc.nextLine();
                System.out.println("Mensaje enviado: " + msg);
                pausar();
            } else if (op == 1) {
                verUbicacionContacto(contacto);
            }
        }
    }

    private static void verUbicacionContacto(String contacto) {
        System.out.println("\n=========== UBICACIÓN DE CONTACTO ===========");
        System.out.println("Contacto: " + contacto);
        System.out.println("Mapa simbólico de su ubicación (Puno, zona céntrica).");
        System.out.println("\n1. Notificación de EvacuaYA");
        System.out.println("2. Volver al chat");

        int op = leerEntero("Seleccione una opción: ", 1, 2);
        if (op == 2) return;

        // Notificación de cercanía
        System.out.println("\n¡SE HA DETECTADO CERCANÍA ENTRE USUARIOS!");
        System.out.println(nombre + " y " + contacto + " pueden solicitar un punto de encuentro a EvacuaYA.");
        System.out.println("\n1. Punto de encuentro");
        System.out.println("2. Volver");

        op = leerEntero("Seleccione una opción: ", 1, 2);
        if (op == 2) return;

        System.out.println("\n=========== PUNTO DE ENCUENTRO ===========");
        System.out.println("Contacto: " + contacto);
        System.out.println("Se ha sugerido una zona de encuentro seguro entre ambas ubicaciones.");
        System.out.println("Siga el camino indicado en el mapa simbólico.");
        pausar();
    }

    // -------------------- CONSEJOS ----------------------- //

    private static void recibirConsejos() {
        System.out.println("\n=========== CONSEJOS ===========");
        System.out.println("¿Cómo prepararte para cuando la situación se vuelve a repetir?");
        System.out.println("- Ubica puntos de encuentro con tu familia.");
        System.out.println("- Guarda documentos importantes (DNI, seguros, recetas, etc.).");
        System.out.println("- Revisa tu vivienda para evitar objetos pesados mal ubicados.");
        System.out.println("- Activa las notificaciones de alerta en tu celular y en la app.");
        System.out.println("\nDespués del desastre:");
        System.out.println("- Verifica daños antes de entrar a tu vivienda.");
        System.out.println("- Evita consumir agua o alimentos contaminados.");
        System.out.println("- Reporta daños o personas desaparecidas a las autoridades.");
        System.out.println("- Actualiza tu mochila de emergencia y tu plan familiar.");
        System.out.println("\nTip tecnológico:");
        System.out.println("- Carga tu celular completamente cuando haya alerta preventiva.");
        System.out.println("\nOpciones:");
        System.out.println("1. Volver");
        System.out.println("2. Salir");

        int op = leerEntero("Seleccione una opción: ", 1, 2);
        if (op == 2) salirPrograma();
    }

    // -------------------- PREGUNTAS FRECUENTES ----------------------- //

    private static void preguntasFrecuentes() {
        System.out.println("\n=========== PREGUNTAS FRECUENTES ===========");
        System.out.println("1) ¿Qué es la app EvacuaYA y para qué sirve?");
        System.out.println("   - Es una app para alertar al usuario y ayudarlo durante un desastre natural.");
        System.out.println("\n2) ¿La app ofrece rutas seguras para evacuar?");
        System.out.println("   - Sí, asigna correctamente rutas seguras según los datos registrados.");
        System.out.println("\n3) ¿La app consume muchos datos móviles?");
        System.out.println("   - No, el consumo de datos es mínimo.");
        System.out.println("\n4) ¿Mis datos de ubicación están protegidos?");
        System.out.println("   - Sí, los datos se usan solo para asignar rutas y zonas seguras.");
        System.out.println("\nOpciones:");
        System.out.println("1. Volver");
        System.out.println("2. Salir");

        int op = leerEntero("Seleccione una opción: ", 1, 2);
        if (op == 2) salirPrograma();
    }

    // -------------------- HISTORIAL ----------------------- //

    private static void verHistorial() {
        System.out.println("\n=========== HISTORIAL DE REGISTRO ===========");
        if (historial.isEmpty()) {
            System.out.println("No hay registros en el historial.");
        } else {
            for (String reg : historial) {
                System.out.println("- " + reg);
            }
        }

        System.out.println("\nOpciones:");
        System.out.println("1. Borrar historial");
        System.out.println("2. Volver al menú");

        int op = leerEntero("Seleccione una opción: ", 1, 2);
        if (op == 1) {
            historial.clear();
            System.out.println("\nSu historial ha sido eliminado.");
            pausar();
        }
    }

    // -------------------- SALIR ----------------------- //

    private static void salirPrograma() {
        System.out.println("\nGracias por usar EvacuaYA.");
        System.out.println("Programa finalizado.");
        System.exit(0);
    }
}
