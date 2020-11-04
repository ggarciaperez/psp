public class Proveedor extends Thread{
    private Caja caja;
    private int numero;

    public Proveedor(Caja c, int numero){
        caja=c;
        this.numero = numero;
    }

    public void run(){
        int cCaja = 0, retiro=0;
        for (int i=0;i<5;i++){
            cCaja= caja.get();
            retiro=((int)(Math.random()*50)+1);
            int vari=cCaja-retiro;
            caja.put(vari);
            cCaja= caja.get();
            System.out.println(cCaja);
            System.out.println("Al proveedor "+ this.numero+" se le paga "+retiro+" quedando un total de "+cCaja);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }

}
