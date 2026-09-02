import java.util.ArrayList;
import java.util.Random;

public class NumerosAleatorios {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            numeros.add(random.nextInt(100) + 1);
        }

        System.out.println("20 numeros aleatorios entre 1 y 100:");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println((i + 1) + ". " + numeros.get(i));
        }
    }
}
