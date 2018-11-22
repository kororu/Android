package com.example.nyarlathotep.agenda_tareas.Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private String usuario, nombre, apellido, clave;
    public static ArrayList<Usuario> LosUsuarios = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String usuario, String nombre, String apellido, String clave) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public static void cargadatos(){
        LosUsuarios.add(new Usuario("aponce","Ariel","Ponce","123"));

    }
}
