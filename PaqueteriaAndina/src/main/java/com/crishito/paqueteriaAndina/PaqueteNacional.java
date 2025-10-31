package com.crishito.paqueteriaAndina;

/*
 * Autor: Christian Zumárraga
 * Fecha: 27/10/2025
 * Descripción: Clase PaqueteNacional. Implementa la lógica de costos para envíos nacionales.
 * Sobreescribe el método calcularCosto().
 */

public class PaqueteNacional extends Paquete {
    private String zona;

    // Constructor que llama al de la clase base y valida la zona
    public PaqueteNacional(double peso, double largo, double ancho, double alto, String contenido, String zona) {
        super(peso, largo, ancho, alto, contenido);

        zona = zona.toUpperCase();
        if (!(zona.equals("COSTA") || zona.equals("SIERRA") || zona.equals("ORIENTE") || zona.equals("GALAPAGOS")))
            throw new IllegalArgumentException("Zona no válida");

        this.zona = zona;
    }

    // Calcula el costo total según la zona y el recargo volumétrico
    public double calcularCosto() {
        double costo = 3.0 + (1.20 * getPeso());

        if (zona.equals("ORIENTE"))
            costo += 2.0;
        else if (zona.equals("GALAPAGOS"))
            costo += 6.0;

        costo += recargoVolumetrico();
        return costo;
    }
}
