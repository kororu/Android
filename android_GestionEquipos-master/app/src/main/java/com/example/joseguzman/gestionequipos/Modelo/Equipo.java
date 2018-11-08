package com.example.joseguzman.gestionequipos.Modelo;

        import java.io.Serializable;

public class Equipo implements Serializable{

    private String serie, descripción;
    private double valor;

    public Equipo() {
    }

    public Equipo(String serie, String descripción, double valor) {
        this.serie = serie;
        this.descripción = descripción;
        this.valor = valor;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descripción + " - $" + valor;
    }
}
