package zoo;

import javax.swing.JOptionPane;

public class Zoo {

    public static void main(String[] args) { //-----------------------------------MAIN----------------------------------------

        boolean continuar = true;// Para poder seguir seleccionando opciones

        while (continuar) {

            String[] opciones = {"Registro de Animales", "Registro de Hábitats", "Registro de Eventos", "Registro de Visitantes", "Gestión de Alimentación", "Mapa de Animales", "Salir"};// 
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "------Menú Principal------", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            OUTER:
            switch (opcion) {
                case 0:
                    // Lógica para Registro de Animales
                    JOptionPane.showMessageDialog(null, "Seleccionaste Registro de Animales");
                    AnimalsComing menuDeAnimales = new AnimalsComing();
                    menuDeAnimales.PrecargarAnimales(); // SE NECSITA PRECARGAR DESDE MAIN XQ NO HAY CONSTRUCTOR DENTRO DE LA CLASE
                    menuDeAnimales.MenuAnimals();

                    break;
                case 1:
                    // Lógica para Registro de Hábitats
                    JOptionPane.showMessageDialog(null, "Seleccionaste Registro de Hábitats");
                    break;
                case 2: {
                    String[] opcionRegistroEventos = {"Registrar nuevo evento", "Consultar información de evento"};
                    int opcionSeleccionadaRegistroEventos = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "------Menú de eventos------", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionRegistroEventos, opcionRegistroEventos[0]);
                    RegistroEventos registroEventos = RegistroEventos.obtenerInstancia(); // Obtener la instancia única

                    switch (opcionSeleccionadaRegistroEventos) {
                        case 0: {
                            registroEventos.detallarEvento();
                            registroEventos.imprimirEventos();//Para uso de nosotros-------- Borrar en el proyecto final---------
                            JOptionPane.showMessageDialog(null, "Evento registrado con éxito.");
                            break OUTER;
                        }
                        case 1: {
                            String codigoEvento = JOptionPane.showInputDialog("Ingrese el código del evento que desea consultar:");
                            String informacionEvento = registroEventos.consultarEventoPorCodigo(codigoEvento);
                            registroEventos.imprimirEventos();//Para uso de nosotros-------- Borrar en el proyecto final---------
                            JOptionPane.showMessageDialog(null, informacionEvento);
                            break OUTER;
                        }
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                            break OUTER;
                    }
                }

                case 3:
                    //  para Registro de Visitantes
                    JOptionPane.showMessageDialog(null, "Seleccionaste Registro de Visitantes");
                    break;
                case 4:
                    //  para Gestión de Alimentación
                    JOptionPane.showMessageDialog(null, "Seleccionaste Gestión de Alimentación");
                    break;
                case 5:
                    //  para Mapa de Animales
                    JOptionPane.showMessageDialog(null, "Seleccionaste Mapa de Animales");
                    break;
                case 6:
                    // para del programa
                    continuar = false;
                    break;
                default:
                    // para cualquier otro caso x aquello
                    break;
            }
        }
    }
}
