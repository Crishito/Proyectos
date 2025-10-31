package com.crishito.paqueteriaAndina;

/*
 * Autor: Christian Zumárraga
 * Fecha: 27/10/2025
 * Descripción: Clase PaqueteInternacional. Implementa la lógica de costos para envíos internacionales.
 * Sobreescribe el método calcularCosto().
 */

public class PaqueteInternacional extends Paquete {
    private String region;

    // Constructor que valida peso máximo y región
    public PaqueteInternacional(double peso, double largo, double ancho, double alto, String contenido, String region) {
        super(peso, largo, ancho, alto, contenido);

        if (peso > 30)
            throw new IllegalArgumentException("El peso máximo para envíos internacionales es de 30 kg");

        region = region.toUpperCase();
        if (!(region.equals("LATAM") || region.equals("NORTH_AMERICA") || region.equals("EUROPE")
                || region.equals("ASIA") || region.equals("AFRICA") || region.equals("OCEANIA")))
            throw new IllegalArgumentException("Región no válida");

        this.region = region;
    }

    // Calcula el costo del envío internacional
    public double calcularCosto() {
        double costo = 10.0 + (2.50 * getPeso());

        String cont = getContenido().toUpperCase();

        if (cont.equals("DOCUMENTOS"))
            costo += 0;
        else if (cont.equals("ELECTRONICA"))
            costo += 8;
        else if (cont.equals("TEXTILES"))
            costo += 4;
        else
            costo += 6;

        if (region.equals("LATAM"))
            costo += 5;
        else if (region.equals("EUROPE") || region.equals("NORTH_AMERICA"))
            costo += 8;
        else
            costo += 12;

        costo += recargoVolumetrico();
        return costo;
    }
}
