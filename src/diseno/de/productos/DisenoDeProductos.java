
package diseno.de.productos;

import java.util.Locale;
import java.util.Scanner;


public class DisenoDeProductos {

    public static void main(String[] args) {
        
        vista();
    }

    // Capa Vista: interacción con el usuario
    public static void vista() {
        Scanner sc = new Scanner(System.in);
        String nombreUsuario;
        String ubicacion;
        boolean datosValidos;

        System.out.println("===== Registro y rutas EvacuaYa =====");

        // Validar nombre usuario, no vacío
        do {
            System.out.print("> Ingrese su nombre: ");
            nombreUsuario = sc.nextLine().trim();
            datosValidos = !nombreUsuario.isEmpty();
            if (!datosValidos) {
                System.out.println("> El nombre no puede estar vacío. Intente de nuevo.");
            }
        } while (!datosValidos);

        System.out.println();
        // Mostrar zonas disponibles
        System.out.println("---------------------");
        System.out.println(">> Zonas disponibles:");
        System.out.println("---------------------");
        System.out.println("A. Zona A");
        System.out.println("B. Zona B");
        System.out.println("C. Zona C");
        System.out.println("D. Zona D");
        System.out.println("E. Zona E");
        System.out.println("---------------------");

        // Pedir ubicación
        do {
            System.out.print("Ingrese su ubicación actual (A, B, C, D o E): ");
            ubicacion = sc.nextLine().trim().toUpperCase(Locale.ROOT);
            datosValidos = ubicacion.matches("[ABCDE]");
            if (!datosValidos) {
                System.out.println("Ubicación inválida. Por favor ingrese una zona válida.");
            }
        } while (!datosValidos);

        // Mostrar mapa textual y rutas
        mostrarRutas(ubicacion);

        controlador(nombreUsuario, ubicacion);
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

    // Mostrar mapa y rutas
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
    
}
