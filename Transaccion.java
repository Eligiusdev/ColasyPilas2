package ColasyPilas2;

/**
 * Representa una transacción bancaria realizada por un cliente.
 * Puede ser de tipo 'retiro', 'consignación' o 'transferencia'.
 */
public class Transaccion {
    private String tipo;     // Tipo de transacción (retiro, consignación, transferencia)
    private double monto;    // Monto de la transacción
    private String fecha;    // Fecha en que se realizó la transacción

    public Transaccion(String tipo, double monto, String fecha) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getTipo() { return tipo; }
    public double getMonto() { return monto; }
    public String getFecha() { return fecha; }

    @Override
    public String toString() {
        return fecha + " - " + tipo + " $" + monto;
    }
}
