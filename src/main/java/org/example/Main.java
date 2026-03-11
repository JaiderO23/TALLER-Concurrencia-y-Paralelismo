package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== TALLER: Concurrencia y Paralelismo =====");
            System.out.println("1. Ejercicio 1 – Paralelismo (suma 1 a 1,000,000)");
            System.out.println("2. Ejercicio 2 – Concurrencia (cuenta bancaria)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> Ejercicio1_Paralelismo.main(null);
                case 2 -> Ejercicio2_Concurrencia.main(null);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}