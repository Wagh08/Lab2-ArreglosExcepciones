public class PuntoDeAcceso {
    
    private int codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaximaPorHora;
    private boolean estado;

    public PuntoDeAcceso(int codigo, String nombre, String ubicacion, int capacidadMaximaPorHora, boolean estado){
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
