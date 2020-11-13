package com.teamsolemne.pa_solemne2.modelo;

public class Profesor extends Usuario {
    // Fields
    private int especialista;
    private String nombre, apellidos, email;
    
    // Constructor
    public Profesor(int id, String login, String clave, String nombre, String apellidos, String email, int especialista){
        super(id, login, clave);
        this.especialista = especialista;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }
    
    // Funciones
    @Override
    public String toString(){
        return String.format("id: %s, login: %s, clave: %s, nombre: %s, apellidos: %s, email: %s, especialista: %s", getId(), getLogin(), getClave(), nombre, apellidos, email, especialista);
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
