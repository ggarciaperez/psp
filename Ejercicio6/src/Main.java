public class Main {

    public static void main(String[] args) {
        Caja c = new Caja();
        Proveedor p1 = new Proveedor(c, 1);
        Cliente c1 = new Cliente(c, 1);

        c1.start();
        p1.start();
    }
}
