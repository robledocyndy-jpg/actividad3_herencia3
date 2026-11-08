// --- CLASE BASE (PADRE) ---
class Producto {
    protected int id;
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            this.precio -= this.precio * (porcentaje / 100);
            System.out.println("Descuento del " + porcentaje + "% aplicado a " + nombre);
        }
    }

    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
        System.out.println("Stock actualizado para " + nombre + ". Nuevo stock: " + this.stock);
    }

    public void mostrarDetalles() {
        System.out.println("----------------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + stock + " unidades");
        System.out.println("----------------------------------------");
    }
}

// --- CLASE DERIVADA 1 ---
class Computadora extends Producto {
    private String procesador;

    public Computadora(int id, String nombre, double precio, int stock, String procesador) {
        super(id, nombre, precio, stock);
        this.procesador = procesador;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Procesador: " + procesador);
        System.out.println("----------------------------------------");
    }
}

// --- CLASE DERIVADA 2 ---
class Accesorio extends Producto {
    private String tipoConexion;

    public Accesorio(int id, String nombre, double precio, int stock, String tipoConexion) {
        super(id, nombre, precio, stock);
        this.tipoConexion = tipoConexion;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo de Conexión: " + tipoConexion);
        System.out.println("----------------------------------------");
    }
}

// --- CLASE PRINCIPAL ---
public class Main {
    public static void main(String[] args) {
        Computadora compu1 = new Computadora(1, "Laptop Dell", 15000.00, 10, "Intel Core i7");
        Accesorio acc1 = new Accesorio(2, "Mouse Inalámbrico", 350.00, 25, "Bluetooth");

        System.out.println("--- ESTADO INICIAL ---");
        compu1.mostrarDetalles();
        acc1.mostrarDetalles();

        System.out.println("\n--- APLICANDO CAMBIOS ---");
        compu1.aplicarDescuento(10);
        acc1.actualizarStock(5);

        System.out.println("\n--- ESTADO FINAL ---");
        compu1.mostrarDetalles();
        acc1.mostrarDetalles();
    }
}
