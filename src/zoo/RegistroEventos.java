
package zoo;


public class RegistroEventos {



    private Evento[] eventos;
    private int contadorEventos;
    private static final int CAPACIDAD_INICIAL = 20;

    public RegistroEventos() {//-----CONSTRUCTOR------
        eventos = new Evento[CAPACIDAD_INICIAL];
        contadorEventos = 0;
        precargarEventos();
    }

    private void precargarEventos() { //Se ejecutará automáticamente cada vez que se cree una instancia de la clase RegistroEventos ya que SIEMPRE en cada instancia se ejectura EL constructor
        registrarEvento("Evento 1", "2024-04-05", "Descripción del evento 1", "001");
        registrarEvento("Evento 2", "2024-04-06", "Descripción del evento 2", "002");
        // Agrega más eventos precargados si es necesario
    }

    public void registrarEvento(String nombre, String fecha, String descripcion, String codigo) {
        if (contadorEventos == eventos.length) {
            redimensionarEventos();
        }
        eventos[contadorEventos] = new Evento(nombre, fecha, descripcion, codigo);
        contadorEventos++;
    }

    private void redimensionarEventos() {
        Evento[] nuevoArray = new Evento[eventos.length * 2];
        for (int i = 0; i < eventos.length; i++) {
            nuevoArray[i] = eventos[i];
        }
        eventos = nuevoArray;
    }

    public String consultarEventoPorCodigo(String codigo) {
        for (int i = 0; i < contadorEventos; i++) {
            if (eventos[i].getCodigo().equals(codigo)) {
                return "Nombre: " + eventos[i].getNombre() + "\nFecha: " + eventos[i].getFecha() + "\nDescripción: " + eventos[i].getDescripcion();
            }
        }
        return "Código de evento inexistente";
    }

    // Clase interna para representar un evento
    public class Evento {

        private final String nombre;
        private final String fecha;
        private final String descripcion;
        private final String codigo;

        public Evento(String nombre, String fecha, String descripcion, String codigo) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.descripcion = descripcion;
            this.codigo = codigo;
        }

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public String getFecha() {
            return fecha;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getCodigo() {
            return codigo;
        }
    }
}




