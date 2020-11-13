package com.teamsolemne.pa_solemne2;

import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.teamsolemne.pa_solemne2.controlador.ControladorC00;

public class Main {
    public static void main(String[] args){
        System.out.println("PA Solemne 2");
        System.out.println("Integrantes: Javier Hernández D - Matías Rivera M");
        
        ControladorC00 ctrl = new ControladorC00(new P00_InicioSesion());
        ctrl.iniciar();        
    }
}
