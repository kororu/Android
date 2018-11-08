package com.example.ariel.calculadora;

public class calculadora {

    public calculadora() {

    }

    public double Sumar(double numero1, double numero2){
        return numero1 + numero2;
    }

    public double Restar(double numero1, double numero2){
        return numero1 - numero2;
    }

    public double Multiplicar(double numero1, double numero2){
        return numero1 * numero2;
    }

    public double Dividir(double dividendo, double divisor){
        return dividendo / divisor;
    }

    public double Potenciar(double base, double exponente){
        return Math.pow(base,exponente);
    }



}
