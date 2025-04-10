package ColasyPilas2;

import java.io.*;
import java.util.Queue;
import java.util.Stack;

/**
 * Clase Exportar que permite guardar e importar información
 * de clientes y transacciones desde/ hacia archivos de texto.
 */
public class Exportar {

    /**
     * Guarda los datos de los clientes en un archivo de texto.
     * @param ruta Ruta del archivo donde se guardarán los datos.
     * @param clientes Cola de clientes a exportar.
     */
    public static void guardarClientes(String ruta, Queue<Cliente> clientes) {
        try (FileWriter writer = new FileWriter(ruta)) {
            for (Cliente c : clientes) {
                writer.write(c.getNombre() + "," + c.getCedula() + "," + c.getSaldo() + "\n");
            }
            System.out.println("Clientes exportados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar clientes: " + e.getMessage());
        }
    }

    /**
     * Guarda las transacciones en un archivo de texto.
     * @param ruta Ruta del archivo.
     * @param transacciones Pila de transacciones a guardar.
     */
    public static void guardarTransacciones(String ruta, Stack<Transaccion> transacciones) {
        try (FileWriter writer = new FileWriter(ruta)) {
            for (Transaccion t : transacciones) {
                writer.write(t.getTipo() + "," + t.getMonto() + "," + t.getFecha() + "\n");
            }
            System.out.println("Transacciones exportadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar transacciones: " + e.getMessage());
        }
    }

    /**
     * Importa clientes desde un archivo y los agrega a la cola.
     * @param ruta Ruta del archivo.
     * @param clientes Cola de clientes a llenar.
     */
    public static void importarClientes(String ruta, Queue<Cliente> clientes) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String cedula = partes[1];
                    double saldo = Double.parseDouble(partes[2]);
                    clientes.add(new Cliente(nombre, cedula, saldo));
                }
            }
            System.out.println("Clientes importados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al importar clientes: " + e.getMessage());
        }
    }

    /**
     * Importa transacciones desde un archivo y las agrega a la pila.
     * @param ruta Ruta del archivo.
     * @param transacciones Pila de transacciones a llenar.
     */
    public static void importarTransacciones(String ruta, Stack<Transaccion> transacciones) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String tipo = partes[0];
                    double monto = Double.parseDouble(partes[1]);
                    String fecha = partes[2];
                    transacciones.push(new Transaccion(tipo, monto, fecha));
                }
            }
            System.out.println("Transacciones importadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al importar transacciones: " + e.getMessage());
        }
    }
}
