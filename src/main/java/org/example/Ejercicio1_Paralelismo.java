package org.example;

public class Ejercicio1_Paralelismo {

    static class SumadorParcial extends Thread {

        private final long inicio;
        private final long fin;
        private long resultado;

        public SumadorParcial(String nombre, long inicio, long fin) {
            super(nombre);
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        public void run() {
            resultado = 0;
            for (long i = inicio; i <= fin; i++) {
                resultado += i;
            }
            System.out.println(getName() + " terminó. Suma parcial: " + resultado);
        }

        public long getResultado() {
            return resultado;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        SumadorParcial hilo1 = new SumadorParcial("Hilo-1",       1,  250_000);
        SumadorParcial hilo2 = new SumadorParcial("Hilo-2", 250_001,  500_000);
        SumadorParcial hilo3 = new SumadorParcial("Hilo-3", 500_001,  750_000);
        SumadorParcial hilo4 = new SumadorParcial("Hilo-4", 750_001, 1_000_000);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();

        long total = hilo1.getResultado()
                + hilo2.getResultado()
                + hilo3.getResultado()
                + hilo4.getResultado();

        System.out.println("\nSuma total (1 a 1,000,000): " + total);
    }
}