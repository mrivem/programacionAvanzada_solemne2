
package com.teamsolemne.pa_solemne2.modelo;

public class Alumno extends Usuario {
    // Fields
    private int nivel_id;
    private String nombre, apellidos;
    
    // Constructor
    public Alumno(int id, int nivel_id, String login, String clave, String nombre, String apellidos) {
        super(id, login, clave);
        this.nivel_id = nivel_id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    // Functions
    @Override
    public String toString(){
        return String.format("id:%s nivel_id:%s login:%s clave:%s nombre:%s apellidos:%s", id, nivel_id, login, clave, nombre, apellidos);
    }
    
    // Getters y setters
    public int getNivel_id() {
        return nivel_id;
    }

    public void setNivel_id(int nivel_id) {
        this.nivel_id = nivel_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
}
