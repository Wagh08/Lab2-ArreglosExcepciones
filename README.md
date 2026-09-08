# Lab2-ArreglosExcepciones

## Intengrantes

- Kembeck López 26336
- William García 261035

## Análisis

### Clases

### 1. Parque

Atributos:
- Private String nombre
- Private int codigoDeIdentifiación
- Private String nombreDelEncargado
- Private PuntoDeAcceso[] puntosDeAcceso
- Private ArrayList<Visitante> visitantes

Métodos:
- Public Parque(String nombre, int codigoDeIdentificacion, String nombreDelEncargado)
- Public void habilitarPuntoDeAcceso(int posicion, PuntoDeAcceso puntoDeAcceso)
- Public void consultarPuntosDeAcceso()
- Public void consultarPuntoDeAcceso(int posicion)
- Public void modificarPuntoDeAcceso(int posicion, int capacidadMaximaPorHora, boolean estado)
- Public void cerrarPuntoDeAcceso(int posicion)
- Public void registrarVisitante(Visitante visitante)
- Public void consultarVisitantes()
- Public Visitante buscarVisitante(int codigoEntrada)
- Public void modificarVisitante(int codigoEntrada, String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados)
- Public void eliminarVisitante(int codigoEntrada)
- Public void mostrarReporte()
- Public boolean hayEspacioParaPuntoDeAcceso()

### 2. Punto de Acceso

Atributos:
- Private int codigo
- Private String nombre
- Private String ubicacion
- Private int capacidadMaximaPorHora
- Private boolean estado

Métodos:
- Public PuntoDeAcceso(int codigo, String nombre, String ubicacion, int capacidadMaximaPorHora, boolean estado)
- Public int getCapacidadMaximaPorHora()
- Public void setCapacidadMaximaPorHora(int capacidadMaximaPorHora)
- Public void setEstado(boolean estado)
- Public String informacion()
- Private boolean esTextoValido(String texto)

### 3. Visitante

Atributos:
- Private int codigoEntrada
- Private String nombre
- Private int edad
- Private int atraccionesVisitadas
- Private int puntosAcumulados

Métodos:
- Public Visitante(int codigoEntrada, String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados)
- Public int getCodigoEntrada()
- Publuc void validarDatos(String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados)
- Public int getEdad()
- Public int getAtraccionesVisitadas()
- Public int getPuntosAcumulados()
- Public void actualizarInformacion(String nombre, int edad, int atraccionesVisitadas, int puntosAcumulados)
- Public String informacion()

### 4. Main

Atributos:
- Private Scanner scanner
- Private Parque parqueActual

Métodos:
- Public static void main(String[] args)
- Private static void mostrarMenu()
- Private static boolean verificarParque()
- Private static void crearNuevoParque()
- Private static void habilitarPuntoDeAcceso()
- Private static void consultarPuntoDeAcceso()
- Private static void modificarPuntoDeAcceso()
- Private static void cerrarPuntoDeAcceso()
- Private static void registrarVisitante()
- Private static void buscarVisitante()
- Private static void modificarVisitante()
- Private static void eliminarVisitante()
- Private static int leerEntero(String mensaje)
- Private static int leerEnteroPositivo(String mensaje)
- Private static int leerEnteroNoNegativo(String mensaje)
- Private static int leerPosicion(String mensaje)
- Private static String leerSoloLetras(String mensaje)
- Private static boolean leerEstado()

Se utilizará un arreglo básico para la propiedad: Puntos de Acceso, este contará con un máximo de 5 puntos de acceso, que tendrán valores de null si no contienen un un objeto de clase Punto de Acceso. 

Se utilizará un ArrayList para la propiedad: Visitantes, para registrar los objetos de clase Visitante sin delimitar un número máximo de posibles visitantes.

Los valores iniciales de los objetos se determinaran con sus constructores para Parque, Punto de Acceso y para Visitante, mientras que para las listas Visitantes y Puntos de Acceso obtendrán algunas de sus posiciones con sus objetos correspondientes y otras con un valor null. Antes de validar el estado de un objeto se verificará 

Para determinar si una posición en un arreglo contiene un punto de acceso o valor null se llevará un contador de espaciosOcupados por cada arreglo.

Las operaciones de búsqueda, modificación y eliminación en el ArrayList se realizarán a través de la selección de la posición por medio de indice y de la validación de que la acción sea posible.

#### Pueden producir excepciones las siguientes situaciones: 

- Si se ingresa un valor no numeérico o menor a uno en variables como CapacidadMáximaPorHora o edad.
- Si se ingresan números en variables donde deberían de ir nombres.
- Si se intenta realizar una acción sobre una lista indicando un índice inexistente en ella.
- Si se intenta usar una posición del arreglo que contenga null.
- Si se intentan registrar mas visitantes del máximo por hora.
