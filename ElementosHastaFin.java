import java.util.ArrayList;
import java.util.Scanner;

public class ElementosHastaFin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> elementos = new ArrayList<>();

        System.out.println("Ingrese elementos. Escriba \"fin\" para terminar.");

        while (true) {
            System.out.print("Elemento: ");
            String elemento = scanner.nextLine().trim();

            if (elemento.equalsIgnoreCase("fin")) {
                break;
            }

            if (elemento.isEmpty()) {
                System.out.println("El elemento no puede estar vacio.");
            } else {
                elementos.add(elemento);
            }
        }

        System.out.println("\nElementos ingresados:");
        if (elementos.isEmpty()) {
            System.out.println("No se ingresaron elementos.");
        } else {
            for (int i = 0; i < elementos.size(); i++) {
                System.out.println((i + 1) + ". " + elementos.get(i));
            }
        }

        scanner.close();
    }
}
