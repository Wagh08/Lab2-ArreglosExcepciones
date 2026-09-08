import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Parque parqueActual = null;

    public static void main(String[] args) {

        crearNuevoParque();

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearNuevoParque();
                    break;

                case 2:
                    if (verificarParque()) {
                        habilitarPuntoDeAcceso();
                    }
                    break;

                case 3:
                    if (verificarParque()) {
                        parqueActual.consultarPuntosDeAcceso();
                    }
                    break;

                case 4:
                    if (verificarParque()) {
                        consultarPuntoDeAcceso();
                    }
                    break;

                case 5:
                    if (verificarParque()) {
                        modificarPuntoDeAcceso();
                    }
                    break;

                case 6:
                    if (verificarParque()) {
                        cerrarPuntoDeAcceso();
                    }
                    break;

                case 7:
                    if (verificarParque()) {
                        registrarVisitante();
                    }
                    break;

                case 8:
                    if (verificarParque()) {
                        parqueActual.consultarVisitantes();
                    }
                    break;

                case 9:
                    if (verificarParque()) {
                        buscarVisitante();
                    }
                    break;

                case 10:
                    if (verificarParque()) {
                        modificarVisitante();
                    }
                    break;

                case 11:
                    if (verificarParque()) {
                        eliminarVisitante();
                    }
                    break;

                case 12:
                    if (verificarParque()) {
                        parqueActual.mostrarReporte();
                    }
                    break;

                case 13:
                    System.out.println(
                            "Gracias por utilizar el programa."
                    );
                    break;

                default:
                    System.out.println(
                            "La opción seleccionada no es válida."
                    );
                    break;
            }

        } while (opcion != 13);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println(
                "\n========== PARQUE UVG =========="
        );
        System.out.println("1. Nuevo parque");
        System.out.println("2. Habilitar punto de acceso");
        System.out.println("3. Consultar puntos de acceso");
        System.out.println("4. Consultar un punto de acceso");
        System.out.println("5. Modificar punto de acceso");
        System.out.println("6. Cerrar punto de acceso");
        System.out.println("7. Registrar visitante");
        System.out.println("8. Consultar visitantes");
        System.out.println("9. Buscar visitante");
        System.out.println("10. Modificar visitante");
        System.out.println("11. Eliminar visitante");
        System.out.println("12. Mostrar reporte del parque");
        System.out.println("13. Salir");
    }

    private static boolean verificarParque() {
        if (parqueActual == null) {
            System.out.println(
                    "Primero debe crear un parque con la opción 1."
            );

            return false;
        }

        return true;
    }

    private static void crearNuevoParque() {
        System.out.println("\n=== NUEVO PARQUE ===");

        String nombre = leerSoloLetras(
                "Nombre del parque: "
        );

        int codigo = leerEnteroPositivo(
                "Código de identificación: "
        );

        String encargado = leerSoloLetras(
                "Nombre del encargado: "
        );

        parqueActual = new Parque(
                nombre,
                codigo,
                encargado
        );

        System.out.println(
                "El nuevo parque fue creado correctamente."
        );
        System.out.println(
                "No tiene puntos de acceso ni visitantes registrados."
        );
    }

    private static void habilitarPuntoDeAcceso() {
        System.out.println(
                "\n=== HABILITAR PUNTO DE ACCESO ==="
        );

        try {
            if (!parqueActual.hayEspacioParaPuntoDeAcceso()) {
                throw new IllegalStateException(
                        "Los cinco puntos de acceso ya están ocupados."
                );
            }

            int posicion = leerPosicion(
                    "Posición del arreglo (0 a 4): "
            );

            int codigo = leerEnteroPositivo(
                    "Código del punto de acceso: "
            );

            String nombre = leerSoloLetras(
                    "Nombre del punto de acceso: "
            );

            String ubicacion = leerSoloLetras(
                    "Ubicación: "
            );

            int capacidad = leerEnteroPositivo(
                    "Capacidad máxima por hora: "
            );

            PuntoDeAcceso puntoDeAcceso =
                    new PuntoDeAcceso(
                            codigo,
                            nombre,
                            ubicacion,
                            capacidad,
                            true
                    );

            parqueActual.habilitarPuntoDeAcceso(
                    posicion,
                    puntoDeAcceso
            );

        } catch (IllegalStateException e) {
            System.out.println(
                    "No se puede habilitar otro punto: "
                            + e.getMessage()
            );

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Datos inválidos: " + e.getMessage()
            );
        }
    }

    private static void consultarPuntoDeAcceso() {
        System.out.println(
                "\n=== CONSULTAR PUNTO DE ACCESO ==="
        );

        int posicion = leerPosicion(
                "Posición que desea consultar (0 a 4): "
        );

        parqueActual.consultarPuntoDeAcceso(posicion);
    }

    private static void modificarPuntoDeAcceso() {
        System.out.println(
                "\n=== MODIFICAR PUNTO DE ACCESO ==="
        );

        int posicion = leerPosicion(
                "Posición que desea modificar (0 a 4): "
        );

        int capacidad = leerEnteroPositivo(
                "Nueva capacidad máxima por hora: "
        );

        boolean estado = leerEstado();

        parqueActual.modificarPuntoDeAcceso(
                posicion,
                capacidad,
                estado
        );
    }

    private static void cerrarPuntoDeAcceso() {
        System.out.println(
                "\n=== CERRAR PUNTO DE ACCESO ==="
        );

        int posicion = leerPosicion(
                "Posición que desea cerrar (0 a 4): "
        );

        parqueActual.cerrarPuntoDeAcceso(posicion);
    }

    private static void registrarVisitante() {
        System.out.println(
                "\n=== REGISTRAR VISITANTE ==="
        );

        try {
            int codigoEntrada = leerEnteroPositivo(
                    "Código de entrada: "
            );

            String nombre = leerSoloLetras(
                    "Nombre del visitante: "
            );

            int edad = leerEnteroPositivo(
                    "Edad: "
            );

            int atraccionesVisitadas =
                    leerEnteroNoNegativo(
                            "Atracciones visitadas: "
                    );

            int puntosAcumulados =
                    leerEnteroNoNegativo(
                            "Puntos acumulados: "
                    );

            Visitante visitante = new Visitante(
                    codigoEntrada,
                    nombre,
                    edad,
                    atraccionesVisitadas,
                    puntosAcumulados
            );

            parqueActual.registrarVisitante(visitante);

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo registrar al visitante: "
                            + e.getMessage()
            );
        }
    }

    private static void buscarVisitante() {
        System.out.println(
                "\n=== BUSCAR VISITANTE ==="
        );

        int codigoEntrada = leerEnteroPositivo(
                "Código de entrada: "
        );

        Visitante visitante =
                parqueActual.buscarVisitante(codigoEntrada);

        if (visitante == null) {
            System.out.println(
                    "No existe un visitante con ese código."
            );
        } else {
            System.out.println("Visitante encontrado:");
            System.out.println(visitante.informacion());
        }
    }

    private static void modificarVisitante() {
        System.out.println(
                "\n=== MODIFICAR VISITANTE ==="
        );

        int codigoEntrada = leerEnteroPositivo(
                "Código de entrada del visitante: "
        );

        Visitante visitante =
                parqueActual.buscarVisitante(codigoEntrada);

        if (visitante == null) {
            System.out.println(
                    "No existe un visitante con ese código."
            );

            return;
        }

        String nombre = leerSoloLetras(
                "Nuevo nombre: "
        );

        int edad = leerEnteroPositivo(
                "Nueva edad: "
        );

        int atraccionesVisitadas =
                leerEnteroNoNegativo(
                        "Nueva cantidad de atracciones visitadas: "
                );

        int puntosAcumulados =
                leerEnteroNoNegativo(
                        "Nueva cantidad de puntos acumulados: "
                );

        parqueActual.modificarVisitante(
                codigoEntrada,
                nombre,
                edad,
                atraccionesVisitadas,
                puntosAcumulados
        );
    }

    private static void eliminarVisitante() {
        System.out.println(
                "\n=== ELIMINAR VISITANTE ==="
        );

        int codigoEntrada = leerEnteroPositivo(
                "Código de entrada del visitante: "
        );

        parqueActual.eliminarVisitante(codigoEntrada);
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println(
                        "Entrada incorrecta. Debe ingresar un número entero."
                );

            } finally {
                scanner.nextLine();
            }
        }
    }

    private static int leerEnteroPositivo(String mensaje) {
        while (true) {
            int numero = leerEntero(mensaje);

            try {
                if (numero <= 0) {
                    throw new IllegalArgumentException(
                            "El número debe ser mayor que cero."
                    );
                }

                return numero;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int leerEnteroNoNegativo(String mensaje) {
        while (true) {
            int numero = leerEntero(mensaje);

            try {
                if (numero < 0) {
                    throw new IllegalArgumentException(
                            "El número no puede ser negativo."
                    );
                }

                return numero;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int leerPosicion(String mensaje) {
        while (true) {
            int posicion = leerEntero(mensaje);

            try {
                if (posicion < 0 || posicion > 4) {
                    throw new IllegalArgumentException(
                            "La posición debe estar entre 0 y 4."
                    );
                }

                return posicion;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String leerSoloLetras(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();

            try {
                if (texto.isEmpty()) {
                    throw new IllegalArgumentException(
                            "El texto no puede estar vacío."
                    );
                }

                if (!texto.matches("[\\p{L}\\s]+")) {
                    throw new IllegalArgumentException(
                            "Solamente puede ingresar letras y espacios."
                    );
                }

                return texto;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean leerEstado() {
        while (true) {
            System.out.println("Seleccione el nuevo estado:");
            System.out.println("1. Habilitado");
            System.out.println("2. Deshabilitado");

            int opcion = leerEntero("Estado: ");

            try {
                if (opcion != 1 && opcion != 2) {
                    throw new IllegalArgumentException(
                            "Debe seleccionar 1 o 2."
                    );
                }

                return opcion == 1;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}