package com.teamsolemne.pa_solemne2.modelo;

public class Nota {
    // Fields
    private int id, id_alumno, id_asignatura, trimestre;
    private double nota;
    
    // Constructor
    public Nota(int id, int id_alumno, int id_asignatura, int trimestre, double nota) {
        this.id = id;
        this.id_alumno = id_alumno;
        this.id_asignatura = id_asignatura;
        this.trimestre = trimestre;
        this.nota = nota;
    }
    
    // Funcion
    @Override
    public String toString(){
        return String.format("id: %s, id_alumno: %s, id_asignatura: %s, trimestre: %s, nota: %s", id, id_alumno, id_asignatura, trimestre, nota);
    }
    
    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
}
