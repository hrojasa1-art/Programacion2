import java.util.ArrayList;
import java.util.Scanner;

public class ListaNombres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();

        System.out.println("Ingrese nombres. Escriba \"fin\" para terminar.");

        while (true) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacio.");
            } else {
                nombres.add(nombre);
            }
        }

        System.out.println("\nLista de nombres:");
        if (nombres.isEmpty()) {
            System.out.println("La lista esta vacia.");
        } else {
            for (String nombre : nombres) {
                System.out.println("- " + nombre);
            }
        }

        scanner.close();
    }
}
