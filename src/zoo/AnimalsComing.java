package zoo;

import javax.swing.JOptionPane;

// Hacer la logica de alimentacion
public class AnimalsComing {

    Animals arrAnimals[] = new Animals[10];

    Species Felino = Species.Felino;
    Species Mamifero = Species.Mamifero;
    Species Reptil = Species.Reptil;
    Species Ave = Species.Ave;

    public void PrecargarAnimales() {
        arrAnimals[0] = new Animals("Leo", Felino, 10);
        arrAnimals[1] = new Animals("Rafa", Mamifero, 30);
        arrAnimals[2] = new Animals("Rino", Mamifero, 25);
        arrAnimals[3] = new Animals("Coco", Reptil, 50);
        arrAnimals[4] = new Animals("Emilio", Ave, 14);
    }

    public void Add() {
        Species species = null; //Instancia la clase Species

        String nombre = JOptionPane.showInputDialog("Digite el nombre del animal que desea añadir:");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la especie del animal\n\n 1. Felino\n 2. Ave\n 3. Reptil\n 4. Anfibio\n 5. Pez\n 6. Insecto\n 7. Primate\n 8. Marsupial\n 9. Pinguino\n 10. Mamifero"));

        //Asigna el valor de Species necesario según la elección del usuario
        switch (opcion) {
            case 1 ->
                species = Species.Felino;
            case 2 ->
                species = Species.Ave;
            case 3 ->
                species = Species.Reptil;
            case 4 ->
                species = Species.Anfibio;
            case 5 ->
                species = Species.Pez;
            case 6 ->
                species = Species.Insecto;
            case 7 ->
                species = Species.Primate;
            case 8 ->
                species = Species.Marsupial;
            case 9 ->
                species = Species.Pinguino;
            case 10 ->
                species = Species.Mamifero;
            default ->
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }

        // Si la opción no es válida, se mostrará un mensaje y no se procederá con la adición del animal.
        if (species == null) {
            return;
        }

        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del animal:"));

        for (int x = 0; x < arrAnimals.length; x++) {
            if (arrAnimals[x] == null) { //Verifica si el objeto es nulo para no sobrescribir
                arrAnimals[x] = new Animals(nombre, species, edad); //Si es nulo añade el valor ahi
                break;
            }
        }
    }

    public void Remove() {
        String data = JOptionPane.showInputDialog("Ingrese el nombre del animal que desea remover");

        for (int x = 0; x < arrAnimals.length; x++) {
            if (arrAnimals[x] != null) { //Verifica si el objeto no es nulo
                int result = data.compareTo(arrAnimals[x].getNombre());
                if (result == 0) {
                    arrAnimals[x] = null;
                    break;
                }
            }
        }
    }

    public void Modify() {
        String nombreAnimal = JOptionPane.showInputDialog("Ingrese el nombre del animal que desea modificar");
        Species species = null;

        for (int x = 0; x < arrAnimals.length; x++) {
            if (arrAnimals[x] != null) {
                int resultado = nombreAnimal.compareTo(arrAnimals[x].getNombre());
                if (resultado == 0) {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre nuevo: (Nombre viejo: " + arrAnimals[x].getNombre() + ")");
                    int especie = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la especie nueva: (Especie vieja: " + arrAnimals[x].getEspecie() + ")" + "\n\n 1. Leon\n 2. Jirafa\n 3. Rinoceronte\n\n Extender...\n"));

                    //Asigna el valor de Species necesario segun la eleccion del usuario
                    switch (especie) {
                        case 1 ->
                            species = Species.Felino;
                        case 2 ->
                            species = Species.Ave;
                        case 3 ->
                            species = Species.Reptil;
                        case 4 ->
                            species = Species.Anfibio;
                        case 5 ->
                            species = Species.Pez;
                        case 6 ->
                            species = Species.Insecto;
                        case 7 ->
                            species = Species.Primate;
                        case 8 ->
                            species = Species.Marsupial;
                        case 9 ->
                            species = Species.Pinguino;
                        case 10 ->
                            species = Species.Mamifero;
                        default ->
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                    }

                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad nueva: (Edad vieja: " + arrAnimals[x].getEdad() + ")"));
                    arrAnimals[x] = new Animals(nombre, species, edad);
                }
            }
        }

    }

    public void Search() {
        String data = JOptionPane.showInputDialog("Ingrese el nombre del animal que desea buscar");
        int flag = 0;

        //Toma el nombre solicitado y lo compara con los valores llenos del arreglo
        for (int x = 0; x < arrAnimals.length; x++) {
            if (arrAnimals[x] != null) { //Verifica si el objeto no es nulo
                int result = data.compareTo(arrAnimals[x].getNombre());
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "Nombre: " + arrAnimals[x].getNombre() + "\nEspecie: " + arrAnimals[x].getEspecie() + "\nEdad: " + arrAnimals[x].getEdad());
                    flag = 1; //Marca la variable flag como 1 si encuentra una coincidencia
                    break; //Rompe el ciclo si se encuentra una coincidencia
                }
            }
        }

        if (flag == 0) { //Si no se encontraron coincidencias el valor es 0 y se muestra el mensaje
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
        }

    }

    public void MenuAnimals() {
        //int opcionSeleccionadaMenuAnimales = Integer.parseInt(JOptionPane.showInputDialog("Seleccione que desea hacer\n\n 1. Add\n 2. Remove\n 3. Modify\n 4. Search"));
        String[] opcionMenuAnimales = {"Añadir animal", "Remover animal", "Modificar animal", "Buscar animal"};
        int opcionSeleccionadaMenuAnimales = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "------Menú de eventos------", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionMenuAnimales, opcionMenuAnimales[0]);

        switch (opcionSeleccionadaMenuAnimales) {
            case 0 ->
                AnimalsComing.this.Add();
            case 1 ->
                AnimalsComing.this.Remove();
            case 2 ->
                AnimalsComing.this.Modify();
            case 3 ->
                AnimalsComing.this.Search();
        }
    }
}
