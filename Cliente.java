package ColasyPilas2;

import java.util.Stack;

public class Cliente {
    private String nombre;
    private String cedula;
    private double saldo;
    private Stack<Transaccion> historial;

    public Cliente(String nombre, String cedula, double saldo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.saldo = saldo;
        this.historial = new Stack<>();
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public double getSaldo() { return saldo; }
    public Stack<Transaccion> getHistorial() { return historial; }

    public void consignar(double monto) { saldo += monto; }

    public boolean retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void agregarTransaccion(Transaccion t) {
        historial.push(t);
    }

    public Transaccion deshacerUltimaTransaccion() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Sin transacciones registradas para este cliente.");
        } else {
            System.out.println("Historial de transacciones de " + nombre + ":");
            for (Transaccion t : historial) {
                System.out.println(t);
            }
        }
    }

    @Override
    public String toString() {
        return nombre + ", " + cedula + ", Saldo: $" + saldo;
    }
}