package com.example.nyarlathotep.agenda_tareas.Modelo;

public class Tarea {
    private String nombreTarea, descripcion;
    private boolean terminada;

    public Tarea(String nombreTarea, String descripcion, boolean terminada) {
        this.nombreTarea = nombreTarea;
        this.descripcion = descripcion;
        this.terminada = terminada;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }
}
