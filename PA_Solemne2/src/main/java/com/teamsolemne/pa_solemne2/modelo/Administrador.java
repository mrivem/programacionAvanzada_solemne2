package com.teamsolemne.pa_solemne2.modelo;

public class Administrador extends Usuario {
    
    // Fields
    private String email;
    
    // Constructor
    public Administrador(int id, String login, String clave, String email){
        super(id, login, clave);
        this.email = email;
    }
    
    // Funciones
    @Override
    public String toString(){
        return String.format("id: %s, login: %s, clave: %s, email: %s", getId(), getLogin(), getClave(), email);
    }
    
    // Getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
