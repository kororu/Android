package com.example.joseguzman.agenda.Modelo;

import java.io.Serializable;
import java.util.Date;

public class Tarea implements Serializable {

    private int id;
    private String detalle;
    private Date fechaInicio;
    private Date fechaTermino;
    private boolean terminada;

    public Tarea(String detalle, Lista l) {
        this.id = nextId(l);
        this.detalle = detalle;
        this.fechaInicio = new Date();
    }

    private int nextId(Lista l){
        if(l.getLista().size() == 0){
            return 1;
        }
        return l.getLista().get(l.getLista().size()-1).getId()+1;
    }

    public int getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }

    @Override
    public String toString() {
        return detalle;
    }
}
