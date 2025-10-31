package com.crishito.cuentaBancaria;

/*
 * Autor: Christian Zumárraga
 * Fecha: 22/10/2025
 * Descripción: Esta clase denominada CuentaCorriente modela una cuenta corriente,
 * derivada de la clase Cuenta. Permite manejar un sobregiro cuando el retiro supera el saldo.
 */

public class CuentaCorriente extends Cuenta {
    // Atributo que define el valor de sobregiro
    private float sobregiro;

    /*
     * Constructor de la clase CuentaCorriente
     * @param saldo Parámetro que define el saldo inicial de la cuenta
     * @param tasaAnual Parámetro que define el interés anual de la cuenta
     */
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        sobregiro = 0;
    }

    /*
     * Método que permite retirar dinero de la cuenta, actualizando el sobregiro si es necesario
     * @param cantidad Parámetro que define la cantidad de dinero que se desea retirar
     */
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            super.retirar(cantidad);
        } else {
            float restante = cantidad - saldo;
            sobregiro = sobregiro + restante;
            saldo = 0;
            numeroRetiro = numeroRetiro + 1;
        }
    }

    /*
     * Método que permite consignar dinero y reduce el sobregiro si existe
     * @param cantidad Parámetro que define la cantidad de dinero a consignar
     */
    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad > sobregiro) {
                cantidad = cantidad - sobregiro;
                sobregiro = 0;
                saldo = saldo + cantidad;
            } else {
                sobregiro = sobregiro - cantidad;
            }
        } else {
            super.consignar(cantidad);
        }
    }

    /*
     * Método que genera el extracto mensual de la cuenta corriente
     */
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    /*
     * Método que muestra en pantalla el saldo, la comisión, el número de transacciones y el sobregiro
     */
    @Override
    public void imprimir() {
        System.out.println("Saldo: $" + saldo);
        System.out.println("Comisión mensual: $" + comisionmensual);
        System.out.println("Número de transacciones: " + (numeroConsignacion + numeroRetiro));
        System.out.println("Sobregiro: $" + sobregiro);
    }
}
