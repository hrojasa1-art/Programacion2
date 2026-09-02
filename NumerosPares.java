import java.util.ArrayList;
import java.util.Scanner;

public class NumerosPares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> numerosPares = new ArrayList<>();

        System.out.println("Ingrese numeros enteros. Escriba \"fin\" para terminar.");
        while (true) {
            System.out.print("Numero: ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                numeros.add(Integer.parseInt(entrada));
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Escriba un entero o \"fin\".");
            }
        }

        for (int numero : numeros) {
            if (numero % 2 == 0) {
                numerosPares.add(numero);
            }
        }

        System.out.println("Lista original: " + numeros);
        System.out.println("Numeros pares: " + numerosPares);

        scanner.close();
    }
}
