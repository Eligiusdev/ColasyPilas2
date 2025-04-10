package ColasyPilas2;

import java.util.Stack;

/**
 * Clase encargada de manejar el historial de transacciones por cliente.
 */
public class Historial {
    private final Stack<Transaccion> transacciones = new Stack<>();

    /**
     * Agrega una transacción al historial.
     */
    public void agregarTransaccion(Transaccion t) {
        transacciones.push(t);
    }

    /**
     * Muestra todas las transacciones realizadas.
     */
    public void mostrarHistorial() {
        if (transacciones.isEmpty()) {
            System.out.println("Sin transacciones aún.");
        } else {
            System.out.println("Historial de transacciones:");
            for (Transaccion t : transacciones) {
                System.out.println(t);
            }
        }
    }

    /**
     * Elimina y devuelve la última transacción realizada.
     */
    public Transaccion deshacerUltima() {
        if (!transacciones.isEmpty()) {
            return transacciones.pop();
        }
        System.out.println("No hay transacciones para deshacer.");
        return null;
    }

    /**
     * Devuelve la pila actual de transacciones.
     */
    public Stack<Transaccion> getTransacciones() {
        return transacciones;
    }
}
