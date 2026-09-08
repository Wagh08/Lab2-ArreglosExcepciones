import java.util.ArrayList;

public class Parque {

    private String nombre;
    private int codigoDeIdentificacion;
    private String nombreDelEncargado;
    private PuntoDeAcceso[] puntosDeAcceso;
    private ArrayList<Visitante> visitantes;

    public Parque(String nombre, int codigoDeIdentificacion, String nombreDelEncargado) {

        this.nombre = nombre;
        this.codigoDeIdentificacion = codigoDeIdentificacion;
        this.nombreDelEncargado = nombreDelEncargado;
        this.puntosDeAcceso = new PuntoDeAcceso[5];
        this.visitantes = new ArrayList<>();
    }

    public void habilitarPuntoDeAcceso( int posicion, PuntoDeAcceso puntoDeAcceso) {

        try {
            if (posicion < 0 || posicion >= puntosDeAcceso.length) {
                throw new IllegalArgumentException();
            }

            if (puntosDeAcceso[posicion] != null) {
                throw new IllegalArgumentException();
            }

            if (puntoDeAcceso == null) {
                throw new IllegalArgumentException();
            }

            if (puntoDeAcceso.getCapacidadMaximaPorHora() <= 0) {
                throw new IllegalArgumentException();
            }

            puntosDeAcceso[posicion] = puntoDeAcceso;

            System.out.println("Punto de acceso habilitado.");

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo habilitar el punto de acceso."
            );
        }
    }

    public void consultarPuntosDeAcceso() {
        boolean existenPuntos = false;

        for (int i = 0; i < puntosDeAcceso.length; i++) {
            if (puntosDeAcceso[i] != null) {
                System.out.println("Posición " + i + ":");
                System.out.println(puntosDeAcceso[i].informacion());

                existenPuntos = true;
            }
        }

        if (!existenPuntos) {
            System.out.println( "No hay puntos de acceso habilitados.");
        }
    }

    public void consultarPuntoDeAcceso(int posicion) {
        try {
            if (posicion < 0 || posicion >= puntosDeAcceso.length) {
                throw new IllegalArgumentException();
            }

            if (puntosDeAcceso[posicion] == null) {
                throw new IllegalArgumentException();
            }

            System.out.println(
                    puntosDeAcceso[posicion].informacion()
            );

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo consultar el punto de acceso."
            );
        }
    }

    public void modificarPuntoDeAcceso( int posicion, int capacidadMaximaPorHora, boolean estado) {

        try {
            if (posicion < 0 || posicion >= puntosDeAcceso.length) {
                throw new IllegalArgumentException();
            }

            if (puntosDeAcceso[posicion] == null) {
                throw new IllegalArgumentException();
            }

            if (capacidadMaximaPorHora <= 0) {
                throw new IllegalArgumentException();
            }

            puntosDeAcceso[posicion].setCapacidadMaximaPorHora(
                            capacidadMaximaPorHora
                    );

            puntosDeAcceso[posicion].setEstado(estado);

            System.out.println("Punto de acceso modificado.");

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo modificar el punto de acceso."
            );
        }
    }

    public void cerrarPuntoDeAcceso(int posicion) {
        try {
            if (posicion < 0 || posicion >= puntosDeAcceso.length) {
                throw new IllegalArgumentException();
            }

            if (puntosDeAcceso[posicion] == null) {
                throw new IllegalArgumentException();
            }

            puntosDeAcceso[posicion] = null;

            System.out.println("Punto de acceso cerrado.");

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo cerrar el punto de acceso."
            );
        }
    }

    public void registrarVisitante(Visitante visitante) {
        try {
            if (visitante == null) {
                throw new IllegalArgumentException();
            }

            if (buscarVisitante(
                    visitante.getCodigoEntrada()) != null) {

                throw new IllegalArgumentException();
            }

            visitantes.add(visitante);

            System.out.println("Visitante registrado.");

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo registrar el visitante."
            );
        }
    }

    public void consultarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println(
                    "No hay visitantes registrados."
            );

            return;
        }

        for (Visitante visitante : visitantes) {
            System.out.println(visitante.informacion());
        }
    }

    public Visitante buscarVisitante(int codigoEntrada) {
        for (Visitante visitante : visitantes) {
            if (visitante.getCodigoEntrada() == codigoEntrada) {
                return visitante;
            }
        }

        return null;
    }

    public void modificarVisitante(
            int codigoEntrada,
            String nombre,
            int edad,
            int atraccionesVisitadas,
            int puntosAcumulados) {

        try {
            Visitante visitante = buscarVisitante(codigoEntrada);

            if (visitante == null) {
                throw new IllegalArgumentException();
            }

            visitante.actualizarInformacion(
                    nombre,
                    edad,
                    atraccionesVisitadas,
                    puntosAcumulados
            );

            System.out.println("Visitante modificado.");

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo modificar el visitante."
            );
        }
    }

    public void eliminarVisitante(int codigoEntrada) {
        try {
            Visitante visitante = buscarVisitante(codigoEntrada);

            if (visitante == null) {
                throw new IllegalArgumentException();
            }

            visitantes.remove(visitante);

            System.out.println("Visitante eliminado.");

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo eliminar el visitante."
            );
        }
    }

    public void mostrarReporte() {
        try {
            int puntosHabilitados = 0;
            PuntoDeAcceso puntoMayorCapacidad = null;

            for (PuntoDeAcceso punto : puntosDeAcceso) {
                if (punto != null) {
                    puntosHabilitados++;

                    if (puntoMayorCapacidad == null
                            || punto.getCapacidadMaximaPorHora() > puntoMayorCapacidad.getCapacidadMaximaPorHora()) {

                        puntoMayorCapacidad = punto;
                    }
                }
            }

            System.out.println("Parque: " + nombre);
            System.out.println(
                    "Código: " + codigoDeIdentificacion
            );
            System.out.println(
                    "Encargado: " + nombreDelEncargado
            );
            System.out.println(
                    "Puntos de acceso habilitados: "+ puntosHabilitados
            );
            System.out.println(
                    "Espacios disponibles: "
                            + (puntosDeAcceso.length - puntosHabilitados)
            );

            if (puntoMayorCapacidad != null) {
                System.out.println(
                        "Punto con mayor capacidad:"
                );
                System.out.println(
                        puntoMayorCapacidad.informacion()
                );
            } else {
                System.out.println(
                        "No hay puntos de acceso habilitados."
                );
            }

            System.out.println(
                    "Visitantes registrados: "+ visitantes.size()
            );

            if (!visitantes.isEmpty()) {
                Visitante visitanteMayorPuntos = visitantes.get(0);

                Visitante visitanteMayorAtracciones = visitantes.get(0);

                int sumaEdades = 0;

                for (Visitante visitante : visitantes) {
                    sumaEdades += visitante.getEdad();

                    if (visitante.getPuntosAcumulados()> visitanteMayorPuntos.getPuntosAcumulados()) {
                        visitanteMayorPuntos = visitante;
                    }

                    if (visitante.getAtraccionesVisitadas()> visitanteMayorAtracciones.getAtraccionesVisitadas()) {
                        visitanteMayorAtracciones = visitante;
                    }
                }

                double promedioEdad =(double) sumaEdades / visitantes.size();

                System.out.println(
                        "Visitante con más puntos:"
                );
                System.out.println(
                        visitanteMayorPuntos.informacion()
                );

                System.out.println(
                        "Visitante con más atracciones:"
                );
                System.out.println(
                        visitanteMayorAtracciones.informacion()
                );

                System.out.println(
                        "Promedio de edad: " + promedioEdad
                );

            } else {
                System.out.println(
                        "No hay visitantes para realizar cálculos."
                );
            }

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo generar el reporte."
            );

        } finally {
            System.out.println("Fin del reporte.");
        }
    }

    public boolean hayEspacioParaPuntoDeAcceso() {
        for (PuntoDeAcceso punto : puntosDeAcceso) {
            if (punto == null) {
                return true;
            }
        }

    return false;
}
}