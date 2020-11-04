import sun.font.TrueTypeFont;

public class Caja {
    private int fondos=100;
    private boolean disponible = true;

    public synchronized int get() {
        if (fondos>=0){
            while (disponible == false) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        disponible = false;
        }
        notify();
        return fondos;
    }

    public synchronized void put(int fondos) {
        while (disponible == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.fondos = fondos;
        disponible = true;
        notify();
    }
}
