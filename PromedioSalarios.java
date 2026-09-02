import java.util.ArrayList;
import java.util.Scanner;

public class PromedioSalarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();

        System.out.println("REGISTRO DE EMPLEADOS");
        System.out.println("Escriba \"fin\" como nombre para terminar.");

        while (true) {
            System.out.print("\nNombre del empleado: ");
            String nombre = scanner.nextLine().trim();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacio.");
                continue;
            }

            double salario = leerSalario(scanner);
            empleados.add(new Empleado(nombre, salario));
        }

        if (empleados.isEmpty()) {
            System.out.println("No se registraron empleados.");
        } else {
            double sumaSalarios = 0;
            System.out.println("\nEmpleados registrados:");
            for (Empleado empleado : empleados) {
                System.out.printf("- %s: Q%.2f%n", empleado.getNombre(), empleado.getSalario());
                sumaSalarios += empleado.getSalario();
            }

            double promedio = sumaSalarios / empleados.size();
            System.out.printf("Promedio de salarios: Q%.2f%n", promedio);
        }

        scanner.close();
    }

    private static double leerSalario(Scanner scanner) {
        while (true) {
            System.out.print("Salario: Q");
            String entrada = scanner.nextLine().trim().replace(',', '.');
            try {
                double salario = Double.parseDouble(entrada);
                if (salario < 0) {
                    System.out.println("El salario no puede ser negativo.");
                } else {
                    return salario;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Escriba un salario numerico.");
            }
        }
    }
}

class Empleado {
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }
}
