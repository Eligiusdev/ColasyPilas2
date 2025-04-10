package ColasyPilas2;

import java.util.Scanner;

/**
 * Clase de utilidades para validar y leer datos desde consola.
 */
public class Validacion {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Solicita al usuario un texto con mensaje personalizado.
     * @param mensaje Mensaje para mostrar en consola.
     * @return Texto ingresado.
     */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return sc.nextLine();
    }

    /**
     * Solicita un número decimal, validando que sea correcto.
     * @param mensaje Mensaje personalizado.
     * @return Valor double ingresado.
     */
    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }
}
