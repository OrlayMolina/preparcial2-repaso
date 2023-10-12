package uniquindio.preparcial2.hilos;

public class MiHilo1 extends Thread{

    int[] numeros;

    public MiHilo1(){
        this.numeros = new int[]{5, 4, 6, 9, 8, 9};
    }

    @Override
    public void run() {


        for (int contador = 0; contador <= numeros.length - 1; contador++) {
            System.out.println(numeros[contador]);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (contador == numeros.length - 1) {
                System.out.println("Fin del Hilo1");
            }

        }
    }
}
