public class PuntoDeAcceso {
    
    private int codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaximaPorHora;
    private boolean estado;

    private boolean esTextoValido(String texto) {
        return texto != null
                && !texto.trim().isEmpty()
                && texto.matches("[\\p{L}\\s]+");
    }
    
    public PuntoDeAcceso(int codigo, String nombre, String ubicacion, int capacidadMaximaPorHora, boolean estado){
        if (codigo <= 0) {
            throw new IllegalArgumentException(
                    "El código debe ser mayor que cero."
            );
        }

        if (!esTextoValido(nombre)) {
            throw new IllegalArgumentException(
                    "El nombre solamente puede contener letras."
            );
        }

        if (!esTextoValido(ubicacion)) {
            throw new IllegalArgumentException(
                    "La ubicación solamente puede contener letras."
            );
        }

        if (capacidadMaximaPorHora <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad debe ser mayor que cero."
            );
        }
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaximaPorHora = capacidadMaximaPorHora;
        this.estado = estado;
    }

    public int getCapacidadMaximaPorHora(){
        return capacidadMaximaPorHora;
    }

    public void setCapacidadMaximaPorHora(int capacidadMaximaPorHora){

        if (capacidadMaximaPorHora <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad debe ser mayor que cero."
            );
        }
        
        this.capacidadMaximaPorHora = capacidadMaximaPorHora;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public String informacion(){
        String estadoInfo;
        
        if (estado){
            estadoInfo = "Habilitado";
        } else {
            estadoInfo = "Deshabilitado";
        }

        return "El punto de acceso llamado " + nombre + ", de código " + codigo + ", se encuentra en " + ubicacion + ", tiene una capacidad de " + capacidadMaximaPorHora + " y se encuentra " + estadoInfo + ".";
    }
}
