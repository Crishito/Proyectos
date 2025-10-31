package com.crishito.cuentaBancaria;

/*
 * Autor: Christian Zumárraga
 * Fecha: 22/10/2025
 * Descripción: Esta clase denominada CuentaAhorros modela una cuenta de ahorros,
 * derivada de la clase Cuenta. Permite determinar si la cuenta está activa o inactiva
 * según su saldo, y redefine métodos para consignar, retirar y generar extractos.
 */

public class CuentaAhorros extends Cuenta {
    // Atributo que indica si la cuenta está activa o no
    private boolean activa;

    /*
     * Constructor de la clase CuentaAhorros
     * @param saldo Parámetro que define el saldo inicial de la cuenta
     * @param tasaAnual Parámetro que define el interés anual de la cuenta
     */
    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        activa = saldo >= 10;
    }

    /*
     * Método que permite consignar dinero si la cuenta está activa
     * @param cantidad Parámetro que define la cantidad de dinero a consignar
     */
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva, no se puede consignar.");
        }
    }

    /*
     * Método que permite retirar dinero si la cuenta está activa
     * @param cantidad Parámetro que define la cantidad de dinero que se desea retirar
     */
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva, no se puede retirar.");
        }
    }

    /*
     * Método que genera el extracto mensual de la cuenta de ahorros
     */
    public void extractoMensual() {
        if (numeroRetiro > 4) {
            comisionmensual = comisionmensual + (numeroRetiro - 4);
        }
        super.extractoMensual();
        activa = saldo >= 10;
    }

    /*
     * Método que muestra en pantalla el saldo, la comisión y el número de transacciones
     */
    public void imprimir() {
        System.out.println("Saldo: $" + saldo);
        System.out.println("Comisión mensual: $" + comisionmensual);
        System.out.println("Número de transacciones: " + (numeroConsignacion + numeroRetiro));
    }
}
