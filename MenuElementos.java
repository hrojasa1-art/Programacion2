import java.util.ArrayList;
import java.util.Scanner;

public class MenuElementos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> elementos = new ArrayList<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    System.out.print("Escriba el elemento: ");
                    String elemento = scanner.nextLine().trim();
                    if (elemento.isEmpty()) {
                        System.out.println("No se puede agregar un elemento vacio.");
                    } else {
                        elementos.add(elemento);
                        System.out.println("Elemento agregado.");
                    }
                    break;
                case 2:
                    mostrarElementos(elementos);
                    break;
                case 3:
                    if (elementos.isEmpty()) {
                        System.out.println("No hay elementos para eliminar.");
                        break;
                    }
                    mostrarElementos(elementos);
                    int indice = leerEntero(scanner, "Indice que desea eliminar: ");
                    if (indice >= 0 && indice < elementos.size()) {
                        String eliminado = elementos.remove(indice);
                        System.out.println("Se elimino: " + eliminado);
                    } else {
                        System.out.println("Indice fuera de rango.");
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Agregar elemento");
        System.out.println("2. Mostrar elementos");
        System.out.println("3. Eliminar por indice");
        System.out.println("0. Salir");
    }

    private static void mostrarElementos(ArrayList<String> elementos) {
        if (elementos.isEmpty()) {
            System.out.println("La lista esta vacia.");
            return;
        }

        System.out.println("Elementos:");
        for (int i = 0; i < elementos.size(); i++) {
            System.out.println(i + ": " + elementos.get(i));
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Escriba un numero entero.");
            }
        }
    }
}
