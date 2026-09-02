import java.util.ArrayList;
import java.util.Scanner;

public class DiezNumerosArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.println("Ingrese 10 numeros enteros:");
        for (int i = 1; i <= 10; i++) {
            numeros.add(leerEntero(scanner, "Numero " + i + ": "));
        }

        System.out.println("\nElementos del ArrayList:");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println("Indice " + i + ": " + numeros.get(i));
        }

        scanner.close();
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Escriba un numero entero.");
            }
        }
    }
}
