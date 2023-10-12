package uniquindio.preparcial2.hilos;

public class MiHilo2 extends Thread{

    long entero;

    public MiHilo2(long entero) {
        this.entero = entero;
    }


    @Override
    public void run() {

        int contador = 0;
        while(contador < 10){

            entero *= 2;
            System.out.println("hilo2: " + entero);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(contador == 9){
                System.out.println("Fin del Hilo2");
            }

            contador++;
        }

    }
}
