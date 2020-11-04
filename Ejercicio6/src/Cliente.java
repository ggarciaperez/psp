public class Cliente extends Thread{
    private Caja caja;
    private int numero;

    public Cliente(Caja c, int numero){
        caja=c;
        this.numero = numero;
    }

    public void run(){
        int cCaja = 0, ingreso=0;
        for (int i=0;i<10;i++){
            cCaja= caja.get();
            ingreso=((int)(Math.random()*10)+1);
            caja.put(cCaja+ingreso);
            cCaja= caja.get();
            System.out.println("El Cliente "+ this.numero+" deposita "+ingreso+" dejando un total de "+cCaja);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
