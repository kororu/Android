package com.example.ariel.tareas;

import java.util.Date;

public class Tareas {
    private int id;
    private String Descripcion, Estado;
    private Date Fecha , FechaTermino;

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public Date getFecha() {
        return Fecha;
    }

    public Date getFechaTermino() {
        return FechaTermino;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public void setFechaTermino(Date fechaTermino) {
        FechaTermino = fechaTermino;
    }
}
