package com.crishito.cuentaBancaria;
/*
 *Autor: Christian Zumárraga
 * Fecha: 22/10/2025
 * Descripción: Esta clase denominada cuenta modela una Cuenta Bancaria
 * con los siguientes atributos, saldo, número de consignación, número de retiros
 * tasa anual de interes y a comisión mensual
 */

public class Cuenta {
    //Atributo que define el saldo de la cuenta bancaria
    protected float saldo;
    /*Atributo de número de consignaciones*/
    protected int numeroConsignacion=0;
    /*Atributo de número de retiros*/
    protected int numeroRetiro=0;
    /*Atributo tasa anual*/
    protected float tasaAnual;
    /*Atributo comisión mensual*/
    protected float comisionmensual=0;

    /*
    * Constructor de la clase Cuenta
    * @param saldo Parámetro que define el saldo de la cuenta
    * @param tasaAnual Parametro que define el interes anual de la cuenta
     */

    public Cuenta(float saldo, float tasaAnual){
        this.saldo=saldo;
        this.tasaAnual=tasaAnual;
    }

    /*
     * Método que recibe una cantidad de dinero
     * @param saldo Parámetro que define la cantidad de dinero a consignar en la cuenta
     */
    public void consignar(float cantidad) {
        //Se actualiza el saldo con la cantidad que se deposito
        saldo = saldo + cantidad;
        //Se actualiza el número de depositos
        numeroConsignacion=numeroConsignacion+1;
    }


    /*
     * Método para retirar una cantidad de dinero y actualizar el saldo de la cuenta
     * @param cantidad Parámetro que define la cantidad a retirar
     */
    public void retirar(float cantidad) {
        float nuevoSaldo = saldo + cantidad;
        //Condicional
        if (cantidad <= saldo) {
            saldo -= cantidad;
            //Incrementamos el número de retiros
            numeroRetiro=numeroRetiro+1;
        } else {
            System.out.println("Fondos insuficientes. No se puede realizar el retiro.");
        }
    }


    /*
     * Método que calcula el interés mensual de la cuenta
     */
    public void calcularInteresMensual() {
        //Calculamos el interes mensual
        float tasaMensual = tasaAnual / 12;
        //Valor del interes Mensual
        float interesMensual = saldo * tasaMensual;
        //Actualizar saldo
        saldo = saldo + interesMensual;
    }

    /*
     * Método que genera el extracto mensual de la cuenta
     */
    public void extractoMensual() {
        saldo = saldo - comisionmensual;
        calcularInteresMensual();
    }

    /*
     * Método que muestra en pantalla los valores de los atributos
     */
    public void imprimir() {
        System.out.println("Saldo: $" + saldo);
        System.out.println("Número de consignaciones: " + numeroConsignacion);
        System.out.println("Número de retiros: " + numeroRetiro);
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Comisión mensual: $" + comisionmensual);
    }

}
