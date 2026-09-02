import java.util.ArrayList;
import java.util.Scanner;

public class ControlTareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tareasPendientes = new ArrayList<>();
        ArrayList<String> tareasCompletadas = new ArrayList<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    System.out.print("Nueva tarea: ");
                    String tarea = scanner.nextLine().trim();
                    if (tarea.isEmpty()) {
                        System.out.println("La tarea no puede estar vacia.");
                    } else {
                        tareasPendientes.add(tarea);
                        System.out.println("Tarea agregada.");
                    }
                    break;
                case 2:
                    mostrarLista("Tareas pendientes", tareasPendientes);
                    break;
                case 3:
                    if (tareasPendientes.isEmpty()) {
                        System.out.println("No hay tareas pendientes.");
                        break;
                    }
                    mostrarLista("Tareas pendientes", tareasPendientes);
                    int indiceCompletada = leerEntero(scanner, "Indice de la tarea completada: ");
                    if (indiceValido(indiceCompletada, tareasPendientes)) {
                        String completada = tareasPendientes.remove(indiceCompletada);
                        tareasCompletadas.add(completada);
                        System.out.println("Tarea marcada como completada: " + completada);
                    } else {
                        System.out.println("Indice fuera de rango.");
                    }
                    break;
                case 4:
                    if (tareasPendientes.isEmpty()) {
                        System.out.println("No hay tareas pendientes para eliminar.");
                        break;
                    }
                    mostrarLista("Tareas pendientes", tareasPendientes);
                    int indiceEliminar = leerEntero(scanner, "Indice de la tarea que desea eliminar: ");
                    if (indiceValido(indiceEliminar, tareasPendientes)) {
                        System.out.println("Tarea eliminada: " + tareasPendientes.remove(indiceEliminar));
                    } else {
                        System.out.println("Indice fuera de rango.");
                    }
                    break;
                case 5:
                    mostrarLista("Tareas completadas", tareasCompletadas);
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
        System.out.println("\n--- CONTROL DE TAREAS ---");
        System.out.println("1. Agregar tarea pendiente");
        System.out.println("2. Ver tareas pendientes");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Eliminar tarea pendiente");
        System.out.println("5. Ver tareas completadas");
        System.out.println("0. Salir");
    }

    private static void mostrarLista(String titulo, ArrayList<String> tareas) {
        System.out.println("\n" + titulo + ":");
        if (tareas.isEmpty()) {
            System.out.println("La lista esta vacia.");
            return;
        }

        for (int i = 0; i < tareas.size(); i++) {
            System.out.println(i + ": " + tareas.get(i));
        }
    }

    private static boolean indiceValido(int indice, ArrayList<String> lista) {
        return indice >= 0 && indice < lista.size();
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
