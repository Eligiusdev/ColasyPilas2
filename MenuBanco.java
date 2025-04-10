package ColasyPilas2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuBanco {
    public static void main(String[] args) {
        GestorCola gestor = new GestorCola();

        while (true) {
            System.out.println("\n---- BANCO VIRTUAL ----");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar fila de espera");
            System.out.println("3. Atender cliente");
            System.out.println("0. Salir");

            String opcion = Validacion.leerTexto("Elija una opción");
            switch (opcion) {
                case "1" -> {
                    String nombre = Validacion.leerTexto("Nombre del cliente");
                    String cedula = Validacion.leerTexto("Cédula");
                    double saldo = Validacion.leerDouble("Saldo inicial");
                    gestor.encolar(new Cliente(nombre, cedula, saldo));
                }
                case "2" -> gestor.mostrarFila();
                case "3" -> {
                    Cliente c = gestor.atender();
                    if (c != null) {
                        boolean continuar;
                        do {
                            System.out.println("--- Operaciones para " + c.getNombre() + " ---");
                            System.out.println("1. Retirar");
                            System.out.println("2. Consignar");
                            System.out.println("3. Transferir");
                            System.out.println("4. Ver historial");
                            System.out.println("5. Deshacer última transacción");
                            System.out.println("0. Finalizar atención");
                            String op = Validacion.leerTexto("Opción");
                            continuar = true;
                            String fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
                            switch (op) {
                                case "1" -> {
                                    double monto = Validacion.leerDouble("Monto a retirar");
                                    if (c.retirar(monto)) {
                                        c.agregarTransaccion(new Transaccion("Retiro", monto, fecha));
                                        System.out.println("Retiro exitoso.");
                                    } else {
                                        System.out.println("Saldo insuficiente.");
                                    }
                                }
                                case "2" -> {
                                    double monto = Validacion.leerDouble("Monto a consignar");
                                    c.consignar(monto);
                                    c.agregarTransaccion(new Transaccion("Consignación", monto, fecha));
                                    System.out.println("Consignación exitosa.");
                                }
                                case "3" -> {
                                    String cedulaDestino = Validacion.leerTexto("Cédula del destinatario");
                                    Cliente destino = gestor.buscarPorCedula(cedulaDestino);
                                    if (destino != null) {
                                        double monto = Validacion.leerDouble("Monto a transferir");
                                        if (c.retirar(monto)) {
                                            destino.consignar(monto);
                                            c.agregarTransaccion(new Transaccion("Transferencia enviada a " + destino.getNombre(), monto, fecha));
                                            destino.agregarTransaccion(new Transaccion("Transferencia recibida de " + c.getNombre(), monto, fecha));
                                            System.out.println("Transferencia realizada con éxito.");
                                        } else {
                                            System.out.println("Saldo insuficiente para transferir.");
                                        }
                                    } else {
                                        System.out.println("Cliente destino no encontrado en la fila.");
                                    }
                                }
                                case "4" -> c.mostrarHistorial();
                                case "5" -> {
                                    Transaccion ultima = c.deshacerUltimaTransaccion();
                                    if (ultima != null) {
                                        System.out.println("Transacción deshecha: " + ultima);
                                    } else {
                                        System.out.println("No hay transacciones para deshacer.");
                                    }
                                }
                                case "0" -> {
                                    continuar = false;
                                    System.out.println("Atención finalizada.");
                                }
                                default -> System.out.println("Opción inválida.");
                            }
                        } while (continuar);
                    }
                }
                case "0" -> {
                    System.out.println("Gracias por usar el sistema bancario.");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
