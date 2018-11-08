package com.example.joseguzman.agenda.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lista implements Serializable{

    private int id;
    private String nombre;
    private List<Tarea> lista;

    public Lista() {
    }

    public Lista(String nombre) {
        this.id = 1;
        this.nombre = nombre;
        this.lista = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tarea> getLista() {
        return lista;
    }

    public void añadirTarea(Tarea t) {
        this.lista.add(t);
    }


}
