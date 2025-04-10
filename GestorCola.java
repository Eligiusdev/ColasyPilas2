package ColasyPilas2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase encargada de gestionar la cola de clientes en espera.
 */
public class GestorCola {
    private final Queue<Cliente> fila = new LinkedList<>();

    /**
     * Agrega un cliente a la cola.
     */
    public void encolar(Cliente cliente) {
        fila.add(cliente);
        System.out.println("Cliente encolado: " + cliente.getNombre());
    }

    /**
     * Atiende al siguiente cliente en la cola.
     */
    public Cliente atender() {
        if (!fila.isEmpty()) {
            return fila.poll();
        }
        System.out.println("No hay clientes en espera.");
        return null;
    }

    /**
     * Muestra todos los clientes que están en espera.
     */
    public void mostrarFila() {
        if (fila.isEmpty()) {
            System.out.println("La fila está vacía.");
        } else {
            System.out.println("Clientes en espera:");
            for (Cliente c : fila) {
                System.out.println("- " + c.getNombre());
            }
        }
    }

    /**
     * Busca un cliente en la fila por su nombre.
     */
    public Cliente buscarPorNombre(String nombre) {
        for (Cliente c : fila) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Busca un cliente en la fila por su cédula.
     */
    public Cliente buscarPorCedula(String cedula) {
        for (Cliente c : fila) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Devuelve la cola actual de clientes.
     */
    public Queue<Cliente> getFila() {
        return fila;
    }
}

