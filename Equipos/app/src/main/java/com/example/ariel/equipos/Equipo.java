package com.example.ariel.equipos;

import java.io.Serializable;

public class Equipo implements Serializable {

    private String serie, descripcion;
    private double valor;
    public Equipo(){

    }

    public Equipo(String serie, String descripcion, double valor) {
        this.serie = serie;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString(){
        return descripcion + " - $" + valor;
    }




}
