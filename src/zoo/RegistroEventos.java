package zoo;

import javax.swing.JOptionPane;

public class RegistroEventos {

    private static RegistroEventos instanciaSingleton; // Instancia unica de RegistroEventos para evitar vara de que se reinice el arreglo
    private Evento[] eventos;
    private int contadorEventos = 0;
    private static final int CAPACIDAD_INICIAL = 10;

    // Constructor privado para evitar que se creen nuevas instancias
    private RegistroEventos() {
        eventos = new Evento[CAPACIDAD_INICIAL];
        contadorEventos = 0;
        precargarEventos();
    }

    // Metodo estático para obtener la instancia única
    public static RegistroEventos obtenerInstancia() {
        if (instanciaSingleton == null) {
            instanciaSingleton = new RegistroEventos();
        }
        return instanciaSingleton;
    }

    public void imprimirEventos() { //Para uso de nosotros-------- Borrar en el proyecto final---------
        System.out.println("Eventos registrados:");//Para uso de nosotros-------- Borrar en el proyecto final---------
        for (int i = 0; i < contadorEventos; i++) {//Para uso de nosotros-------- Borrar en el proyecto final---------
            Evento evento = eventos[i];//Para uso de nosotros-------- Borrar en el proyecto final---------
            System.out.println("Evento " + (i + 1) + ":");//Para uso de nosotros-------- Borrar en el proyecto final---------
            System.out.println("Nombre: " + evento.getNombre());//Para uso de nosotros-------- Borrar en el proyecto final---------
            System.out.println("Fecha: " + evento.getFecha());//Para uso de nosotros-------- Borrar en el proyecto final---------
            System.out.println("Descripción: " + evento.getDescripcion());//Para uso de nosotros-------- Borrar en el proyecto final---------
            System.out.println("Código: " + evento.getCodigo());//Para uso de nosotros-------- Borrar en el proyecto final---------
            System.out.println();//Para uso de nosotros-------- Borrar en el proyecto final---------
        }//Para uso de nosotros-------- Borrar en el proyecto final---------
    }//Para uso de nosotros-------- Borrar en el proyecto final---------

    private void precargarEventos() {
        registrarEvento("Evento 1", "2024-04-05", "Descripción del evento 1", "001");
        registrarEvento("Evento 2", "2024-04-06", "Descripción del evento 2", "002");
        // Agregar más eventos precargados si es necesario
    }

    public void detallarEvento() {
        String nombreEvento = JOptionPane.showInputDialog("Ingrese el nombre del evento:");
        String fechaEvento = JOptionPane.showInputDialog("Ingrese la fecha del evento:");
        String descripcionEvento = JOptionPane.showInputDialog("Ingrese la descripción del evento:");
        String codigoEvento = JOptionPane.showInputDialog("Ingrese el código del evento:");
        registrarEvento(nombreEvento, fechaEvento, descripcionEvento, codigoEvento);
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
            nuevoArray[i] = eventos[i];// Esto copia por si acaso
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
