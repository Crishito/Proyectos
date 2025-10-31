package com.crishito.cuentaBancaria;
/*
*Autor: Christian Zumárraga
* Fecha: 22/10/2025
* Descripción: Esta clase, es la clase main y me permite ejecutar mi aplicación
 */


public class Main {
    public static void main(String[] args) {

        // Creación del objeto CuentaAhorros con saldo inicial 50 y tasa anual 5%
        CuentaAhorros miCuenta = new CuentaAhorros(50, 5);

        // Consignaciones
        miCuenta.consignar(25);
        miCuenta.consignar(30);

        // Retiros
        miCuenta.retirar(10);
        miCuenta.retirar(5);
        miCuenta.retirar(2);

        // Generación del extracto mensual
        miCuenta.extractoMensual();

        // Impresión de resultados
        miCuenta.imprimir();
    }
}
