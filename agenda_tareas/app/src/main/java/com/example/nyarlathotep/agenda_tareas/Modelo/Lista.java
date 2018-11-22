package com.example.nyarlathotep.agenda_tareas.Modelo;

import java.util.ArrayList;

public class Lista {
   private String nombre;
    private ArrayList<Tarea> listaTareas;
    static ArrayList<Lista> listadolista=new ArrayList<>();
    private String dueño;

    public Lista(String nombre, ArrayList<Tarea> listaTareas, String dueño) {
        this.nombre = nombre;
        this.listaTareas = listaTareas;
        this.dueño = dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }


    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }
    public static void cargarLista(){
        listadolista.add(new Lista("Personal",new ArrayList<Tarea>(),"aponce"));
        listadolista.add(new Lista("Trabajo",new ArrayList<Tarea>(),"aponce"));
        listadolista.add(new Lista("Universidad",new ArrayList<Tarea>(),"aponce"));

    }


}
