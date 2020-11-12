package com.teamsolemne.pa_solemne2.modelo;

public class Profesor extends Usuario {
    // Fields
    private int especialista;
    private String nombre, apellidos, email;
    
    // Constructor
    public Profesor(int id, int especialista, String login, String clave, String nombre, String apellidos, String email){
        super(id, login, clave);
        this.especialista = especialista;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }
    
    // Getters y setters
    public int getEspecialista() {
        return especialista;
    }

    public void setEspecialista(int especialista) {
        this.especialista = especialista;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
