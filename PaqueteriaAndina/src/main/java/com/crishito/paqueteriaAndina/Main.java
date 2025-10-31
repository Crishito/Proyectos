package com.crishito.paqueteriaAndina;
import java.util.Scanner;

/*
 * Autor: Christian Zumárraga
 * Fecha: 27/10/2025
 * Descripción: Clase Main para la demostración del sistema de Paquetería Andina.
 * Crea objetos, usa el polimorfismo y demuestra el encapsulamiento.
 * Permite la entrada de datos por teclado.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("PAQUETERÍA ANDINA");

            // Primer paquete nacional (zona costa)
            System.out.println("\nCreando paquete nacional...");
            PaqueteNacional p1 = new PaqueteNacional(5, 50, 30, 20, "ropa", "COSTA");

            // Segundo paquete nacional (zona galápagos)
            System.out.println("\nCreando paquete nacional a Galápagos...");
            PaqueteNacional p2 = new PaqueteNacional(8, 70, 40, 30, "libros", "GALAPAGOS");

            // Paquete internacional hacia Europa
            System.out.println("\nCreando paquete internacional a Europa...");
            PaqueteInternacional p3 = new PaqueteInternacional(10, 60, 40, 40, "ELECTRONICA", "EUROPE");

            // Mostrar resúmenes (polimorfismo)
            System.out.println("\nRESÚMENES DE ENVÍOS");
            System.out.println(p1.resumen());
            System.out.println(p2.resumen());
            System.out.println(p3.resumen());

            // Intentar crear un paquete internacional con exceso de peso
            System.out.println("\nIntentando crear un paquete internacional de 35 kg...");
            PaqueteInternacional p4 = new PaqueteInternacional(35, 50, 40, 40, "TEXTILES", "ASIA");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
