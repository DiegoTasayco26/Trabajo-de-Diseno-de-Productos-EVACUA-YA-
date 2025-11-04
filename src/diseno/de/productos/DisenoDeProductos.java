package diseno.de.productos;

import java.util.Locale;
import java.util.Scanner;

public class DisenoDeProductos {

    public static void main(String[] args) {
        // Inicia el flujo de la aplicación
        vista();
    }

    // Capa Vista: interacción con el usuario
    public static void vista() {
        Scanner sc = new Scanner(System.in);
        String nombreUsuario;
        String ubicacion;
        boolean datosValidos;

        // Pantalla 1 - Bienvenida
        System.out.println("===== Registro y rutas EvacuaYa =====");
        System.out.println("¡Bienvenido a EvacuaYA! Alerta temprana.");
        System.out.println();

        // Validar nombre usuario, no vacío
        do {
            System.out.print("> Ingrese su nombre: ");
            nombreUsuario = sc.nextLine().trim();
            datosValidos = !nombreUsuario.isEmpty();
            if (!datosValidos) {
                System.out.println("> El nombre no puede estar vacío. Intente de nuevo.");
            }
        } while (!datosValidos);

        // Pantalla 2 - Mostrar zonas disponibles
        System.out.println("---------------------");
        System.out.println(">> Zonas disponibles:");
        System.out.println("---------------------");
        System.out.println("A. Zona A");
        System.out.println("B. Zona B");
        System.out.println("C. Zona C");
        System.out.println("D. Zona D");
        System.out.println("E. Zona E");
        System.out.println("---------------------");

        // Pantalla 3 - Pedir ubicación
        do {
            System.out.print("Ingrese su ubicación actual (A, B, C, D o E): ");
            ubicacion = sc.nextLine().trim().toUpperCase(Locale.ROOT);
            datosValidos = ubicacion.matches("[ABCDE]");
            if (!datosValidos) {
                System.out.println("Ubicación inválida. Por favor ingrese una zona válida.");
            }
        } while (!datosValidos);

        // Pantalla 4 - Confirmación de datos
        System.out.println();
        System.out.println("REGISTRO EXITOSO");
        System.out.println("EvacuaYA registró correctamente tus datos.");
        System.out.println("Zona registrada: " + ubicacion);
        System.out.println("Ruta de evacuación asignada: " + seleccionarRutaPorZona(ubicacion));
        System.out.println("¡La ayuda está en camino!");
        System.out.println();

        // Pantalla 5 - Mostrar mapa y rutas
        mostrarRutas(ubicacion);

        // Navegar entre pantallas
        opcionesDeNavegacion();
    }

    // Capa Controlador
    public static void controlador(String usuario, String ubicacion) {
        modelo(usuario, ubicacion);
    }

    // Capa Modelo
    public static void modelo(String usuario, String ubicacion) {
        String rutaSeleccionada = seleccionarRutaPorZona(ubicacion);
        System.out.println();
        System.out.println(">> Usuario '" + usuario + "'");
        System.out.println(">> Con ubicación '" + ubicacion + "' se asigna la ruta: " + rutaSeleccionada);
        System.out.println();
        bdGuardar(usuario, ubicacion, rutaSeleccionada);
    }

    // Asignar ruta según zona
    public static String seleccionarRutaPorZona(String zona) {
        return switch (zona) {
            case "A" -> ">> Ruta Norte por Calle 5 <<";
            case "B" -> ">> Ruta Sur por Avenida Central <<";
            case "C" -> ">> Ruta Este por Parque Principal <<";
            case "D" -> ">> Ruta Oeste por Callejón Seguro <<";
            case "E" -> ">> Ruta Central por Plaza Mayor <<";
            default -> ">> Ruta Desconocida <<";
        };
    }

    // Guardar datos (simulado)
    public static void bdGuardar(String usuario, String ubicacion, String ruta) {
        System.out.println("---------------------------------------------------");
        System.out.println("Registrando datos en base de datos (simulado):");
        System.out.println("---------------------------------------------------");
        System.out.println("Usuario registrado: " + usuario);
        System.out.println("Ubicación registrada: " + ubicacion);
        System.out.println("Ruta asignada: " + ruta);
        System.out.println("---------------------------------------------------");
    }

    // Mostrar mapa y rutas (Pantalla 4)
    public static void mostrarRutas(String ubicacion) {
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("             >> Mapas y Rutas de Evacuación <<");
        System.out.println("-----------------------------------------------------------------");

        switch (ubicacion) {
            case "A" -> {
                System.out.println("Ubicación: Zona A");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("1) Ruta Norte: Calle 5 -> Calle 6 -> Salida Norte");
                System.out.println("2) Ruta Alternativa: Calle 4 -> Avenida 1 -> Salida Oeste");
                System.out.println("-----------------------------------------------------------------");
            }
            case "B" -> {
                System.out.println("Ubicación: Zona B");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("1) Ruta Sur: Avenida Central -> Calle 10 -> Salida Sur");
                System.out.println("2) Ruta Alternativa: Calle 9 -> Parque Central -> Salida Este");
                System.out.println("-----------------------------------------------------------------");
            }
            case "C" -> {
                System.out.println("Ubicación: Zona C");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("1) Ruta Este: Parque Principal -> Avenida 7 -> Salida Este");
                System.out.println("2) Ruta Alternativa: Calle 8 -> Calle 9 -> Salida Norte");
                System.out.println("-----------------------------------------------------------------");
            }
            case "D" -> {
                System.out.println("Ubicación: Zona D");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("1) Ruta Oeste: Callejón Seguro -> Calle 3 -> Salida Oeste");
                System.out.println("2) Ruta Alternativa: Avenida 2 -> Callejón Largo -> Salida Sur");
                System.out.println("-----------------------------------------------------------------");
            }
            case "E" -> {
                System.out.println("Ubicación: Zona E");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("1) Ruta Central: Plaza Mayor -> Calle Central -> Salida Principal");
                System.out.println("2) Ruta Alternativa: Calle 1 -> Avenida 3 -> Salida Norte");
                System.out.println("-----------------------------------------------------------------");
            }
            default -> System.out.println("Zona no reconocida");
        }
    }

    // Opciones de navegación (Volver / Seguir)
    public static void opcionesDeNavegacion() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Opción de navegación: Volver o Seguir
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Volver al registro");
        System.out.println("2. Seguir con el flujo de la app");
        System.out.print("> Elija una opción: ");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Volviendo al registro...");
                vista();  // Llamada para volver a la pantalla de registro
                break;
            case 2:
                System.out.println("Continuando con la app...");
                opcionesAyuda(sc);  // Continuamos con las opciones de ayuda
                break;
            default:
                System.out.println("Opción inválida.");
                opcionesDeNavegacion(); // Llamamos de nuevo si la opción es inválida
                break;
        }
    }

    // Pantalla 6: Opciones de ayuda
    public static void opcionesAyuda(Scanner sc) {
        int opcion;
        do {
            System.out.println("¿Qué desea hacer ahora?");
            System.out.println("1. Pedir ayuda");
            System.out.println("2. Recibir consejos");
            System.out.println("3. Preguntas frecuentes");
            System.out.print("> Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¡AYUDA SOLICITADA! La ayuda está en camino.");
                    break;
                case 2:
                    mostrarConsejos();
                    break;
                case 3:
                    mostrarPreguntasFrecuentes();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 1); // Continuar hasta que el usuario elija "Pedir ayuda"
    }

    // Pantalla 6: Consejos
    public static void mostrarConsejos() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Consejos para estar preparado:");
            System.out.println("1. Ubica puntos de encuentro con tu familia.");
            System.out.println("2. Guarda documentos importantes (DNI, seguros, etc.).");
            System.out.println("3. Revisa tu vivienda para evitar riesgos.");
            System.out.println("4. Activa las notificaciones de alerta.");
            System.out.println("Después del desastre:");
            System.out.println("1. Verifica daños antes de entrar a tu vivienda.");
            System.out.println("2. Reporta daños o personas desaparecidas.");
            System.out.println("3. Ayuda a tu comunidad.");
            System.out.println("Elige 1 para volver.");
            opcion = sc.nextInt();
        } while (opcion != 1); // Sigue mostrando los consejos hasta que el usuario elija pedir ayuda
    }

    // Pantalla 7: Preguntas Frecuentes
    public static void mostrarPreguntasFrecuentes() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Preguntas frecuentes:");
            System.out.println("1. ¿Qué es la app 'EvacuaYa'? - Una app para alertas de desastres.");
            System.out.println("2. ¿Ofrece rutas seguras para evacuar? - Sí, según tu ubicación.");
            System.out.println("3. ¿Consume muchos datos? - No, es eficiente en el uso de datos.");
            System.out.println("4. ¿Mis datos están protegidos? - Sí, están seguros.");
            System.out.println("Elige 1 para volver.");
            opcion = sc.nextInt();
        } while (opcion != 1); // Sigue mostrando las preguntas frecuentes hasta que el usuario elija pedir ayuda
    }
}
