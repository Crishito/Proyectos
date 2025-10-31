package com.crishito.paqueteriaAndina;

/*
 * Autor: Christian Zumárraga
 * Fecha: 27/10/2025
 * Descripción: Clase abstracta Paquete. Define atributos comunes y métodos abstractos
 * para el cálculo de tarifas de envío, aplicando encapsulamiento.
 */
// clase base abstracta para todo tipo de envío
public abstract class Paquete {
    // Atributos privados para proteger los datos (encapsulamiento)
    private double peso;
    private double largo;
    private double ancho;
    private double alto;
    private String contenido;

    // Constructor que recibe los valores y valida que sean correctos
    public Paquete(double peso, double largo, double ancho, double alto, String contenido) {
        if (peso < 0.01 || peso > 50.0)
            throw new IllegalArgumentException("El peso debe estar entre 0.01 y 50 kg");
        if (largo < 1 || largo > 200 || ancho < 1 || ancho > 200 || alto < 1 || alto > 200)
            throw new IllegalArgumentException("Las dimensiones deben estar entre 1 y 200 cm");
        if (contenido == null || contenido.trim().isEmpty())
            throw new IllegalArgumentException("El contenido no puede estar vacío");

        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.contenido = contenido;
    }

    // Métodos getter públicos para acceder a los atributos
    public double getPeso() {
        return peso;
    }

    public double getLargo() {
        return largo;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    public String getContenido() {
        return contenido;
    }

    // Método para calcular el volumen en litros
    public final double volumenLitros() {
        return (largo * ancho * alto) / 1000.0;
    }

    // Método protegido que agrega recargo si el volumen pasa de 100 litros
    protected double recargoVolumetrico() {
        if (volumenLitros() > 100)
            return 5.0;
        else
            return 0.0;
    }

    // Método abstracto que las subclases deben implementar
    public abstract double calcularCosto();

    // Método que devuelve un resumen del envío
    public String resumen() {
        return "Tipo de paquete: " + this.getClass().getSimpleName()
                + "\nPeso: " + peso + " kg"
                + "\nVolumen: " + volumenLitros() + " L"
                + "\nCosto final: $" + calcularCosto() + "\n";
    }
}