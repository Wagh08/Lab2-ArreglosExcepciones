public class Visitante {
    
    private int codigoEntrada;
    private String nombre;
    private int edad;
    private int atraccionesVisitadas;
    private int puntosAcumulados;

    public Visitante(int codigoEntrada, String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados){
        
        validarDatos(nombre, edad, atraccionesVisitadas,puntosAcumulados);

        if (codigoEntrada <= 0) {
            throw new IllegalArgumentException(
                    "El código de entrada debe ser mayor que cero."
            );
        }

       this.codigoEntrada = codigoEntrada;
       this.nombre = nombre;
       this.edad = edad;
       this.atraccionesVisitadas = atraccionesVisitadas;
       this.puntosAcumulados = puntosAcumulados;
    }

    private void validarDatos(String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        if (!nombre.matches("[\\p{L}\\s]+")) {
            throw new IllegalArgumentException(
                    "El nombre solamente puede contener letras."
            );
        }

        if (edad <= 0) {
            throw new IllegalArgumentException(
                    "La edad debe ser mayor que cero."
            );
        }

        if (atraccionesVisitadas < 0) {
            throw new IllegalArgumentException(
                    "Las atracciones visitadas no pueden ser negativas."
            );
        }

        if (puntosAcumulados < 0) {
            throw new IllegalArgumentException(
                    "Los puntos acumulados no pueden ser negativos."
            );
        }
    }

    public int getCodigoEntrada(){
        return codigoEntrada;
    }

    public int getEdad(){
        return edad;
    }

    public int getAtraccionesVisitadas(){
        return  atraccionesVisitadas;
    }

    public int getPuntosAcumulados(){
        return puntosAcumulados;
    }

    public void actualizarInformacion(String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados){
        validarDatos(nombre, edad, atraccionesVisitadas, puntosAcumulados);
        
        this.nombre = nombre;
        this.edad = edad;
        this.atraccionesVisitadas = atraccionesVisitadas;
        this.puntosAcumulados = puntosAcumulados;
    }

    public String informacion(){
        return "Este visitante se identifica con el código: " + codigoEntrada + ". Se llama " + nombre + ", tiene " + edad + " años, " + "ha visitado " + atraccionesVisitadas + " atracciones y acumulado " + puntosAcumulados + " puntos.";
    }
}
