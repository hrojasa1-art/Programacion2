import java.util.ArrayList;
import java.util.Scanner;

public class BuscarNombre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();

        System.out.println("Ingrese nombres para la lista. Escriba \"fin\" para terminar.");
        while (true) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            if (!nombre.isEmpty()) {
                nombres.add(nombre.toLowerCase());
            }
        }

        System.out.print("\nNombre que desea buscar: ");
        String buscado = scanner.nextLine().trim().toLowerCase();

        if (nombres.contains(buscado)) {
            System.out.println("El nombre SI existe en la lista.");
        } else {
            System.out.println("El nombre NO existe en la lista.");
        }

        scanner.close();
    }
}
