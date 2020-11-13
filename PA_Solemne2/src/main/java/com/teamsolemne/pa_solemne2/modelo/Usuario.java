package com.teamsolemne.pa_solemne2.modelo;

public class Usuario {
    private int id;
    private String login, clave;

    public Usuario(int id, String login, String clave) {
        this.id = id;
        this.login = login;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
