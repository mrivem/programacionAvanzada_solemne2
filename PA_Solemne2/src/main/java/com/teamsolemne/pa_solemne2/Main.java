package com.teamsolemne.pa_solemne2;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAlumno;

public class Main {
    public static void main(String[] args){
        System.out.println("PA Solemne 2");
        System.out.println("Integrantes: Javier Hernández D - Matías Rivera M");
        
        Alumno al = new Alumno(1, 1, "login", "clave", "minombre", "apelli dos");
        Asignatura as = new Asignatura(1, 1, 1, "caca");
        
        OperacionesAlumno op = new OperacionesAlumno();
        op.listarNotasAsignatura(al, as);

    }
}
