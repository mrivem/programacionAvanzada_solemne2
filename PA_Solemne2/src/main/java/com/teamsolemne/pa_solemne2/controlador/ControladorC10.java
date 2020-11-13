package com.teamsolemne.pa_solemne2.controlador;

import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.teamsolemne.pa_solemne2.modelo.Alumno;
import com.teamsolemne.pa_solemne2.vista.P10_VistaAlumno;
import com.teamsolemne.pa_solemne2.vista.P40_ListaCompartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorC10 implements ActionListener {
    
    private final P10_VistaAlumno frame;
    private final Alumno user;

    public ControladorC10(P10_VistaAlumno frame, Alumno user) {
        this.frame = frame;
        this.user = user;
        setListeners();
    }
    
    private void setListeners(){
        frame.jButton_cerrarSesion.addActionListener(this);
        frame.jButton_consultarNotas.addActionListener(this);
        frame.jButton_listarCompaneros.addActionListener(this);
        frame.jButton_listarProfesores.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Portal Alumno");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        if(e.getSource() == frame.jButton_listarCompaneros){
            ControladorC11 con = new ControladorC11(new P40_ListaCompartida(), user);
            con.iniciar();
            frame.dispose();
        }
        
        if(e.getSource() == frame.jButton_listarProfesores){
            ControladorC12 con = new ControladorC12(new P40_ListaCompartida(), user);
            con.iniciar();
            frame.dispose();
        }
        
        if(e.getSource() == frame.jButton_consultarNotas){
            ControladorC13 con = new ControladorC13(new P40_ListaCompartida(), user);
            con.iniciar();
            frame.dispose();
        }
        
        if(e.getSource() == frame.jButton_cerrarSesion){
            ControladorC00 con = new ControladorC00(new P00_InicioSesion());
            con.iniciar();
            frame.dispose();
        }
    }
    
}
