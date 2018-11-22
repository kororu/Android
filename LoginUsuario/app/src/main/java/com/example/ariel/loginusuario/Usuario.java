package com.example.ariel.loginusuario;

public class Usuario {

    public String Usuario, Nombre, Apellido;
    public int Clave;


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getClave() {
        return Clave;
    }

    public void setClave(int clave) {
        Clave = clave;
    }

    public String getUsuario() {
        return Usuario;

    }

    public Usuario (String nombre, String apellido ,String usuario, int clave){
        this.Nombre = nombre;
        this.Apellido =apellido;
        this.Usuario =usuario;
        this.Clave = clave;
    }
    public  String NombreCompleto (Usuario user) {
        return user.getNombre() + " " + user.getApellido();
    }


}
