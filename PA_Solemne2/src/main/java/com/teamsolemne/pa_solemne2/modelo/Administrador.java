package com.teamsolemne.pa_solemne2.modelo;

public class Administrador extends Usuario {
    
    // Fields
    private String email;
    
    // Constructor
    public Administrador(int id, String login, String clave, String email){
        super(id, login, clave);
        this.email = email;
    }
    
    // Getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
