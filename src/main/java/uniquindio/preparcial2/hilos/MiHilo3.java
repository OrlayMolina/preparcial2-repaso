package uniquindio.preparcial2.hilos;

public class MiHilo3 extends Thread{

    private String nombreHilo;

    public MiHilo3(String nombreHilo){
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run(){

        int contador = 1;

        while(contador <= 15){
            System.out.println(nombreHilo);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (contador == 15) {
                System.out.println("Fin del Hilo3");
            }

            contador++;
        }
    }
}
