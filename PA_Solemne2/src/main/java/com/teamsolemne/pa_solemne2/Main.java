package com.teamsolemne.pa_solemne2;

import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.modelo.Asignatura;
import com.teamsolemne.pa_solemne2.modelo.Nota;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAlumno;
import com.teamsolemne.pa_solemne2.modelo.OperacionesAutenticacion;
import com.teamsolemne.pa_solemne2.modelo.OperacionesProfesores;
import com.teamsolemne.pa_solemne2.modelo.Profesor;

public class Main {
    public static void main(String[] args){
        System.out.println("PA Solemne 2");
        System.out.println("Integrantes: Javier Hernández D - Matías Rivera M");
        
        
        Alumno al = new Alumno(1, 1, "login", "clave", "minombre", "apelli dos");
        Asignatura as = new Asignatura(1, 1, 1, "caca");
        
        OperacionesAlumno op = new OperacionesAlumno();
        //op.listarNotasAsignatura(al, as);
        //op.registrarAlumno(al);
        
        Profesor pr = new Profesor(1, "profe", "profe", "nombreprofe", "apellidosprofe", "profe@colegio.cl", 1);
        
        OperacionesProfesores opp = new OperacionesProfesores();
        //opp.listarProfesores();
        //opp.listarAsignaturasProfesor(pr);
        //opp.listarAlumnosAsignatura(opp.listarAsignaturasProfesor(pr).get(0));
        //opp.agregarNota(new Nota(-1, 1, 4, 2, 4.5));
        
        OperacionesAutenticacion opa = new OperacionesAutenticacion();
        opa.autenticar("alumno", "alumno".toCharArray());
    }
}
