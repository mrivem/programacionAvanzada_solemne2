package com.teamsolemne.pa_solemne2.modelo;

public class Nivel {
    // Fields
    private int id;
    private String nivel, curso, aula;

    // Constructor
    public Nivel(int id, String nivel, String curso, String aula) {
        this.id = id;
        this.nivel = nivel;
        this.curso = curso;
        this.aula = aula;
    }
    
    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
    
    
}
