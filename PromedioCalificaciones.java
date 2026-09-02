import java.util.ArrayList;
import java.util.Scanner;

public class PromedioCalificaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> calificaciones = new ArrayList<>();

        System.out.println("Ingrese las calificaciones. Escriba \"fin\" para calcular el promedio.");
        while (true) {
            System.out.print("Calificacion: ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                double calificacion = Double.parseDouble(entrada.replace(',', '.'));
                if (calificacion < 0) {
                    System.out.println("La calificacion no puede ser negativa.");
                } else {
                    calificaciones.add(calificacion);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Escriba un numero o \"fin\".");
            }
        }

        if (calificaciones.isEmpty()) {
            System.out.println("No se ingresaron calificaciones.");
        } else {
            double suma = 0;
            for (double calificacion : calificaciones) {
                suma += calificacion;
            }
            double promedio = suma / calificaciones.size();
            System.out.println("Calificaciones: " + calificaciones);
            System.out.printf("Promedio: %.2f%n", promedio);
        }

        scanner.close();
    }
}
