package org.example;

public class Ejercicio2_Concurrencia {

    static class CuentaBancaria {

        private int saldo;

        public CuentaBancaria(int saldoInicial) {
            this.saldo = saldoInicial;
        }

        public synchronized void retirar(String cliente, int monto) {
            System.out.println(cliente + " intenta retirar " + monto
                    + " | Saldo actual: " + saldo);

            if (saldo >= monto) {
                try { Thread.sleep(50); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                saldo -= monto;
                System.out.println("  ✔ " + cliente + " retiró " + monto
                        + " | Saldo restante: " + saldo);
            } else {
                System.out.println("  ✘ " + cliente
                        + " – Saldo insuficiente. Retiro denegado.");
            }
        }

        public int getSaldo() { return saldo; }
    }

    static class Cliente extends Thread {

        private final CuentaBancaria cuenta;
        private final int monto;

        public Cliente(String nombre, CuentaBancaria cuenta, int monto) {
            super(nombre);
            this.cuenta = cuenta;
            this.monto = monto;
        }

        @Override
        public void run() {
            cuenta.retirar(getName(), monto);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        CuentaBancaria cuenta = new CuentaBancaria(1000);

        Cliente cliente1 = new Cliente("Cliente-1", cuenta, 400);
        Cliente cliente2 = new Cliente("Cliente-2", cuenta, 400);
        Cliente cliente3 = new Cliente("Cliente-3", cuenta, 400);

        cliente1.start();
        cliente2.start();
        cliente3.start();

        cliente1.join();
        cliente2.join();
        cliente3.join();

        System.out.println("\nSaldo final de la cuenta: " + cuenta.getSaldo());
    }
}