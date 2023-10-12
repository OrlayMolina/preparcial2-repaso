package uniquindio.preparcial2;

import uniquindio.preparcial2.hilos.MiHilo1;
import uniquindio.preparcial2.hilos.MiHilo2;
import uniquindio.preparcial2.hilos.MiHilo3;

public class MainHilo {

    public static void main(String[] args) {

        MiHilo1 hilo1 = new MiHilo1();
        hilo1.setName("Mi hilo 1");
        hilo1.start();

        MiHilo2 hilo2 = new MiHilo2(2);
        hilo2.setName("Mi hilo 2");
        hilo2.start();

        MiHilo3 hilo3 = new MiHilo3("Roberto");
        hilo3.setName("Mi hilo 3");
        hilo3.start();
    }
}
